package DesignPatternExercises.singleton;

public class HashCodeDemo {
    public static void main(String[] args) {
        Hashcode instance1 = Hashcode.getInstance("A");
        Hashcode instance2 = Hashcode.getInstance("B");

        System.out.println(instance1.getPoint().hashCode());
        System.out.println(instance2.getPoint().hashCode());

        System.out.println("A".hashCode());
    }
}
