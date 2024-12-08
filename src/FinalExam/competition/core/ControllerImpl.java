package FinalExam.competition.core;

//TODO - Implement all the methods

import FinalExam.competition.entities.car.*;
import FinalExam.competition.entities.competition.Competition;
import FinalExam.competition.entities.competition.CompetitionImpl;
import FinalExam.competition.entities.destination.Destination;
import FinalExam.competition.entities.destination.Lake;
import FinalExam.competition.entities.destination.Mountain;
import FinalExam.competition.entities.destination.SeaSide;
import FinalExam.competition.entities.repositories.DestinationRepository;

import java.util.ArrayList;
import java.util.List;

import static FinalExam.competition.common.ConstantMessages.*;
import static FinalExam.competition.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DestinationRepository destinationRepository;

    public ControllerImpl() {
        this.destinationRepository = new DestinationRepository();
    }

    @Override
    public String addDestination(String destinationType, String destinationName) {
        Destination destination;
        if (destinationType.equals("Lake")) {
            destination = new Lake(destinationName);
        }
        else if (destinationType.equals("Mountain")) {
            destination = new Mountain(destinationName);
        }
        else if (destinationType.equals("SeaSide")) {
            destination = new SeaSide(destinationName);
        }
        else {
            throw new IllegalArgumentException(INVALID_DESTINATION);
        }

        Destination destination1 = destinationRepository.byName(destinationName);
        if (destination1 != null) {
            throw new IllegalArgumentException(EXISTING_DESTINATION);
        }

        destinationRepository.add(destination);
        return DESTINATION_ADDED.formatted(destinationType, destinationName);
    }

    @Override
    public String addCar(String destinationName, String carBrand, String carModel) {
        Destination destination = destinationRepository.byName(destinationName);

        if (destination == null) {
            throw new NullPointerException(NON_EXISTING_DESTINATION);
        }

        boolean carExist = destination.getCars().stream()
                .anyMatch(car -> car.getClass().getSimpleName().equals(carBrand) && car.getModel().equals(carModel));

        if (carExist) {
            throw new IllegalArgumentException(EXISTING_CAR_BRAND_AND_MODEL);
        }

        Car car = switch (carBrand) {
            case "Dacia" -> new Dacia(carModel);
            case "Tesla" -> new Tesla(carModel);
            case "VW" -> new VW(carModel);
            case "Hyundai" -> new Hyundai(carModel);
            default -> throw new IllegalArgumentException(INVALID_CAR);
        };

        destination.getCars().add(car);
        return CAR_ADDED.formatted(carBrand, carModel);
    }

    @Override
    public String reachDestination(String destinationName) {
        Competition competition = new CompetitionImpl();

        Destination destination = destinationRepository.byName(destinationName);

        List<Car> droppedCars = new ArrayList<>();

        competition.startVoyage(destination, droppedCars);

        return VOYAGE_OVER.formatted(destinationName, droppedCars.size());
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();

        destinationRepository.getCollection()
                .forEach(destination -> {
                    builder.append(CARS_TOOK_PART.formatted(destination.getName())).append(System.lineSeparator());
                    destination.getCars()
                            .forEach(car ->
                                    builder.append(FINAL_CAR_INFO.formatted(car.getClass().getSimpleName(), car.getModel(), car.getBatteryCapacity(), car.getMileage())).append(System.lineSeparator()));
                        });

        return builder.toString();
    }
}
