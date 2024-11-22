package UnitTestingLab.src.main.java.rpg_lab;

public interface Target {
    void takeAttack(int attackPoints);

    int getHealth();

    int giveExperience();

    boolean isDead();

    Weapon targetGivingRandomWeapons();
}
