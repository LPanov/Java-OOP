package PolymorphismLab.WildFarm;

import java.text.DecimalFormat;

public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, double animalWeight, int foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat() {
        if (getFood().getClass().equals(Vegetable.class)) {
           super.setFoodEaten(getFood().getQuantity());
        }
        else  {
            System.out.println(getAnimalType() + "s are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        return getAnimalType()+"["+getAnimalName()+", " + new DecimalFormat("0.##").format(getAnimalWeight()) +", " +getLivingRegion()+", " + getFoodEaten()+"]";
    }
}
