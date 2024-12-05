/*
package p05_CustomLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {
    private CustomLinkedList<String> customLinkedList;

    @BeforeEach
    public void setUp() {
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("A");
        customLinkedList.add("B");
        customLinkedList.add("C");
    }

    @Test
    public void testConstructor() {
        assertNotEquals(null, customLinkedList);
    }

    @Test
    public void testGetMethod_whenIndexLessThan0() {
        assertThrows(IllegalArgumentException.class, () -> {
           customLinkedList.get(-1);
        });
    }
    @Test
    public void testGetMethod_whenIndexOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> {
            customLinkedList.get(4);
        });
    }
    @Test
    public void testGetMethod_whenIndexInBounds() {
        String expectedResult = "A";

        String actualResult = customLinkedList.get(0);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testSetMethod_whenIndexLessThan0() {
        assertThrows(IllegalArgumentException.class, () -> {
            customLinkedList.set(-1, "a");
        });
    }
    @Test
    public void testSetMethod_whenIndexOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> {
            customLinkedList.set(4, "a");
        });
    }

    @Test
    public void testSetMethod_whenIndexInBounds() {
        String expectedResult = "a";

        customLinkedList.set(1, "a");
        String actualResult = customLinkedList.get(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddMethod() {
        customLinkedList.add("D");

        assertEquals("D", customLinkedList.get(3));
    }

    @Test
    public void testRemoveAtMethod_whenIndexLessThan0() {
        assertThrows(IllegalArgumentException.class, () -> {
            customLinkedList.removeAt(-1);
        });
    }
    @Test
    public void testRemoveAtMethod_whenIndexOutOfBounds() {
        assertThrows(IllegalArgumentException.class, () -> {
            customLinkedList.removeAt(4);
        });
    }

    @Test
    public void testRemoveAtMethod_whenIndexInBounds() {
        String expectedResult = "B";

        String actualResult = customLinkedList.removeAt(1);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testContainsMethod_ShouldReturnTrueIfObjectExist() {
        assertTrue(customLinkedList.contains("A"));
    }

    @Test
    public void testRemoveMethod_whenObjectExist() {
        customLinkedList.add("D");
        customLinkedList.remove("B");
        customLinkedList.remove("A");
        customLinkedList.remove("D");

        assertFalse(customLinkedList.contains("A"));
        assertFalse(customLinkedList.contains("B"));
        assertFalse(customLinkedList.contains("D"));
    }

    @Test
    public void testRemoveMethod_whenObjectDonNotExist() {
        assertEquals(-1, customLinkedList.remove("D"));
    }

}
*/
