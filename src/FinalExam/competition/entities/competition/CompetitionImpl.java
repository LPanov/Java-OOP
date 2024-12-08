package FinalExam.competition.entities.competition;

import FinalExam.competition.entities.car.Car;
import FinalExam.competition.entities.destination.Destination;

import java.util.Collection;
import java.util.Iterator;

public class CompetitionImpl implements Competition{
    @Override
    public void startVoyage(Destination destination, Collection<Car> cars) {
        Iterator<Car> iterator = destination.getCars().iterator();

        while (iterator.hasNext()) {
            Car car = iterator.next();
            while (car.getMileage() < destination.getDistance() && car.getBatteryCapacity() >= 15) {
                car.drive();
            }


            if (car.getMileage() < destination.getDistance()) {
                cars.add(car);
                //iterator.remove();
            }

        }
    }
}
