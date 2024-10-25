package WorkingWithAbstractionExercises.CardsWithPower;

public class Card {
    Main.Suits suit;
    Main.Ranks rank;

    public Card(Main.Suits suit, Main.Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Main.Suits getSuit() {
        return suit;
    }

    public Main.Ranks getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Card name: "+this.rank+" of "+this.suit+"; Card power: ";
    }
}
