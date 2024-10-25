package WorkingWithAbstractionLab.studentSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Student> students = new HashMap<>();

        String command = reader.readLine();
        while (!command.equals("Exit")) {
            String[] token = command.split("\\s+");

            if (token[0].equals("Create")) {
                String name = token[1];
                int age = Integer.parseInt(token[2]);
                double grade = Double.parseDouble(token[3]);

                students.putIfAbsent(name, create(name, age, grade));
            }
            else if (token[0].equals("Show")) {
                show(students, token[1]);
            }
            command = reader.readLine();
        }

    }

    public static Student create(String name, int age, double grade) {
        return new Student(name, age, grade);
    }

    public static void show(Map<String, Student> students, String name) {
        if (students.containsKey(name)) System.out.println(students.get(name));
    }
}
