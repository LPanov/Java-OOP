package PolymorphismLab.WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline{
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat() {
        super.setFoodEaten(getFood().getQuantity());
    }

    @Override
    public String toString() {
        return getAnimalType()+"["+getAnimalName()+", "+getBreed()+", "+ new DecimalFormat("0.##").format(getAnimalWeight()) +", " +getLivingRegion()+", " + getFoodEaten()+"]";

    }
}
