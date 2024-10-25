package WorkingWithAbstractionExercises.CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    public enum Suits {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }

    public static int getPower(Card card) {
        int power = 0;
        switch (card.getRank()) {
            case ACE -> power += 14;
            case TWO -> power += 2;
            case THREE -> power += 3;
            case FOUR -> power += 4;
            case FIVE -> power += 5;
            case SIX -> power += 6;
            case SEVEN -> power += 7;
            case EIGHT -> power += 8;
            case NINE -> power += 9;
            case TEN -> power += 10;
            case JACK -> power += 11;
            case QUEEN -> power += 12;
            case KING -> power += 13;
        }

        switch (card.getSuit()) {
            case DIAMONDS -> power += 13;
            case HEARTS -> power += 26;
            case SPADES -> power += 39;
        }

        return power;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Ranks rank = Ranks.valueOf(reader.readLine());
        Suits suit = Suits.valueOf(reader.readLine());

        Card card = new Card(suit, rank);

        System.out.println(card.toString() + getPower(card));
    }
}
