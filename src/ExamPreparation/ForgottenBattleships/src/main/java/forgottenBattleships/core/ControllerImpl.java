package forgottenBattleships.core;

import forgottenBattleships.entities.battleship.Battleship;
import forgottenBattleships.entities.battleship.PirateBattleship;
import forgottenBattleships.entities.battleship.RoyalBattleship;
import forgottenBattleships.entities.battlezone.BattleZone;
import forgottenBattleships.entities.battlezone.BattleZoneImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;

import static forgottenBattleships.common.ConstantMessages.*;
import static forgottenBattleships.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{

    Collection<BattleZone> battleZones;

    public ControllerImpl() {
        this.battleZones = new ArrayList<>();
    }

    @Override
    public String addBattleZone(String battleZoneName, int capacity) {
        BattleZone battleZone;

        boolean existBattleZone = battleZones.stream().anyMatch(zone -> zone.getName().equals(battleZoneName));

        if (existBattleZone) {
            throw new IllegalArgumentException(BATTLE_ZONE_EXISTS);
        }

        battleZone = new BattleZoneImpl(battleZoneName, capacity);
        battleZones.add(battleZone);
        return SUCCESSFULLY_ADDED_BATTLE_ZONE.formatted(battleZoneName);
    }

    @Override
    public BattleZone getBattleZoneByName(String battleZoneName) {
        return battleZones.stream().filter(zone -> zone.getName().equals(battleZoneName)).findFirst().orElse(null);
    }

    @Override
    public String addBattleshipToBattleZone(String battleZoneName, String shipType, String shipName, int health) {
        if (getBattleZoneByName(battleZoneName) == null) {
            throw new NullPointerException(BATTLE_ZONE_DOES_NOT_EXISTS);
        }

        Battleship ship;
        if (shipType.equals("PirateBattleship")) {
            ship = new PirateBattleship(shipName, health);
        }
        else if (shipType.equals("RoyalBattleship")) {
            ship = new RoyalBattleship(shipName, health);
        }
        else {
            throw new IllegalArgumentException(INVALID_SHIP_TYPE);
        }

        boolean shipExist = getBattleZoneByName(battleZoneName).getShips().stream().anyMatch(s -> s.getName().equals(shipName));
        if (shipExist) {
            throw new IllegalArgumentException(SHIP_EXISTS);
        }
        getBattleZoneByName(battleZoneName).addBattleship(ship);
        return SUCCESSFULLY_ADDED_SHIP.formatted(shipType, shipName, battleZoneName);
    }

    @Override
    public String startBattle(String battleZoneName, String attackingShip, String shipUnderAttack) {
        BattleZone battleZone = getBattleZoneByName(battleZoneName);

        boolean attackingShipExist = getBattleZoneByName(battleZoneName).getShips().stream().anyMatch(s -> s.getName().equals(attackingShip));
        boolean attackedShipExist = getBattleZoneByName(battleZoneName).getShips().stream().anyMatch(s -> s.getName().equals(shipUnderAttack));

        if (!attackedShipExist || !attackingShipExist) {
            throw new IllegalArgumentException(INSUFFICIENT_COUNT);
        }

        Battleship attackerShip = battleZone.getBattleshipByName(attackingShip);
        Battleship attackedShip = battleZone.getBattleshipByName(shipUnderAttack);

        if (attackerShip.getAmmunition() > 0) {
            attackerShip.attack(attackedShip);
            attackedShip.takeDamage(attackerShip);
        }

        if (attackedShip.getHealth() <= 0) {
            battleZone.removeBattleShip(attackedShip);
        }

        StringJoiner joiner = new StringJoiner(", ");
        getBattleZoneByName(battleZoneName).getShips().forEach(s -> joiner.add(s.getName()));

        StringBuilder builder = new StringBuilder();
        builder.append(BATTLE_CONTINUES.formatted(battleZoneName)).append(joiner);

        return builder.toString();

    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        battleZones.forEach(battleZone -> {
            builder.append(SHIPS_IN_BATTLE_ZONE.formatted(battleZone.getName())).append(System.lineSeparator());
            if (battleZone.getShips().size() > 1) {
                battleZone.getShips().forEach(s -> builder.append(SHIP_INFO.formatted(s.getName(), s.getHealth(), s.getAmmunition())).append(System.lineSeparator()));
            }
            else {
                Battleship ship = battleZone.getShips().stream().findFirst().get();
                builder.append(SHIP_WINS.formatted(ship.getName())).append(System.lineSeparator());
            }
        });

        return builder.toString();
    }
}
