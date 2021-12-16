public class Card {
    Suits suit;
    Ranks rank;
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
    public void setRanks(Ranks rank){
        this.rank = rank;
    }
    public void setSuits(Suits suit){
        this.suit = suit;
    }
    public String toString(){
        return rank.toString() + " of " + suit.toString();
    }
}
