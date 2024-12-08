package FinalExam.competition.entities.car;

import static FinalExam.competition.common.ExceptionMessages.CAR_MODEL_NULL_OR_EMPTY;

public abstract class BaseCar implements Car{
    private String model;
    private int batteryCapacity;
    private int mileage;

    public BaseCar(String model, int batteryCapacity) {
        this.setModel(model);
        this.batteryCapacity = batteryCapacity;
        this.mileage = 0;
    }

    private void setModel(String model) {
        if (model == null || model.trim().isBlank()) {
            throw new NullPointerException(CAR_MODEL_NULL_OR_EMPTY);
        }
        this.model = model;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public int getBatteryCapacity() {
        return this.batteryCapacity;
    }

    @Override
    public int getMileage() {
        return this.mileage;
    }

    @Override
    public void drive() {
        setBatteryCapacity(getBatteryCapacity() - 15);
        setMileage(getMileage() + 25);

        if (getBatteryCapacity() < 0) {
            setBatteryCapacity(0);
        }
    }
}
