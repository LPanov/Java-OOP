package ExamPreparation.furnitureFactory.repositories;

import ExamPreparation.furnitureFactory.entities.workshops.Workshop;

public interface WorkshopRepository {

    void add(Workshop workshop);

    boolean remove(Workshop workshop);

    Workshop findByType(String type);
}
