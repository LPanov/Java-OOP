package ReflectionExercises.barracksWars.core.commands;

import ReflectionExercises.barracksWars.interfaces.Executable;
import ReflectionExercises.barracksWars.interfaces.Repository;
import ReflectionExercises.barracksWars.interfaces.UnitFactory;

public class Fight implements Executable {
    public Fight() {
    }

    @Override
    public String execute() {
        return "fight";
    }
}
