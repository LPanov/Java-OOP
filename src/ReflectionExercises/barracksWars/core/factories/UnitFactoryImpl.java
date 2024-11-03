package ReflectionExercises.barracksWars.core.factories;

import ReflectionExercises.barracksWars.interfaces.Unit;
import ReflectionExercises.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"ReflectionExercises.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException {
		String className = "ReflectionExercises.barracksWars.models.units." + unitType;
		Object unit;
		try {
			Class clazz = Class.forName(className);
			Constructor constructor = clazz.getDeclaredConstructor();

			unit = constructor.newInstance();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("message");
		} catch (NoSuchMethodException e) {
            throw new RuntimeException("message");
        } catch (InvocationTargetException e) {
            throw new RuntimeException("message");
        } catch (InstantiationException e) {
            throw new RuntimeException("message");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("message");
        }

		return (Unit) unit;
    }
}
