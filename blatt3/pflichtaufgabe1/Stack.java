public class Stack {
    /** array which holds the play deck */
    private Card[] playDeck = new Card[32];

    /** array which holds the discard deck */
    private Card[] discardDeck = new Card[32];

    /** determines if the deck that is created is the discard deck or not */
    private boolean isDiscardDeck;

    /** determines where to place the card that is being played */
    private int whereToPlace = 0;

    /** stores all suit values to be used when creating the play deck */
    private Suits[] suits = Suits.values();

    /** stores all rank values to be used when creating the play deck */
    private Ranks[] ranks = Ranks.values();

    /** stores the empty card */
    private Card emptyCard = new Card(Suits.EMPTY, Ranks.EMPTY);

    /**
    constructor for the play deck: fills the play deck with one of each card
    */
    public Stack() {
        int counter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                playDeck[counter] = new Card(suits[i], ranks[j]);
                counter++;
            }
        }
    }

    /**
    constructor for the discard deck: fills the discard deck with empty cards
    @param isDiscardDeck differenciates the discard deck constructor from the play deck constructor
    */
    public Stack(boolean isDiscardDeck) {
        this.isDiscardDeck = isDiscardDeck;
        int discardCounter = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 8; j++) {
                discardDeck[discardCounter] = emptyCard;
                discardCounter++;
            }
        }
    }

    /**
    draws a random card that is not an empty card from the playdeck
    @return randomCard the random card that was drawn
    */
    public Card draw() {
        Card randomCard = emptyCard;
        while (randomCard.getRanks() == Ranks.EMPTY) {
            int i = (int) (Math.random() * 32);
            randomCard = playDeck[i];
            playDeck[i] = emptyCard;
        }
        return randomCard;
    }

    /**
    plays the selected card onto the discard deck and returns if the card is allowed to be played
    @param cardToBePlayed is the card that is to be played
    @param lastCard is the current card on the discard deck
    @param isFirstCard determines weather or not the current card is segnigicant or not
    @return legitimateTurn determines if the card was successfully played
    */
    public boolean playCard(Card cardToBePlayed, Card lastCard, boolean isFirstCard) {
        boolean legitimateTurn = false;
        if (isFirstCard) {
            whereToPlace = 0;
            discardDeck[whereToPlace] = cardToBePlayed;
            whereToPlace++;
            legitimateTurn = true;
        } else {
            if (lastCard.getRanks() == cardToBePlayed.getRanks() || lastCard.getSuits() == cardToBePlayed.getSuits()) {
                discardDeck[whereToPlace] = cardToBePlayed;
                whereToPlace++;
                legitimateTurn = true;
            }
        }
        return legitimateTurn;
    }

    /**
    goes through the play deck checks if it is empty
    @return deckIsEmpty empty or not
    */
    public boolean checkIfEmpty() {
        boolean deckIsEmpty = true;
        for (int i = 0; i < 32; i++) {
            if (playDeck[i].getRanks() != Ranks.EMPTY) {
                deckIsEmpty = false;
            }
        }
        return deckIsEmpty;
    }

    /**
    show the current card on the discard deck
    @return discardDeck at the position of the current card
    */
    public Card show() {
        return discardDeck[whereToPlace - 1];
    }

    public Card[] getPlayDeck() {
        return playDeck;
    }

    public Card[] getDiscardDeck() {
        return discardDeck;
    }
}
