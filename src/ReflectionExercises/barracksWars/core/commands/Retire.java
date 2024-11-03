package ReflectionExercises.barracksWars.core.commands;

import ReflectionExercises.barracksWars.annotations.Inject;
import ReflectionExercises.barracksWars.interfaces.Executable;
import ReflectionExercises.barracksWars.interfaces.Repository;
import ReflectionExercises.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.util.NoSuchElementException;

public class Retire implements Executable {
    @Inject
    private Repository repository;
    @Inject
    private String[] data;

    public Retire(){}
    public Retire(String[] data, Repository repository) {
        this.data = data;
        this.repository = repository;
    }

    @Override
    public String execute() {
        String unitType = this.data[1];
        try {
            this.repository.removeUnit(unitType);
        } catch (ExecutionControl.NotImplementedException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            return "No such units in repository.";
        }

        return unitType + " retired!";
    }
}
