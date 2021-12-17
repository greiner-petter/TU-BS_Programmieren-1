public class Card {
    /** suit enum */
    private Suits suit;

    /** rank enum */
    private Ranks rank;

    /**
    constructor for the card
    @param suit
    @param rank
    */
    public Card(Suits suit, Ranks rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suits getSuits() {
        return suit;
    }

    public Ranks getRanks() {
        return rank;
    }

    /**
    converts the card to a string for better output to the console
    @return rank of suit
    */
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }
}
