package UnitTestingLab.src.main.java.rpg_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dummy implements Target{

    private int health;
    private int experience;
    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = List.of(new Axe(1, 2),  new Axe(2, 2));
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public int getExperience() { return experience; }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }

    @Override
    public Weapon targetGivingRandomWeapons() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }
        Random random = new Random();
        return this.possibleLoot.get(random.nextInt());
    }
}
