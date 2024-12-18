package InheritanceExercises.Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        if (name.isEmpty() || !name.matches("\\S+")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public void setGender(String gender) {
        if (!gender.equals("Male") && !gender.equals("Female")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public void setAge(int age) {
        if (age <= 0) throw new IllegalArgumentException("Invalid input!");
        this.age = age;
    }

    public String produceSound() {
        return "";
    }

    public String toString() {
        return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(), getName(), getAge(), getGender(),this.produceSound());
    }
}
