/*
package UnitTestingLab.src.test.java.rpg_lab;

import org.junit.jupiter.api.Test;
import org.mockito.MockingDetails;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTests {
    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        //Arrange
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(10);

        Hero hero = new Hero("John", weaponMock);

        //Act
        hero.attack(targetMock);

        //Asset
        assertEquals(10, hero.getExperience(), "Wrong experience");
    }

    @Test
    public void whenTargetIsKilled_thenHeroGetWeapon() {
        //Arrange
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);
        Mockito.when(targetMock.isDead()).thenReturn(true);

        Hero hero = new Hero("John", weaponMock);

        //Act
        hero.attack(targetMock);

        //Asset
        assertTrue(hero.getInventory().iterator().hasNext(), "Inventory is empty");
    }

    @Test
    public void testConstructor() {
        //Arrange
        Hero hero = new Hero("John", new Axe(2, 2));

        //Act and Assert
        assertEquals("John", hero.getName());
        assertEquals("Axe", hero.getWeapon().getClass().getSimpleName());

    }
}
*/
