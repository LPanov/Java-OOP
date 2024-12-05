/*


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InstockTests {
    private static final Product PRODUCT1 = new Product("Apple", 1.99, 20);
    private static final Product PRODUCT2 = new Product("Banana", 3.00, 5);
    private static final Product PRODUCT3 = new Product("Pomegranate", 5.00, 15);
    private Instock instock;

    @BeforeEach
    public void setUp() {
        instock = new Instock();
    }


    //Test contains
    @Test
    public void whenStockIsEmpty_thenProductIsNotInTheStock() {
        boolean result = instock.contains(PRODUCT1);

        assertFalse(result);
    }

    //Test add method
    @Test
    public void whenAddNewProduct_thenStockContainsTheProduct() {
        instock.add(PRODUCT1);

        boolean result = instock.contains(PRODUCT1);

        assertTrue(result);
    }

    @Test
    public void whenCallCount_thenReturnNumberOfProductsCurrentlyInStock() {
        instock.add(PRODUCT1);

        int actualResult = instock.getCount();

        assertEquals(1, actualResult);
    }

    @Test
    public void whenFindNthProductAndProductExist_thenReturnTheProduct() {
        instock.add(PRODUCT1);

        Product product = instock.find(0);

        assertEquals(PRODUCT1, product);
    }

    @Test
    public void whenFindNthProductAndProductDoesNotExist_thenThrowException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Product product = instock.find(0);
        });
    }

    @Test
    public void whenChangeQuantityOfExistingProduct_thenChangesQuantityOfTheGivenProductByNAmount() {
        instock.add(PRODUCT1);

        instock.changeQuantity("Apple", 1000);

        assertEquals(1000, PRODUCT1.getQuantity());
    }

    @Test
    public void whenChangeQuantityOfNonExistingProduct_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            instock.changeQuantity("Apple", 1000);
        });
    }

    @Test
    public void whenFindProductByLabelAndProductExist_thenReturnTheProduct() {
        instock.add(PRODUCT1);

        Product product = instock.findByLabel("Apple");

        assertEquals(PRODUCT1, product);
    }

    @Test
    public void whenFindProductByLabelAndProductDoesNotExist_thenThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Product product = instock.findByLabel("Apple");
        });
    }

    //Tests find first n products ordered by alphabetical order and count IS IN RANGE
    @Test
    public void whenCallFindFirstByAlphabeticalOrderAndCountIsInRange_thenReturnIterableWithCountOfProducts() {
        instock.add(PRODUCT1);
        instock.add(new Product("Banana", 2.00, 5));
        instock.add(new Product("Pomegranate", 5.00, 15));

        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(3);

        assertTrue(iterable.iterator().hasNext());
    }

    @Test
    public void whenCallFindFirstByAlphabeticalOrder_thenReturnIterableOrderedInAlphabeticalOrder() {
        instock.add(new Product("Pomegranate", 5.00, 15));
        instock.add(new Product("Banana", 2.00, 5));
        instock.add(PRODUCT1);

        Iterator<Product> iterator = instock.findFirstByAlphabeticalOrder(3).iterator();

        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            str.append(iterator.next().getLabel()).append(" ");
        }

        assertEquals("Apple Banana Pomegranate ", str.toString());

    }

    //Test find first n products ordered by alphabetical order and count IS NOT IN RANGE
    @Test
    public void whenCallFindFirstByAlphabeticalOrderAndCountIsNotInRange_thenReturnEmptyIterable() {
        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(3);

        assertFalse(iterable.iterator().hasNext());
    }

    //Test findProductsInPriceRange with prices in range
    @Test
    public void whenCallFindAllInPriceRange_thenReturnIterableWithProductsInRangeOrderedInDescending() {
        instock.add(PRODUCT1);
        instock.add(new Product("Banana", 3.00, 5));
        instock.add(new Product("Pomegranate", 2.00, 15));

        Iterator<Product> iterator = instock.findAllInRange(1, 3).iterator();

        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            str.append(iterator.next().getLabel()).append(" ");
        }

        assertEquals("Banana Pomegranate Apple ", str.toString());
    }

    //Test findProductsInPriceRange with prices not in range
    @Test
    public void whenCallFindAllInPriceRangeAndPricesNotInRange_thenReturnEmptyIterable() {
        Iterator<Product> iterator = instock.findAllInRange(1, 3).iterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void whenCallFindAllByPriceAndThereAreProductWithSuchPrice_theReturnIterableOfThatProducts() {
        instock.add(PRODUCT1);
        instock.add(PRODUCT1);

        Iterator<Product> iterator = instock.findAllByPrice(1.99).iterator();

        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            str.append(iterator.next().getLabel()).append(" ");
        }

        assertEquals("Apple Apple ", str.toString());
    }

    @Test
    public void whenCallFindAllByPriceAndThereAreNotProductWithSuchPrice_theReturnEmptyIterable() {
        Iterator<Product> iterator = instock.findAllByPrice(1.99).iterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void whenCallFindFirstMostExpensiveProductsAndCountExist_thenReturnIterableWithThatCountOfProducts() {
        instock.add(PRODUCT1);
        instock.add(PRODUCT2);
        instock.add(PRODUCT3);

        Iterator<Product> iterator = instock.findFirstMostExpensiveProducts(2).iterator();


        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            str.append(iterator.next().getLabel()).append(" ");
        }

        assertEquals("Pomegranate Banana ", str.toString());
    }

    @Test
    public void whenCallFindFirstMostExpensiveProductsAndCountNotExist_thenReturnThrowException() {
        instock.add(PRODUCT1);

        assertThrows(IllegalArgumentException.class, () -> {
            Iterator<Product> iterator = instock.findFirstMostExpensiveProducts(2).iterator();
        });
    }

    @Test
    public void whenCallFindAllByQuantityAndThereAreProductWithSuchQuantity_theReturnIterableOfThatProducts() {
        instock.add(PRODUCT1);
        instock.add(PRODUCT1);

        Iterator<Product> iterator = instock.findAllByQuantity(20).iterator();

        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            str.append(iterator.next().getLabel()).append(" ");
        }

        System.out.println(str);

        assertEquals("", str.toString());
    }

    @Test
    public void whenCallFindAllByQuantityAndThereAreNotProductWithSuchQuantity_theReturnEmptyIterable() {
        Iterator<Product> iterator = instock.findAllByQuantity(20).iterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorMethod() {
        instock.add(PRODUCT1);

        assertTrue(instock.iterator().hasNext());
    }
    }
*/
