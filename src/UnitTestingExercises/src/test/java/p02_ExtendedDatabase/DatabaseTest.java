package p02_ExtendedDatabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private static final Person PERSON1 = Mockito.mock(Person.class);
    private static final Person PERSON2 = Mockito.mock(Person.class);
    private static final Person PERSON3 = Mockito.mock(Person.class);
    private Database database;

    @BeforeEach
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PERSON1, PERSON2, null, PERSON3);

        Mockito.when(PERSON1.getUsername()).thenReturn("Peter");
        Mockito.when(PERSON2.getUsername()).thenReturn("Kaloyan");
        Mockito.when(PERSON3.getUsername()).thenReturn("Sofia");

        Mockito.when(PERSON1.getId()).thenReturn(1);
        Mockito.when(PERSON2.getId()).thenReturn(2);
        Mockito.when(PERSON3.getId()).thenReturn(3);
    }

    @Test
    public void whenElementsAreGreaterThan16_thenConstructorThrowsException() {
        //Arrange
        Person[] elements = new Person[17];

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
        Person[] expectedResult = new Person[]{PERSON1, PERSON2, PERSON3, null};

        //Act
        Person[] actualResult = database.getElements();

        //Assert
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    public void whenUsernameNotPresent_thenTrowsException() {
        assertThrows(OperationNotSupportedException.class, () -> {
            database.findByUsername("Katya");
        });
    }

    @Test
    public void testFindByUsernameShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findByUsername("Kaloyan");

        assertEquals(PERSON2, actualPerson);
    }

    /*@Test
    public void test_getElement_Should_Return_Only_NonNull_Element() {
        Arrays.stream(database.getElements())
                .forEach(Assertions::assertNotNull);
    }*/

    @Test
    public void testFindByIdShouldThrowUsername_whenNotPresent() {
        assertThrows(OperationNotSupportedException.class, () -> {
            database.findById(100);
        });
    }
    @Test
    public void testFindByIdShouldReturnCorrectPerson() throws OperationNotSupportedException {
        Person actualPerson = database.findById(1);

        assertEquals(PERSON1, actualPerson);
    }

    @Test
    public void whenAddNullOrNegativeId_thenShouldThrowException() {
        Person person = new Person(-1, "John");

        assertThrows(OperationNotSupportedException.class, () -> {
            database.add(person);
        });
    }

    @Test
    public void whenPersonWithThatIdExist_thenShouldThrowException() {
        Person person = new Person(1, "John");

        assertThrows(OperationNotSupportedException.class, () -> {
            database.add(person);
        });
    }

    @Test
    public void whenAddElement_thenAddToTheLastPosition() throws OperationNotSupportedException {
        Person person = new Person(4, "John");

        database.add(person);

        assertEquals(person, database.findById(4));
    }

    @Test
    public void whenRemoveFromEmptyList_thenShouldThrowException() throws OperationNotSupportedException {
        Database database = new Database(PERSON1);
        database.remove();

        assertThrows(OperationNotSupportedException.class, () -> {
            database.remove();
        });
    }

    @Test
    public void whenRemoveElementShouldRemoveToTheLastPosition() throws OperationNotSupportedException {
        database.remove();

        Person actualElements = database.getElements()[database.getElements().length - 2];

        assertEquals(PERSON2.getUsername(), actualElements.getUsername());
        assertEquals(PERSON2.getId(), actualElements.getId());
    }
}
