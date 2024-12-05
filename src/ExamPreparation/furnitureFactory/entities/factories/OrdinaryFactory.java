package ExamPreparation.furnitureFactory.entities.factories;

import ExamPreparation.furnitureFactory.entities.workshops.Workshop;

import static ExamPreparation.furnitureFactory.common.ExceptionMessages.NON_SUPPORTED_WORKSHOP;

public class OrdinaryFactory extends BaseFactory{
    public OrdinaryFactory(String name) {
        super(name);
    }

}
