package PolymorphismExercises.VehicleExtended;

public abstract class Vehicle {
    private double fuelCapacity;
    private final double fuelConsumptionPerKM;
    private double tankCapacity;

    protected Vehicle(double fuelCapacity, double fuelConsumptionPerKM, double tankCapacity) {
        this.fuelCapacity = fuelCapacity;
        this.fuelConsumptionPerKM = fuelConsumptionPerKM;
        this.tankCapacity = tankCapacity;
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

    public double getTankCapacity() {
        return tankCapacity;
    }

    protected abstract void drive(double distance);
    protected abstract void refuel(double liters);
}
