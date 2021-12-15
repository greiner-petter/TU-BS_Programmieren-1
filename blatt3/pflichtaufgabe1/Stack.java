import java.util.Random;
public class Stack {
    private boolean isDiscardDeck;
    private Card[] playDeck = new Card[32];
    private Card[] discardDeck = new Card[32];
    private int counter = 0;
    private int discardCounter = 0;
    private int whereToPlace = 0;
    private Suits suit;
    private Ranks rank;
    private Suits[] suits = Suits.values();
    private Ranks[] ranks = Ranks.values();

    public Stack(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                playDeck[counter] = new Card(suits[i], ranks[j]);
                counter++;
            }
        }
    }
    public Stack(boolean isDiscardDeck){
        this.isDiscardDeck = isDiscardDeck;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                discardDeck[discardCounter] = new Card(suit = Suits.EMPTY, rank = Ranks.EMPTY);
                discardCounter++;
            }
        }
    }
    public Card draw(){
        Card randomCard = new Card(suit = Suits.EMPTY, rank = Ranks.EMPTY);
        while (randomCard.getRanks() == Ranks.EMPTY) {
            int i = (int) (Math.random() * 32);
            //System.out.println(i);
            randomCard = playDeck[i];
            playDeck[i] = new Card(suit = Suits.EMPTY, rank = Ranks.EMPTY);
        }
        return randomCard;
    }
    public boolean playCard(Card cardToBePlayed, Card lastCard, boolean isFirstCard){
        boolean legitimateTurn = false;
        //System.out.println("lastCard: " + lastCard.toString());
        //System.out.println("cardToBePlayed: " + cardToBePlayed.toString());
        if(isFirstCard){
            discardDeck[0] = cardToBePlayed;
            legitimateTurn = true;
        }else{
            if(lastCard.getRanks() == cardToBePlayed.getRanks() || lastCard.getSuits() == cardToBePlayed.getSuits()){
                discardDeck[whereToPlace] = cardToBePlayed;
                legitimateTurn = true;
            }else{
                System.out.println("You cannot play this card");
            }
        }
        return legitimateTurn;
    }
    public boolean checkIfEmpty(){
        boolean deckIsEmpty = true;
        for (int i = 0; i < 32; i++) {
            if (playDeck[i].getRanks() != Ranks.EMPTY) {
                deckIsEmpty = false;
            }
        }
        return deckIsEmpty;
    }
    public Card show(){
        Card cardToShow = new Card(suit = Suits.EMPTY, rank = Ranks.EMPTY);
        for(int  i = 31; i >= 0; i--){
            if(discardDeck[i].getRanks() != Ranks.EMPTY){
                cardToShow = discardDeck[i];
                whereToPlace = i + 1;
                i = 0;
            }
        }
        return cardToShow;
    }
    public String toString(){
        String deckToString = "";
        int counter2 = 0;
        for (Card card : playDeck){
            deckToString += "\n" + counter2 + " " + card.toString();
            counter2++;
        }
    return deckToString;
    }
}
