/*
package p03_IteratorTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class ListIteratorTest {
    private String[] elements;
    private ListIterator listIterator;

    @BeforeEach
    public void setUp() throws OperationNotSupportedException {
        elements = new String[]{"A", "B", "C"};
        listIterator = new ListIterator(elements);
    }

    @Test
    public void testConstructorShouldThrowExceptionIfParameterIsNull() {
        //Act and Assert
        assertThrows(OperationNotSupportedException.class, () -> {
            ListIterator listIterator = new ListIterator(null);
        });
    }

    @Test
    public void testConstructor() {
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void testMove_whenHasNext() {
        String expectedResult = elements[1];

        listIterator.move();

        String actualResult = listIterator.print();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMove_whenHasNotNext() throws OperationNotSupportedException {
        listIterator = new ListIterator();

        assertFalse(listIterator.move());
    }

    @Test
    public void testPrintShouldThrowException_whenArrayIsEmpty() throws OperationNotSupportedException {
        listIterator = new ListIterator();

        assertThrows(IllegalStateException.class, () -> {
            listIterator.print();
        });
    }

    @Test
    public void testPrintMethod() {
        String expectedResult = elements[0];

        String actualResult = listIterator.print();

        assertEquals(expectedResult, actualResult);
    }

}
*/
