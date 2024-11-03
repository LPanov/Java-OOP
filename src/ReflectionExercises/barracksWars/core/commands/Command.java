package ReflectionExercises.barracksWars.core.commands;

import ReflectionExercises.barracksWars.interfaces.Executable;
import ReflectionExercises.barracksWars.interfaces.Repository;
import ReflectionExercises.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    protected String[] getData() {
        return data;
    }

}
