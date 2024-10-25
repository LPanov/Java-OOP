package InterfaceAndAbstractionLab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> list = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] token = command.split("\\s+");
            if (token.length == 3) {
                String name = token[0];
                int age = Integer.parseInt(token[1]);
                String id = token[2];
                Identifiable citizen = new Citizen(name, age, id);

                list.add(citizen);
            }
            else {
                String id = token[1];
                String model = token[0];
                Identifiable robot = new Robot(id, model);

                list.add(robot);
            }

            command = scanner.nextLine();
        }

        String endId = scanner.nextLine();
        list.stream()
                .map(Identifiable::getId)
                .filter(f -> f.endsWith(endId))
                .forEach(System.out::println);
    }
}
