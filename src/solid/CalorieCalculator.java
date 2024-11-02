package solid;

import solid.interfaces.Printer;
import solid.interfaces.Product;
import solid.products.Chips;
import solid.products.Chocolate;
import solid.products.Coke;
import solid.products.Lemonade;

import java.util.List;

public class CalorieCalculator{

    public CalorieCalculator() {
    }

    public double sum(List<Object> products) {
        double sum = 0;

        for (Object product : products) {
            assert product instanceof Product;
            sum += ((Product) product).amountOfCalories();
        }

        return sum;
    }

    public double average(List<Object> products) {
        return sum(products) / products.size();
    }
}
