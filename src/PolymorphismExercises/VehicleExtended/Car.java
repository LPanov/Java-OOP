package PolymorphismExercises.VehicleExtended;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private final static double AIR_CONDITIONER_CONSUMPTION = 0.9;

    public Car(double fuelCapacity, double fuelConsumptionPerKM, double tankCapacity) {
        super(fuelCapacity, fuelConsumptionPerKM + AIR_CONDITIONER_CONSUMPTION, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        double drive = distance * getFuelConsumptionPerKM();
        if (drive <= getFuelCapacity()) {
            this.setFuelCapacity(getFuelCapacity() - drive);
            System.out.println("Car travelled "+new DecimalFormat("#.##").format(distance) +" km");
        }
        else {
            System.out.println("Car needs refueling");
        }

    }

    @Override
    public void refuel(double liters) {
        double availableSpace = getTankCapacity() - getFuelCapacity();
        if (liters <= 0) System.out.println("Fuel must be a positive number");
        else if (liters > getTankCapacity()) {
            System.out.println("Cannot fit fuel in tank");
        }
        else {
            setFuelCapacity(getFuelCapacity()+liters);
        }
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelCapacity());
    }
}
