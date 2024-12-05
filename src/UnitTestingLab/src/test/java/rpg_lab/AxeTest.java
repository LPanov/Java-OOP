/*
package UnitTestingLab.src.test.java.rpg_lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
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
    public void weaponAttacksLosesDurability() {
        //Arrange
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);

        //Act
        axe.attack(new Dummy(DUMMY_HEALTH, DUMMY_XP));

        //Assert
        assertEquals(9, axe.getDurabilityPoints());
    }

    @Test
    public void whenAxeHas0PointsDurability_thenExpectIllegalStateException() {
        //Arrange
        axe = new Axe(AXE_ATTACK, 0);

        //Assert and Act
        assertThrows(IllegalStateException.class, () -> {
            axe.attack(new Dummy(DUMMY_HEALTH, DUMMY_XP));
        });
    }

    @Test
    public void testConstructor() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILITY);

        assertEquals(AXE_ATTACK, axe.getAttackPoints());
        assertEquals(AXE_DURABILITY, axe.getDurabilityPoints());
    }

}
*/
