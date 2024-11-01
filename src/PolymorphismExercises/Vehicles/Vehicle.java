package PolymorphismExercises.Vehicles;

public abstract class Vehicle {
    private double fuelCapacity;
    private final double fuelConsumptionPerKM;

    protected Vehicle(double fuelCapacity, double fuelConsumptionPerKM) {
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
    }

    public double getFuelConsumptionPerKM() {
        return fuelConsumptionPerKM;
    }

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    protected abstract void drive(double distance);
    protected abstract void refuel(double liters);
}
