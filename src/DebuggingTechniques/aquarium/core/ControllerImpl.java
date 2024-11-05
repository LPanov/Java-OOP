package DebuggingTechniques.aquarium.core;

import DebuggingTechniques.aquarium.entities.aquariums.Aquarium;
import DebuggingTechniques.aquarium.entities.aquariums.BaseAquarium;
import DebuggingTechniques.aquarium.entities.aquariums.FreshwaterAquarium;
import DebuggingTechniques.aquarium.entities.aquariums.SaltwaterAquarium;
import DebuggingTechniques.aquarium.entities.decorations.Decoration;
import DebuggingTechniques.aquarium.entities.decorations.Ornament;
import DebuggingTechniques.aquarium.entities.decorations.Plant;
import DebuggingTechniques.aquarium.entities.fish.Fish;
import DebuggingTechniques.aquarium.entities.fish.FreshwaterFish;
import DebuggingTechniques.aquarium.entities.fish.SaltwaterFish;
import DebuggingTechniques.aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

import static DebuggingTechniques.aquarium.common.ConstantMessages.*;
import static DebuggingTechniques.aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller{
    private DecorationRepository repository;
    private Collection<BaseAquarium> aquariums;

    public ControllerImpl() {
        this.repository = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        BaseAquarium aquarium;
        if (aquariumType.equals("FreshwaterAquarium")) {
            aquarium = new FreshwaterAquarium(aquariumName);
        }
        else if (aquariumType.equals("SaltwaterAquarium")) {
            aquarium = new SaltwaterAquarium(aquariumName);
        }
        else {
            throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);

        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        if (type.equals("Plant")) {
            decoration = new Plant();
        }
        else if (type.equals("Ornament")) {
            decoration = new Ornament();
        }
        else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        this.repository.add(decoration);
        return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        if (repository.findByType(decorationType) == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        aquariums.stream()
                .filter(aquarium -> aquarium.getName().equals(aquariumName))
                .findFirst().get().addDecoration(repository.findByType(decorationType));
        repository.remove(repository.findByType(decorationType));
        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        if (fishType.equals("FreshwaterFish")){
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        }
        else if (fishType.equals("SaltwaterFish")){
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        }
        else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        String aquariumType = aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().get().getClass().getSimpleName();

        if ((aquariumType.equals("FreshwaterAquarium") && !fishType.equals("FreshwaterFish")) ||
                (aquariumType.equals("SaltwaterAquarium") && !fishType.equals("SaltwaterFish"))) {
            return WATER_NOT_SUITABLE;
        }
        aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().get().addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().get().feed();
        int fedFish = aquariums.stream().filter(aquarium -> aquarium.getName().equals(aquariumName)).findFirst().get().getFish().size();

        return String.format(FISH_FED, fedFish);
    }

    @Override
    public String calculateValue(String aquariumName) {
        BaseAquarium baseAquarium = aquariums.stream()
                .filter(aquarium -> aquarium.getName().equals(aquariumName))
                .findFirst().get();
        double fishPrice = baseAquarium
                .getFish().stream().map(Fish::getPrice)
                .mapToDouble(Double::doubleValue).sum();
        double decorationPrice = baseAquarium
                .getDecorations().stream().map(Decoration::getPrice)
                .mapToDouble(Double::doubleValue).sum();

        return String.format(VALUE_AQUARIUM, aquariumName, fishPrice+decorationPrice);
    }

    @Override
    public String report() {
        StringBuilder str = new StringBuilder();
        aquariums.forEach(aquarium -> str.append(aquarium.getInfo()).append(System.lineSeparator()));

        return str.toString().trim();
    }

}
