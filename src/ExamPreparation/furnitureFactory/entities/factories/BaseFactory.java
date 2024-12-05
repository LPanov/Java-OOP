package ExamPreparation.furnitureFactory.entities.factories;

import ExamPreparation.furnitureFactory.entities.workshops.Workshop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static ExamPreparation.furnitureFactory.common.ExceptionMessages.FACTORY_NAME_NULL_OR_EMPTY;

public abstract class BaseFactory implements Factory{
    private String name;
    private Collection<Workshop> workshops;
    private Collection<Workshop> removedWorkshops;

    protected BaseFactory(String name) {
        this.setName(name);
        this.workshops = new ArrayList<>();
        this.removedWorkshops = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(FACTORY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addWorkshop(Workshop workshop) {
        this.workshops.add(workshop);
    }

    @Override
    public Collection<Workshop> getWorkshops() {
        return this.workshops;
    }

    @Override
    public Collection<Workshop> getRemovedWorkshops() {
        return this.removedWorkshops;
    }
}
