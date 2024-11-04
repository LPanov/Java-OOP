package ExceptionsAndErrorHandling;

import java.util.Arrays;
import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (num < 0) throw new Exception("Negative number");
            double sqrt = Math.sqrt(num);
            System.out.printf("%.2f\n", sqrt);
        } catch (Exception ex) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }

    }
}
