package DebuggingTechniques.aquarium.entities.fish;

import DebuggingTechniques.aquarium.entities.aquariums.Aquarium;

public class FreshwaterFish extends BaseFish{
    private static final int SIZE = 3;
    private Aquarium aquarium;

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(SIZE);
    }

    @Override
    public void eat() {
        super.setSize(getSize() + 3);
    }
}
