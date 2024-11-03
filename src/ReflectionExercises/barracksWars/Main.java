package ReflectionExercises.barracksWars;

import ReflectionExercises.barracksWars.core.CommandInterpreter;
import ReflectionExercises.barracksWars.interfaces.Repository;
import ReflectionExercises.barracksWars.interfaces.Runnable;
import ReflectionExercises.barracksWars.interfaces.UnitFactory;
import ReflectionExercises.barracksWars.core.Engine;
import ReflectionExercises.barracksWars.core.factories.UnitFactoryImpl;
import ReflectionExercises.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        CommandInterpreter commandInterpreter = new CommandInterpreter(repository, unitFactory);
        Runnable engine = new Engine(commandInterpreter);
        engine.run();
    }
}
