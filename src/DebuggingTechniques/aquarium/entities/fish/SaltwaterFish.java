package DebuggingTechniques.aquarium.entities.fish;

import DebuggingTechniques.aquarium.entities.aquariums.Aquarium;

public class SaltwaterFish extends BaseFish{
    private static final int SIZE = 5;
    private Aquarium aquarium;

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(SIZE);
    }

    @Override
    public void eat() {
        super.setSize(getSize() + 2);
    }
}
