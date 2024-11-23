import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {

        return this.products.stream().anyMatch(p -> p.getLabel().equals(product.getLabel()));
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void changeQuantity(String productLabel, int quantity) {
        Product product = this.products.stream()
                .filter(p -> p.getLabel().equals(productLabel))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());

        product.setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        return products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        Product product = this.products.stream()
                .filter(p -> p.getLabel().equals(label))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());

        return product;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        this.products.sort(Comparator.comparing(Product::getLabel));

        List<Product> firstCountProducts = new ArrayList<>();
        if (count > 0 && count <= products.size()) {
            for (int i = 0; i < count; i++) {
                firstCountProducts.add(products.get(i));
            }
        }

        return firstCountProducts;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {

        products.sort(Comparator.comparing(Product::getPrice).reversed());

        return products.stream()
               .filter(p -> p.getPrice() > lo && p.getPrice() <= hi).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return products.stream()
                .filter(p -> p.getPrice() == price).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        this.products.sort(Comparator.comparing(Product::getPrice).reversed());

        List<Product> firstCountProducts = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            try {
                firstCountProducts.add(products.get(i));
            } catch (IndexOutOfBoundsException e) {
                break;
            }

        }

        if (firstCountProducts.size() < count) {
            throw new IllegalArgumentException();
        }

        return firstCountProducts;


    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return products.stream()
                .filter(p -> p.getQuantity() == quantity).collect(Collectors.toList());    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.iterator();
    }
}
