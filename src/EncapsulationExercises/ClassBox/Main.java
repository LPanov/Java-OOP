//package ClassBox;
package EncapsulationExercises.ClassBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        Box box = new Box(length, width, height);

        System.out.println("Surface Area - " + String.format("%.2f", box.calculateSurfaceArea()));
        System.out.println("Lateral Surface Area - " + String.format("%.2f", box.calculateLateralSurfaceArea()));
        System.out.println("Volume - " + String.format("%.2f", box.calculateVolume()));

    }
}
