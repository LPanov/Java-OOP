package ReflectionLab;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class reflection = Reflection.class;

        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();

        Method[] methods = reflectionObject.getClass().getDeclaredMethods();
        Field[] fields = reflectionObject.getClass().getDeclaredFields();
        Map<String, String> getters = new TreeMap<>();
        Map<String, String> setters = new TreeMap<>();
        Map<String, String> fiields = new TreeMap<>();

        for (int i = 0; i < methods.length; i++) {
            String name = methods[i].getName();
            if (name.startsWith("set")) {
                String setCheck = methods[i].toString();
                if (!setCheck.startsWith("private")) {
                    setters.putIfAbsent(name, name + " have to be private!");
                }
            }
            else if (name.startsWith("get")){
                String getCheck = methods[i].toString();
                if (!getCheck.startsWith("public")) {
                    getters.putIfAbsent(name, name + " have to be public!");
                }
            }
        }

        for (Field field : fields) {
            String name = field.getName();
            String fieldCheck = field.toString();
            if (!fieldCheck.startsWith("private")) {
                fiields.putIfAbsent(name, name + " must be private!");
            }
        }

        fiields.values().forEach(System.out::println);
        getters.values().forEach(System.out::println);
        setters.values().forEach(System.out::println);
    }
}
