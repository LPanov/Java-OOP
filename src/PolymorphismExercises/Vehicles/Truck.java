package PolymorphismExercises.Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    private final static double AIR_CONDITIONER_CONSUMPTION = 1.6;

    public Truck(double fuelCapacity, double fuelConsumptionPerKM) {
        super(fuelCapacity, fuelConsumptionPerKM);
    }

    @Override
    public void drive(double distance) {
        double drive = distance * getFuelConsumptionPerKM() ;
        if (drive <= getFuelCapacity()) {
            this.setFuelCapacity(getFuelCapacity() - drive);
            System.out.println("Truck travelled "+new DecimalFormat("#.##").format(distance)+" km");
        }
        else {
            System.out.println("Truck needs refueling");
        }

    }

    @Override
    public void refuel(double liters) {
        setFuelCapacity(getFuelCapacity()+liters*0.95);
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelCapacity());
    }
}
