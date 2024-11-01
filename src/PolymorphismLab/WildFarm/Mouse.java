package PolymorphismLab.WildFarm;

import java.text.DecimalFormat;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat() {
        if (getFood().getClass().equals(Vegetable.class)) {
            super.setFoodEaten(getFood().getQuantity());
        }
        else  {
            System.out.println("Mice are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        return getAnimalType()+"["+getAnimalName()+", " + new DecimalFormat("0.##").format(getAnimalWeight()) +", " +getLivingRegion()+", " + getFoodEaten()+"]";

    }
}
