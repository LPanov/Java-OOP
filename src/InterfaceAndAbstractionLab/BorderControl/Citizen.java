package InterfaceAndAbstractionLab.BorderControl;

public class Citizen implements Identifiable {
    private String id;
    private String name;
    private int age;

    public Citizen(String name, int age, String id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getId() {
        return id;
    }
}