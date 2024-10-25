package EncapsulationExercises.ShoppingSpree;
//package ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        String[] input1 = reader.readLine().split(";");
        for (String input : input1) {
            String[] token = input.split("=");
            String name = token[0];
            double money = Double.parseDouble(token[1]);

            people.putIfAbsent(name, new Person(name, money));
        }

        String[] input2 = reader.readLine().split(";");
        for (String input : input2) {
            String[] token = input.split("=");
            String name = token[0];
            double cost = Double.parseDouble(token[1]);

            products.putIfAbsent(name, new Product(name, cost));
        }

        String command = reader.readLine();
        while (!command.equals("END")) {
            String[] token = command.split("\\s+");
            String name = token[0];
            String nameProduct = token[1];

            if (people.get(name).getMoney() < products.get(nameProduct).getCost()) {
                System.out.println(name + " can't afford " + nameProduct);
            }
            else {
                System.out.println(name + " bought " + nameProduct);
                people.get(name).buyProduct(products.get(nameProduct));
                people.get(name).getProducts().add(products.get(nameProduct));
            }
            command = reader.readLine();
        }

        people.values().forEach(person -> {
            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()) {
                System.out.println("Nothing bought");
            }
            else {
                StringJoiner joiner = new StringJoiner(", ");
                person.getProducts().forEach(product -> joiner.add(product.getName()));
                System.out.println(joiner);
            }
        });

    }

}
