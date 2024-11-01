package PolymorphismExercises.VehicleExtended;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carIn = scanner.nextLine().split("\\s+");
        String[] truckIn = scanner.nextLine().split("\\s+");
        String[] busIn = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carIn[1]), Double.parseDouble(carIn[2]), Double.parseDouble(carIn[3]));
        Vehicle truck = new Truck(Double.parseDouble(truckIn[1]), Double.parseDouble(truckIn[2]), Double.parseDouble(carIn[2]));
        Bus bus = new Bus(Double.parseDouble(busIn[1]), Double.parseDouble(busIn[2]), Double.parseDouble(busIn[2]));

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split("\\s+");

            if (token[0].equals("Drive")) {
                double distance = Double.parseDouble(token[2]);
                if (token[1].equals("Car")) car.drive(distance);
                else if (token[1].equals("Truck")) truck.drive(distance);
                else if (token[1].equals("Bus")) {
                    bus.setEmpty(false);
                    bus.drive(distance);
                }
            }
            else if (token[0].equals("Refuel")) {
                double liters = Double.parseDouble(token[2]);
                if (token[1].equals("Car")) car.refuel(liters);
                else if (token[1].equals("Truck")) truck.refuel(liters);
                else if (token[1].equals("Bus")) bus.refuel(liters);
            }
            else if (token[0].equals("DriveEmpty")){
                bus.setEmpty(true);
                double distance = Double.parseDouble(token[2]);
                bus.drive(distance);
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
