import java.util.ArrayList;

import java.util.Scanner;

public class Player {
    /** arraylist which holds the players cards */
    private ArrayList<Card> playerHand = new ArrayList<Card>();

    /** arraylist which holds the computers cards */
    private ArrayList<Card> computerHand = new ArrayList<Card>();

    /** stores the players name */
    private String playerName;

    /** determines if the card that is played is the first card in the discard deck */
    private boolean isFirstCard = false;

    /** determines if the turn the player did is legitimate */
    private boolean legitimateTurn;

    /** stores the drawn card */
    private Card cardDrawn;

    /** scanner */
    private Scanner sc = new Scanner(System.in);

    /**
    constructor for the computer, deals the computer cards
    @param playDeck from this deck the cards are drawn
    */
    public Player(Stack playDeck) {
        playerName = "computer";
        for (int i = 0; i < 5; i++) {
            computerHand.add(playDeck.draw());
        }
    }

    /**
    constructor for the player, deals the player cards
    @param playerName takes in the name the player put in
    @param playDeck from this deck the cards are drawn
    */
    public Player(String playerName, Stack playDeck) {
        this.playerName = playerName;
        for (int i = 0; i < 5; i++) {
            playerHand.add(playDeck.draw());
        }
    }

    /**
    adds a card from the playdeck to the player hand and returns the card drawn
    @param playDeck from this deck the cards are drawn
    @return cardDrawn shows the player which card they drew
    */
    public Card drawCard(Stack playDeck) {
        cardDrawn = playDeck.draw();
        playerHand.add(cardDrawn);
        return cardDrawn;
    }

    /**
    converts the players hand to a string for better output to the console
    @return number + rank of suit
    */
    public String showHand() {
        String showHand = "";
        int counter = 1;
        for (Card card : playerHand) {
            showHand += "\n" + counter + " " + card.toString();
            counter++;
        }
        return showHand;
    }

    /**
    asks the player which one of their cards they want to play then checks if they card is allowed to be played
    @param lastCard is the current card on the discard deck
    @param discardDeck if the card can be played it will be put above the last card into the discard deck
    @param playDeck if the player takes a card it will be drawn from the play deck
    */
    public void playCardPlayer(Card lastCard, Stack discardDeck, Stack playDeck) {
        System.out.println("Which number card do you want to play? ('take' to draw a card instead)");
        legitimateTurn = false;
        while (legitimateTurn == false) {
            String stringResponse = sc.nextLine();
            System.out.println("");
            if (stringResponse.equals("take")) {
                System.out.println("You drew the " + playerHand.add(playDeck.draw()));
                legitimateTurn = true;
            } else {
                int intResponse;
                try {
                    intResponse = Integer.parseInt(stringResponse);
                    if (0 < intResponse && intResponse <= playerHand.size()) {
                        legitimateTurn = discardDeck.playCard(playerHand.get(intResponse - 1), lastCard, isFirstCard);
                        if (legitimateTurn) {
                            System.out.println("You played the " + playerHand.get(intResponse - 1) + "\n");
                            playerHand.remove(intResponse - 1);
                        } else {
                            System.out.println("You cannot play this card");
                        }
                    } else {
                        System.out.println("Invalid card");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid input");
                }
            }
        }
    }

    /**
    loops through the computers cards and plays the first playabe one, if none are valid the computer draws a card
    @param lastCard is the current card on the discard deck
    @param discardDeck if the card can be played it will be put above the last card into the discard deck
    @param playDeck if the computer draws a card it will be drawn from the play deck
    */
    public void playCardComputer(Card lastCard, Stack discardDeck, Stack playDeck) {
        legitimateTurn = false;
        for (int i = 0; i < computerHand.size(); i++) {
            legitimateTurn = discardDeck.playCard(computerHand.get(i), lastCard, isFirstCard);
            if (legitimateTurn == true) {
                System.out.print("The computer played the " + computerHand.get(i));
                computerHand.remove(i);
                System.out.println(" and has " + computerHand.size() + " card(s) left");
                i = computerHand.size();
            }
        }
        if (legitimateTurn == false) {
            computerHand.add(playDeck.draw());
            System.out.println("The computer drew a card and has " + computerHand.size() + " card(s) left");
        }
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getComputerHand() {
        return computerHand;
    }
}
