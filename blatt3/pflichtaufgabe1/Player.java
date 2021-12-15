import java.util.ArrayList;
import java.util.Scanner;
public class Player extends Stack{
    private String playerName;
    boolean isFirstCard = false;
    boolean legitimateTurn = false;
    private ArrayList<Card> playerHand = new ArrayList<Card>();
    private ArrayList<Card> computerHand = new ArrayList<Card>();
    Scanner sc = new Scanner(System.in);
    public Player(){
        playerName = "computer";
        for (int i = 0; i < 5 ; i++) {
            computerHand.add(draw());
        }
    }
    public Player(String playerName){
        this.playerName = playerName;
        for (int i = 0; i < 5 ; i++) {
            playerHand.add(draw());
        }
    }
    public void drawCard(){
        playerHand.add(draw());
    }
    public ArrayList<Card> showHand(){
        return playerHand;
    }
    public void playCardPlayer(Card lastCard){
        System.out.println(toString());
        System.out.println("Which number card do you want to play?");
        while(legitimateTurn == false){
            String stringResponse = sc.nextLine();
            int intResponse;
            try{
                intResponse = Integer.parseInt(stringResponse);
                if (0 < intResponse && intResponse <= playerHand.size()) {
                    legitimateTurn = playCard(playerHand.get(intResponse - 1), lastCard, isFirstCard);
                    if (legitimateTurn) {
                        playerHand.remove(intResponse - 1);
                    }
                }
                else {
                    System.out.println("Invalid card");
                }
            }
            catch(NumberFormatException ex){
                System.out.println("Invalid input");
            }
        }
    }
    public void playCardComputer(){

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
