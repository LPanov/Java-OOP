package PolymorphismLab.Animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    public String getName() {
        return name;
    }

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    abstract String explainSelf();
}
