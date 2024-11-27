package DesignPatternExercises.factoryExercise;

import DesignPatternExercises.factoryExercise.CakeInterface;

public abstract class Cake implements CakeInterface {
    public double diameter;
    public double price;
    public int pieces;

    public Cake(double diameter, double price, int pieces) {
        this.diameter = diameter;
        this.price = price;
        this.pieces = pieces;
    }

    @Override
    public void prepare() {
        System.out.printf("Preparing %s...\n", this.getClass().getSimpleName());
    }

    @Override
    public void bake() {
        System.out.printf("Baking %s...\n", this.getClass().getSimpleName());
    }

    @Override
    public void box() {
        System.out.printf("Packing %s...\n", this.getClass().getSimpleName());

    }
}