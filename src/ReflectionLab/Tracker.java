package ReflectionLab;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class Tracker {

    @Author(name = "George")
    public static void main(String[] args) throws NoSuchMethodException {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl) throws NoSuchMethodException {
        Tracker t = new Tracker();
        Method[] methods = t.getClass().getDeclaredMethods();

        Map<String, String> output = new TreeMap<>();
        for (Method m : methods) {
            output.putIfAbsent(m.getAnnotation(Author.class).name(), m.getAnnotation(Author.class).name() + ": " + m.getName() + "()");
        }
        output.values().forEach(System.out::println);
    }
}
