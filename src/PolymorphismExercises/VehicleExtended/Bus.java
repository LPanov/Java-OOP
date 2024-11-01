package PolymorphismExercises.VehicleExtended;

import java.text.DecimalFormat;

public class Bus extends Vehicle {
    private boolean isEmpty;
    private final static double AIR_CONDITIONER_CONSUMPTION = 1.4;
    private double fuelConsumptionPKMBus;

    public Bus(double fuelCapacity, double fuelConsumptionPerKM, double tankCapacity) {
        super(fuelCapacity, fuelConsumptionPerKM, tankCapacity);
        this.fuelConsumptionPKMBus = getFuelConsumptionPerKM();
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void setFuelConsumptionPKMBus() {
        if (isEmpty) this.fuelConsumptionPKMBus = getFuelConsumptionPerKM();
        else this.fuelConsumptionPKMBus = getFuelConsumptionPerKM() + AIR_CONDITIONER_CONSUMPTION;
    }

    public double getFuelConsumptionPKMBus() {
        return fuelConsumptionPKMBus;
    }

    @Override
    public void drive(double distance) {
        setFuelConsumptionPKMBus();
        double drive = distance * getFuelConsumptionPKMBus() ;
        if (drive <= getFuelCapacity()) {
            this.setFuelCapacity(getFuelCapacity() - drive);
            System.out.println("Bus travelled "+new DecimalFormat("#.##").format(distance)+" km");
        }
        else {
            System.out.println("Bus needs refueling");
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
        return String.format("Bus: %.2f", getFuelCapacity());
    }
}
