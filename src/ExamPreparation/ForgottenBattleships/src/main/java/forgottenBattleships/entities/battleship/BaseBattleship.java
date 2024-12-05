package forgottenBattleships.entities.battleship;

import static forgottenBattleships.common.ExceptionMessages.SHIP_NAME_NULL_OR_EMPTY;

public abstract class BaseBattleship implements Battleship{
    private String name;
    private int health;
    private int ammunition;
    private int hitStrength;

    public BaseBattleship(String name, int health, int ammunition, int hitStrength) {
        this.setName(name);
        this.setHealth(health);
        this.setAmmunition(ammunition);
        this.hitStrength = hitStrength;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SHIP_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setHealth(int health) {
        if (health <= 0) {
            health = 0;
        }
        this.health = health;
    }

    private void setAmmunition(int ammunition) {
        if (ammunition <= 0) {
            ammunition = 0;
        }
        this.ammunition = ammunition;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getHitStrength() {
        return hitStrength;
    }

    @Override
    public int getAmmunition() {
        return ammunition;
    }

    @Override
    public void attack(Battleship attackingShip) {
        this.setAmmunition(this.getAmmunition() - this.getHitStrength());
    }

    @Override
    public void takeDamage(Battleship battleship) {
        this.setHealth(this.getHealth() - battleship.getHitStrength());
    }
}
