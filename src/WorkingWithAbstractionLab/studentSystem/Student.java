package WorkingWithAbstractionLab.studentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        String commentary = "";
        if (this.grade >= 4.5 && this.grade < 5.5) {
            commentary = " Average student.";
        }
        else if (this.grade >= 5.5 && this.grade <= 6) {
            commentary = " Excellent student.";
        }
        else if (this.grade < 4.5) {
            commentary = " Very nice person.";
        }
        return this.name + " is "+this.age+" years old." + commentary;
    }
}
