package UnitTestingLab.src.main.java.rpg_lab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Hero implements HeroInventory{

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> inventory;

    public Hero(String name, Weapon weapon) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    @Override
    public Iterable<Weapon> getInventory() {
        return inventory;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.inventory.add(target.targetGivingRandomWeapons());
        }
    }
}
