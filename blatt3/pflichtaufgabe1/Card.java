public class Card {
    private Suits suit;
    private Ranks rank;
    public Card(Suits suit, Ranks rank){
        this.suit = suit;
        this.rank = rank;
    }
    public Ranks getRanks(){
        return rank;
    }
    public Suits getSuits(){
        return suit;
    }
    public String toString(){
        return rank.toString() + " of " + suit.toString();
    }
}
