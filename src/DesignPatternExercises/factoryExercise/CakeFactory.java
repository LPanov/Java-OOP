package DesignPatternExercises.factoryExercise;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CakeFactory {

    private static final String CAKE_PACKAGE_NAME = "DesignPatternExercises.factoryExercise.";

    private CakeFactory() {

    }

    public static Cake createCake(String type,
                                           double diameter,
                                           double price,
                                           int pieces) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String className = CAKE_PACKAGE_NAME + type + "Cake";
        Class<Cake> cakeClass = (Class<Cake>) Class.forName(className);

        Constructor<Cake> declaredConstructor = cakeClass
                .getDeclaredConstructor(double.class,
                                        double.class,
                                        int.class);
        return declaredConstructor.newInstance(diameter, price, pieces);
    }
}
