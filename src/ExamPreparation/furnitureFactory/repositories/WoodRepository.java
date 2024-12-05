package ExamPreparation.furnitureFactory.repositories;

import ExamPreparation.furnitureFactory.entities.wood.Wood;

public interface WoodRepository {

    void add(Wood wood);

    boolean remove(Wood wood);

    Wood findByType(String type);
}
