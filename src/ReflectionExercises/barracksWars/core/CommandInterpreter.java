package ReflectionExercises.barracksWars.core;

import ReflectionExercises.barracksWars.core.commands.*;
import ReflectionExercises.barracksWars.interfaces.Executable;
import ReflectionExercises.barracksWars.interfaces.Repository;
import ReflectionExercises.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter {
    private Repository repository;
    private UnitFactory unitFactory;


    public CommandInterpreter(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Executable executable;

        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);

        Class<? extends Executable> clazz =
                (Class<? extends Executable>) Class.forName("ReflectionExercises.barracksWars.core.commands." + commandName);

        Constructor<? extends Executable> ctr = clazz.getDeclaredConstructor();
        executable = ctr.newInstance();

        injectFields(executable, data);

        return executable;
    }
    private void injectFields(Executable executable, String[] data) throws IllegalAccessException {
        Field[] declaredFields = executable.getClass().getDeclaredFields();

        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.getType() == String[].class){
                declaredField.set(executable, data);
            }else if(declaredField.getType() == Repository.class){
                declaredField.set(executable, this.repository);
            } else if(declaredField.getType() == UnitFactory.class){
                declaredField.set(executable, this.unitFactory);
            }
        }
    }
}
