package EncapsulationExercises.PizzaCalories;
//package PizzaCalories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setToppings(int count) {
        if (count < 0 || count > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(count);
    }
    private void setName(String name) {
        if (name.isEmpty() ||
                name.length() > 15 ||
                checkForSpaces(name)) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private boolean checkForSpaces(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == ' ') count++;
        }
        return count  == str.length();
    }

    public String getName() {
        return name;
    }

    public void addTopping (Topping topping) {
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        return this.dough.calculateCalorie() +
                this.toppings
                        .stream().map(Topping::calculateCalories)
                        .collect(Collectors.toList())
                        .stream().reduce((a, b) -> a + b).get();
    }
}
