package EncapsulationExercises.PizzaCalories;
//package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;


    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        try {
            ToppingType.valueOf(toppingType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Cannot place "+toppingType+" on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories () {
        double calories = this.weight*2;
        switch (this.toppingType) {
            case "Meat" ->  calories *= 1.2;
            case "Veggies" -> calories *= 0.8;
            case "Cheese" ->  calories *= 1.1;
            case "Sauce" -> calories *= 0.9;
        }

        return calories;
    }

}

