package ExamPreparation.furnitureFactory.entities.workshops;

import ExamPreparation.furnitureFactory.entities.wood.Wood;

public interface Workshop {

    int getWoodQuantity();
    int getProducedFurnitureCount();
    int getWoodQuantityReduceFactor();
    void addWood(Wood wood);
    void produce();
}