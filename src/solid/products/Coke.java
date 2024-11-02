package solid.products;

import solid.interfaces.Drink;

public class Coke implements Drink {

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    private double milliliters;

    public Coke(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }


    @Override
    public double drinkAmount() {
        return DENSITY * (getMilliliters()/1000);
    }

    @Override
    public double amountOfCalories() {
        return DENSITY * getMilliliters() * (CALORIES_PER_100_GRAMS / 100);
    }
}
