/*
package UnitTestingLab.src.test.java.rpg_lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DummyTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private static final int EXPECTED_DURABILITY = AXE_DURABILITY - 1;

    private Axe axe;
    private Dummy dummy;

    @BeforeEach
    public void initializeTestObjects() {
        this.axe = null;
        this.dummy = null;
    }

    @Test
    public void dummyLosesHealthWhenAttacked()  {
        //Arrange
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);

        //Act
        this.dummy.takeAttack(AXE_ATTACK);

        //Assert
        assertEquals(DUMMY_HEALTH - AXE_ATTACK, dummy.getHealth());
    }

    @Test
    public void deadDummyThrowsExceptionIfGetAttacked() {
        //Arrange
        dummy = new Dummy(0, DUMMY_XP);

        assertThrows(IllegalStateException.class, () -> {
            //Act
            this.dummy.takeAttack(AXE_ATTACK);
        });

    }

    @Test
    public void deadDummyCanGiveXP () {
        //Arrange
        dummy = new Dummy(0, DUMMY_XP);

        //Act
        int takenXP = dummy.giveExperience();

        //Assert
        assertEquals(DUMMY_XP, takenXP);
    }

    @Test
    public void aliveDummyCantGiveXP() {
        //Arrange
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);

        Assertions.assertThrows(IllegalStateException.class, () -> {
            //Act
            this.dummy.giveExperience();
        });
    }

    @Test
    public void testConstructor() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_XP);

        assertEquals(DUMMY_HEALTH, dummy.getHealth());
        assertEquals(DUMMY_XP, dummy.getExperience());
    }

}
*/
