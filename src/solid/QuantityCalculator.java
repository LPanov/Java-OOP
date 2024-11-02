package solid;

import solid.interfaces.Drink;
import solid.interfaces.Food;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class QuantityCalculator {
    public double sum(List<Object> products) {
        AtomicReference<Double> sum = new AtomicReference<>((double) 0);

        products.forEach(product -> {
            if (product instanceof Drink) {
                sum.updateAndGet(v -> (double) (v + ((Drink) product).drinkAmount()));
            }
            if (product instanceof Food) {
                sum.updateAndGet(v -> (double) (v + ((Food) product).foodAmount()));
            }
        });
        return sum.get();
    }

    public double average(List<Object> products) {
        return sum(products) / products.size();
    }
}
