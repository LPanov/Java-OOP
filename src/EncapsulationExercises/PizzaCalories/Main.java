package EncapsulationExercises.PizzaCalories;
//package PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String command = reader.readLine();
        Pizza pizza = null;
        while (!command.equals("END")) {
            String[] token = command.split("\\s+");
            if (token[0].equals("Pizza")) {
                String name = token[1];
                int countOfToppings = Integer.parseInt(token[2]);
                pizza = new Pizza(name, countOfToppings);
            }
            else if (token[0].equals("Dough")) {
                String flourType = token[1];
                String bakingTechnique = token[2];
                double weight = Double.parseDouble(token[3]);
                Dough dough = new Dough(flourType, bakingTechnique, weight);
                pizza.setDough(dough);
            }
            else if (token[0].equals("Topping")) {
                String toppingType = token[1];
                double weight = Double.parseDouble(token[2]);
                Topping topping = new Topping(toppingType, weight);

                pizza.addTopping(topping);
            }

            command = reader.readLine();
        }

        System.out.println(pizza.getName() + " - " + String.format("%.2f", pizza.getOverallCalories()));
    }
}
