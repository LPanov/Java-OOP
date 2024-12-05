package ExamPreparation.furnitureFactory.core;

import ExamPreparation.furnitureFactory.entities.factories.AdvancedFactory;
import ExamPreparation.furnitureFactory.entities.factories.Factory;
import ExamPreparation.furnitureFactory.entities.factories.OrdinaryFactory;
import ExamPreparation.furnitureFactory.entities.wood.OakWood;
import ExamPreparation.furnitureFactory.entities.wood.Wood;
import ExamPreparation.furnitureFactory.entities.workshops.DeckingWorkshop;
import ExamPreparation.furnitureFactory.entities.workshops.TableWorkshop;
import ExamPreparation.furnitureFactory.entities.workshops.Workshop;
import ExamPreparation.furnitureFactory.repositories.WoodRepository;
import ExamPreparation.furnitureFactory.repositories.WoodRepositoryImpl;
import ExamPreparation.furnitureFactory.repositories.WorkshopRepository;
import ExamPreparation.furnitureFactory.repositories.WorkshopRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

import static ExamPreparation.furnitureFactory.common.ConstantMessages.*;
import static ExamPreparation.furnitureFactory.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private WoodRepository woodRepository;
    private WorkshopRepository workshopRepository;
    private Collection<Factory> factories;

    public ControllerImpl() {
        this.woodRepository = new WoodRepositoryImpl();
        this.workshopRepository = new WorkshopRepositoryImpl();
        this.factories = new ArrayList<>();
    }

    @Override
    public String buildFactory(String factoryType, String factoryName) {
        Factory factory;

        if (factoryType.equals("OrdinaryFactory")) {
            factory = new OrdinaryFactory(factoryName);
        }
        else if (factoryType.equals("AdvancedFactory")) {
            factory = new AdvancedFactory(factoryName);
        }
        else {
            throw new IllegalArgumentException(INVALID_FACTORY_TYPE);
        }

        boolean factoryExist = factories.stream().anyMatch(factory1 -> factory1.getName().equals(factoryName));
        if (factoryExist) {
            throw new NullPointerException(FACTORY_EXISTS);
        }

        this.factories.add(factory);

        return String.format(SUCCESSFULLY_BUILD_FACTORY_TYPE, factoryType, factoryName);
    }

    @Override
    public Factory getFactoryByName(String factoryName) {
        return this.factories.stream().filter(factory -> factory.getName().equals(factoryName)).findFirst().orElse(null);
    }

    @Override
    public String buildWorkshop(String workshopType, int woodCapacity) {
        Workshop workshop;
        if (workshopType.equals("TableWorkshop")) {
            workshop = new TableWorkshop(woodCapacity);
        }
        else if (workshopType.equals("DeckingWorkshop")) {
            workshop = new DeckingWorkshop(woodCapacity);
        }
        else {
            throw new IllegalArgumentException(INVALID_WORKSHOP_TYPE);
        }

        this.workshopRepository.add(workshop);
        return String.format(SUCCESSFULLY_BUILD_WORKSHOP_TYPE, workshopType);
    }

    @Override
    public String addWorkshopToFactory(String factoryName, String workshopType) {
        Workshop workshop = workshopRepository.findByType(workshopType);
        boolean factoryExist = factories.stream().anyMatch(f -> f.getName().equals(factoryName));

        if (workshop == null) {
            throw new NullPointerException(String.format(NO_WORKSHOP_FOUND, workshopType));
        }

        Factory factory = factories.stream().filter(f -> f.getName().equals(factoryName)).findFirst().get();
        boolean workshopsInFactory = factory.getWorkshops().stream().anyMatch(w -> w.getClass().getSimpleName().equals(workshopType));

        if (workshopsInFactory) {
            throw new IllegalArgumentException(WORKSHOP_EXISTS);
        }

        if ((factory instanceof AdvancedFactory && workshop instanceof TableWorkshop) ||
                (factory instanceof OrdinaryFactory && workshop instanceof DeckingWorkshop)) {
            return NON_SUPPORTED_WORKSHOP;
        }
        else {
            factories.stream().filter(f -> f.getName().equals(factoryName)).findFirst().get().addWorkshop(workshop);
            return String.format(SUCCESSFULLY_ADDED_WORKSHOP_IN_FACTORY, workshopType,factoryName);
        }
    }


    @Override
    public String buyWoodForFactory(String woodType) {
        Wood wood;

        if (!woodType.equals("OakWood")) {
            throw new IllegalArgumentException(INVALID_WOOD_TYPE);
        }
        else {
            wood = new OakWood();
        }

        this.woodRepository.add(wood);
        return String.format(SUCCESSFULLY_BOUGHT_WOOD_FOR_FACTORY, woodType);
    }

    @Override
    public String addWoodToWorkshop(String factoryName, String workshopType, String woodType) {
        Factory factory = factories.stream().filter(f -> f.getName().equals(factoryName)).findFirst().orElse(null);
        Wood wood = woodRepository.findByType(woodType);
        Workshop workshop = factory.getWorkshops().stream().filter(w -> w.getClass().getSimpleName().equals(workshopType)).findFirst().orElse(null);

        if (workshop == null) {
            throw new NullPointerException(NO_WORKSHOP_ADDED);
        }
        if (wood == null) {
            throw new NullPointerException(String.format(NO_WOOD_FOUND, woodType, workshopType));
        }

        woodRepository.remove(wood);
        factory.getWorkshops().stream().filter(w -> w.getClass().getSimpleName().equals(workshopType)).findFirst().get().addWood(wood);
        return String.format(SUCCESSFULLY_ADDED_WOOD_IN_WORKSHOP, woodType, workshopType);
    }

    @Override
    public String produceFurniture(String factoryName) {
        Factory factory = factories.stream().filter(f -> f.getName().equals(factoryName)).findFirst().orElse(null);

        if (factory.getWorkshops().isEmpty()) {
            throw new NullPointerException(String.format(THERE_ARE_NO_WORKSHOPS, factoryName));
        }
        int producedFurniture = 0;
        for (Workshop workshop : factory.getWorkshops()) {
            if (workshop.getWoodQuantity() > 0 && workshop.getWoodQuantity() < workshop.getWoodQuantityReduceFactor()) {
                System.out.println(INSUFFICIENT_WOOD);
            } else if (workshop.getWoodQuantity() <= 0) {
                workshopRepository.remove(workshop);
                factory.getRemovedWorkshops().add(workshop);
                System.out.println(String.format(WORKSHOP_STOPPED_WORKING, workshop.getClass().getSimpleName()));
            } else {
                workshop.produce();
                producedFurniture ++;
                break;
            }
        }

        factory.getRemovedWorkshops().forEach(workshop -> factory.getWorkshops().remove(workshop));

        if (producedFurniture > 0) {
            return String.format(SUCCESSFUL_PRODUCTION, producedFurniture, factoryName);
        }
        else return String.format(FACTORY_DO_NOT_PRODUCED, factoryName);
    }

    @Override
    public String getReport() {
        StringBuilder str = new StringBuilder();

        factories.stream().forEach(f -> {
            str.append("Production by "+f.getName()+" factory:\n");
            if (f.getRemovedWorkshops().isEmpty() && f.getWorkshops().isEmpty()) {
                str.append(" No workshops were added to produce furniture.\n");
            } else {
                f.getRemovedWorkshops().stream().forEach(workshop -> {
                    str.append(String.format(" %s: %d furniture produced\n", workshop.getClass().getSimpleName(), workshop.getProducedFurnitureCount()));
                });
                f.getWorkshops().stream().forEach(workshop -> {
                    str.append(String.format(" %s: %d furniture produced\n", workshop.getClass().getSimpleName(), workshop.getProducedFurnitureCount()));
                });
            }
        });
        return str.toString();
    }
}
