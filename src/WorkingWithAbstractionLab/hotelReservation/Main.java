package WorkingWithAbstractionLab.hotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] token = reader.readLine().split("\\s+");
        double pricePerDay = Double.parseDouble(token[0]);
        int days = Integer.parseInt(token[1]);
        season season = WorkingWithAbstractionLab.hotelReservation.season.valueOf(token[2]);
        discount discount = WorkingWithAbstractionLab.hotelReservation.discount.valueOf(token[3]);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, days, discount, season);
        priceCalculator.calculate();


    }
}
