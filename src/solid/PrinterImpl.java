package solid;

import solid.interfaces.Printer;
import solid.interfaces.Product;

import java.util.List;

public class PrinterImpl implements Printer {
    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

    CalorieCalculator calorieCalculator;
    QuantityCalculator quantityCalculator;

    public PrinterImpl(CalorieCalculator calorieCalculator) {
        this.calorieCalculator = calorieCalculator;
    }

    public PrinterImpl(QuantityCalculator quantityCalculator) {
        this.quantityCalculator = quantityCalculator;
    }

    @Override
    public void printSum(List<Object> products) {
        if (calorieCalculator != null) System.out.printf((SUM) + "%n", calorieCalculator.sum(products));
        else System.out.printf((SUM) + "%n", quantityCalculator.sum(products));
    }

    @Override
    public void printAverage(List<Object> products) {
        if (calorieCalculator != null) System.out.printf((AVERAGE) + "%n", calorieCalculator.average(products));
        else System.out.printf((AVERAGE) + "%n", quantityCalculator.average(products));
    }
}
