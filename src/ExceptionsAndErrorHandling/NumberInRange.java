package ExceptionsAndErrorHandling;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.printf("Range: [%d...%d]\n", range[0], range[1]);

        while (true) {
            String n = scanner.nextLine();
            try {
                if (Integer.parseInt(n) >= range[0] &&
                        Integer.parseInt(n) <= range[1]) {
                    System.out.println("Valid number: " + n);
                    break;
                }
                else throw new IllegalArgumentException("Number not in range!");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid number: " + n);
            }
        }
    }
}
