package ReflectionExercises.barracksWars.core.commands;

import ReflectionExercises.barracksWars.annotations.Inject;
import ReflectionExercises.barracksWars.interfaces.Executable;
import ReflectionExercises.barracksWars.interfaces.Repository;
import ReflectionExercises.barracksWars.interfaces.Unit;
import ReflectionExercises.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add implements Executable {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;
    @Inject
    private String[] data;
    public Add(){}
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {

        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        Unit unitToAdd;
        try {
           unitToAdd = this.unitFactory.createUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        }
        this.repository.addUnit(unitToAdd);

        return unitType + " added!";
    }
}
