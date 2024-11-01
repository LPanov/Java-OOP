package PolymorphismExercises.Vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carIn = scanner.nextLine().split("\\s+");
        String[] truckIn = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carIn[1]), Double.parseDouble(carIn[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckIn[1]), Double.parseDouble(truckIn[2]));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            if (token[0].equals("Drive")) {
                double distance = Double.parseDouble(token[2]);
                if (token[1].equals("Car")) car.drive(distance);
                else truck.drive(distance);
            }
            else {
                double liters = Double.parseDouble(token[2]);
                if (token[1].equals("Car")) car.refuel(liters);
                else truck.refuel(liters);
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
