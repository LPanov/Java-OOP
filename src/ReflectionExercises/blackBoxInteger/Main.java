package ReflectionExercises.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Constructor<BlackBoxInt> ctr = clazz.getDeclaredConstructor(int.class);

        ctr.setAccessible(true);
        BlackBoxInt blackBoxInt = ctr.newInstance(0);

        Field[] fields = blackBoxInt.getClass().getDeclaredFields();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] token = command.split("_");
            int n = Integer.parseInt(token[1]);

            Field field = BlackBoxInt.class.getDeclaredField("innerValue");
            field.setAccessible(true);
            Method method;

            if (token[0].equals("add")) {
                method = clazz.getDeclaredMethod("add", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, n);

                System.out.println(field.get(blackBoxInt));
            }
            else if (token[0].equals("subtract")) {
                method = clazz.getDeclaredMethod("subtract", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, n);

                System.out.println(field.get(blackBoxInt));
            }
            else if (token[0].equals("divide")) {
                method = clazz.getDeclaredMethod("divide", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, n);

                System.out.println(field.get(blackBoxInt));
            }
            else if (token[0].equals("multiply")) {
                method = clazz.getDeclaredMethod("multiply", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, n);

                System.out.println(field.get(blackBoxInt));
            }
            else if (token[0].equals("rightShift")) {
                method = clazz.getDeclaredMethod("rightShift", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, n);

                System.out.println(field.get(blackBoxInt));
            }
            else if (token[0].equals("leftShift")) {
                method = clazz.getDeclaredMethod("leftShift", int.class);
                method.setAccessible(true);
                method.invoke(blackBoxInt, n);

                System.out.println(field.get(blackBoxInt));
            }
            command = scanner.nextLine();
        }
    }
}
