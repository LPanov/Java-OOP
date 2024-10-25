package WorkingWithAbstractionExercises.CardRank;

import java.util.Scanner;

public class Main {
    public enum Ranks{
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }
    public static void main(String[] args) {
        new Scanner(System.in).nextLine();

        System.out.println("Card Ranks:");
        int count = 0;
        for (Ranks rank : Ranks.values()) {
            System.out.println("Ordinal value: "+count+"; Name value: " + rank);
            count++;
        }
    }
}
