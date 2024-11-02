package solid;

import solid.interfaces.Product;
import solid.products.Chips;
import solid.products.Coke;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //Product chips = new Chips(432);
        Product coke = new Coke(2000);

        List<Object> products = new ArrayList<>();
        //products.add(chips);
        products.add(coke);

        PrinterImpl printCalories = new PrinterImpl(new CalorieCalculator());
        printCalories.printSum(products);
        printCalories.printAverage(products);

        PrinterImpl printQuantity = new PrinterImpl(new QuantityCalculator());
        printQuantity.printSum(products);
        printQuantity.printAverage(products);
    }
}
