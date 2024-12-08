package FinalExam.competition.entities.destination;

import FinalExam.competition.entities.car.Car;

import java.util.Collection;
import java.util.LinkedList;

import static FinalExam.competition.common.ExceptionMessages.DESTINATION_NAME_NULL_OR_EMPTY;
import static FinalExam.competition.common.ExceptionMessages.NEGATIVE_DISTANCE_VALUE;

public abstract class BaseDestination implements Destination{
    private String name;
    private int distance;
    private Collection<Car> cars;

    public BaseDestination(String name, int distance) {
        this.setName(name);
        this.setDistance(distance);
        this.cars = new LinkedList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException(DESTINATION_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    private void setDistance(int distance) {
        if (distance < 0) {
            throw new IllegalArgumentException(NEGATIVE_DISTANCE_VALUE);
        }
        this.distance = distance;
    }

    @Override
    public Collection<Car> getCars() {
        return this.cars;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }
}
