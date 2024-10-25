package WorkingWithAbstractionLab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RhombusOfStars {
    public static void printRow(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            printRow(i);
        }
        for (int i = n-1; i >=1; i--) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            printRow(i);
        }
    }
}
