package FinalExam.competition.entities.competition;

import FinalExam.competition.entities.car.Car;
import FinalExam.competition.entities.destination.Destination;

import java.util.Collection;

public interface Competition {

    void startVoyage(Destination destination, Collection<Car> cars);
}
