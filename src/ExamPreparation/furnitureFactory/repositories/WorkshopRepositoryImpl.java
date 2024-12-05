package ExamPreparation.furnitureFactory.repositories;

import ExamPreparation.furnitureFactory.entities.workshops.Workshop;

import java.util.ArrayList;
import java.util.Collection;

import static ExamPreparation.furnitureFactory.common.ExceptionMessages.WORKSHOP_EXISTS_IN_REPOSITORY;
import static ExamPreparation.furnitureFactory.common.ExceptionMessages.WORKSHOP_WOOD_QUANTITY_BELOW_OR_EQUAL_ZERO;

public class WorkshopRepositoryImpl implements WorkshopRepository{
    private Collection<Workshop> workshops;

    public WorkshopRepositoryImpl() {
        this.workshops = new ArrayList<>();
    }

    @Override
    public void add(Workshop workshop) {
        Workshop check = workshops.stream().filter(w -> w.getClass().equals(workshop.getClass())).findFirst().orElse(null);

        if (check != null) {
            throw new IllegalArgumentException(WORKSHOP_EXISTS_IN_REPOSITORY);
        }
        if (workshop.getWoodQuantity() <= 0) {
            throw new IllegalArgumentException(WORKSHOP_WOOD_QUANTITY_BELOW_OR_EQUAL_ZERO);
        }

        this.workshops.add(workshop);
    }

    @Override
    public boolean remove(Workshop workshop) {
        return this.workshops.remove(workshop);
    }

    @Override
    public Workshop findByType(String type) {
        return workshops.stream().filter(workshop -> workshop.getClass().getSimpleName().equals(type)).findFirst().orElse(null);

    }
}
