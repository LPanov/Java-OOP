package WorkingWithAbstractionExercises.CardSuit;

import java.util.Scanner;

public class Main {
    public enum Suits {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }
    public static void main(String[] args) {
        new Scanner(System.in).nextLine();

        System.out.println("Card Suits:");
        int count = 0;
        for (Suits suit : Suits.values()) {
            System.out.println("Ordinal value: "+count+"; Name value: " + suit);
            count++;
        }

    }
}
