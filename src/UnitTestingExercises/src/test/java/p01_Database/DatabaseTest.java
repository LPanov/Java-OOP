package p01_Database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private Integer[] elements;
    private Database database;

    @BeforeEach
    public void setUp() throws OperationNotSupportedException {
        elements = new Integer[] {1, 2, 3, 4, 5};

        this.database = new Database(elements);
    }

    @Test
    public void whenElementsAreGreaterThan16_thenConstructorThrowsException() {
        //Arrange
        Integer[] elements = new Integer[17];

        //Act and Assert
        assertThrows(OperationNotSupportedException.class, () -> {
            Database database = new Database(elements);
        });
    }

    @Test
    public void whenElementsAreSmallerThan1_thenConstructorThrowsException() {

        //Act and Assert
        assertThrows(OperationNotSupportedException.class, () -> {
            Database database = new Database();
        });
    }

    @Test
    public void testConstructorShouldCreateCorrectDatabase() throws OperationNotSupportedException {
        //Arrange
        Integer[] expectedResult = elements;

        //Act
        Integer[] actualResult = database.getElements();

        //Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void whenAddNullElement_thenShouldThrowException() {
        assertThrows(OperationNotSupportedException.class, () -> {
            database.add(null);
        });
    }

    @Test
    public void whenAddElementShouldAddToTheLastPosition() throws OperationNotSupportedException {
        database.add(15);

        Integer[] elements = database.getElements();
        int size = elements.length;

        Integer actualElements = elements[size - 1];
        Integer expectedElement = 15;

        assertEquals(expectedElement, actualElements);
    }

    @Test
    public void whenAddElementShouldIncreaseElementsSize() throws OperationNotSupportedException {
        database.add(15);

        Integer[] elements = database.getElements();
        int actualSize = elements.length;
        int expectedSize = 6;

        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void whenRemoveFromEmptyList_thenShouldThrowException() throws OperationNotSupportedException {
        database = new Database(1);
        database.remove();

        assertThrows(OperationNotSupportedException.class, () -> {
            database.remove();
        });
    }

    @Test
    public void whenRemoveElementShouldRemoveToTheLastPosition() throws OperationNotSupportedException {
        Integer[] elements = database.getElements();
        database.remove();

        Integer actualElements = elements[elements.length - 2];
        Integer expectedElement = 4;

        assertEquals(expectedElement, actualElements);
    }
}
