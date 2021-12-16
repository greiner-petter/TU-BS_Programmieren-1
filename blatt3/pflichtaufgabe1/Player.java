import java.util.ArrayList;
import java.util.Scanner;
public class Player{
    String playerName;
    boolean isFirstCard = false;
    boolean legitimateTurn;
    Card cardDrawn;
    ArrayList<Card> playerHand = new ArrayList<Card>();
    ArrayList<Card> computerHand = new ArrayList<Card>();
    Scanner sc = new Scanner(System.in);
    public Player(Stack playDeck){
        playerName = "computer";
        for (int i = 0; i < 15 ; i++) {
            computerHand.add(playDeck.draw());
        }
    }
    public Player(String playerName, Stack playDeck){
        this.playerName = playerName;
        for (int i = 0; i < 15 ; i++) {
            playerHand.add(playDeck.draw());
        }
    }
    public Card drawCard(Stack playDeck){
        cardDrawn = playDeck.draw();
        playerHand.add(cardDrawn);
        return cardDrawn;
    }
    public ArrayList<Card> showHand(){
        return playerHand;
    }
    public void playCardPlayer(Card lastCard, Stack discardDeck, Stack playDeck){
        //System.out.println(toString());
        System.out.println("Which number card do you want to play? ('take' to draw a card instead)");
        legitimateTurn = false;
        while(legitimateTurn == false){
            String stringResponse = sc.nextLine();
            System.out.println("");
            if (stringResponse.equals("take")) {
                playDeck.draw();
                legitimateTurn = true;
            } else {
                int intResponse;
                try{
                    intResponse = Integer.parseInt(stringResponse);
                    if (0 < intResponse && intResponse <= playerHand.size()) {
                        legitimateTurn = discardDeck.playCard(playerHand.get(intResponse - 1), lastCard, isFirstCard);
                        if (legitimateTurn) {
                            playerHand.remove(intResponse - 1);
                        } else {
                            System.out.println("You cannot play this card");
                        }
                    }
                    else {
                        System.out.println("Invalid card");
                    }
                }
                catch (NumberFormatException ex){
                    System.out.println("Invalid input");
                }
            }
        }
    }
    public void playCardComputer(Card lastCard, Stack discardDeck, Stack playDeck){
        legitimateTurn = false;
        for (int i = 0; i < computerHand.size(); i++) {
            legitimateTurn = discardDeck.playCard(computerHand.get(i), lastCard, isFirstCard);
            if (legitimateTurn == true) {
                System.out.println("The computer played the " + computerHand.get(i));
                computerHand.remove(i);
                i = computerHand.size();
            }
        }
        if (legitimateTurn == false) {
            computerHand.add(playDeck.draw());
            System.out.println("The computer drew a card");
        }
    }
    public String toString(){
        String deckToString = "";
        int counter2 = 1;
        for (Card card : playerHand){
            deckToString += "\n" + counter2 + " " + card.toString();
            counter2++;
        }
    return deckToString;
    }
}
