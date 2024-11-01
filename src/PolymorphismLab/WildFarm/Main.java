package PolymorphismLab.WildFarm;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Animal> animals = new LinkedList<>();

        while (true) {
            String[] even = scanner.nextLine().split("\\s+");
            if (even[0].equals("End")) break;
            String[] odd = scanner.nextLine().split("\\s+");

            Animal animal = null;
            Food food;
            if (even[0].equals("Cat")) {
                String animalType = even[0];
                String animalName = even[1];
                double animalWeight = Double.parseDouble(even[2]);
                String livingRegion = even[3];
                String catBreed = even[4];

                animal = new Cat(animalName, animalType, animalWeight, 0, livingRegion, catBreed);
                int foodQuantity = Integer.parseInt(odd[1]);
                if (odd[0].equals("Vegetable")) food = new Vegetable(foodQuantity);
                else food = new Meat(foodQuantity);
                animal.setFood(food);
            }
            else if (even[0].equals("Tiger")) {
                String animalType = even[0];
                String animalName = even[1];
                double animalWeight = Double.parseDouble(even[2]);
                String livingRegion = even[3];

                animal = new Tiger(animalName, animalType, animalWeight, 0, livingRegion);
                int foodQuantity = Integer.parseInt(odd[1]);
                if (odd[0].equals("Vegetable")) food = new Vegetable(foodQuantity);
                else food = new Meat(foodQuantity);
                animal.setFood(food);
            }
            else if (even[0].equals("Mouse")) {
                String animalType = even[0];
                String animalName = even[1];
                double animalWeight = Double.parseDouble(even[2]);
                String livingRegion = even[3];

                animal = new Mouse(animalName, animalType, animalWeight, 0, livingRegion);
                int foodQuantity = Integer.parseInt(odd[1]);
                if (odd[0].equals("Vegetable")) food = new Vegetable(foodQuantity);
                else food = new Meat(foodQuantity);
                animal.setFood(food);
            }
            else if (even[0].equals("Zebra")) {
                String animalType = even[0];
                String animalName = even[1];
                double animalWeight = Double.parseDouble(even[2]);
                String livingRegion = even[3];

                animal = new Zebra(animalName, animalType, animalWeight, 0, livingRegion);
                int foodQuantity = Integer.parseInt(odd[1]);
                if (odd[0].equals("Vegetable")) food = new Vegetable(foodQuantity);
                else food = new Meat(foodQuantity);
                animal.setFood(food);
            }

            animal.makeSound();
            animal.eat();
            animals.add(animal);
        }

        animals.forEach(System.out::println);

    }
}
