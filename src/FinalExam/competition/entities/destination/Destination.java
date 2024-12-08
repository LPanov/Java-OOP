package FinalExam.competition.entities.destination;

import FinalExam.competition.entities.car.Car;

import java.util.Collection;

public interface Destination {

    Collection<Car> getCars();

    String getName();

    int getDistance();
}
