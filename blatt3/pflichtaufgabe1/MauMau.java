import java.util.Scanner;
public class MauMau{
    public static void main(String[] args) {

        boolean isDiscardDeck = true;
        boolean isFirstCard = true;
        Stack playDeck = new Stack();
        Stack discardDeck = new Stack(isDiscardDeck);
        boolean winner = false;
        boolean validInput;
        Card cardDrawn;
        Card cardToBePlayed;
        Suits suit;
        Ranks rank;

        //Player erstellt
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String playerName = sc.nextLine();
        System.out.println("");
        Player player1 = new Player(playerName, playDeck);
        Player playerC = new Player(playDeck);

        //First Card
        Card firstCard = playDeck.draw();
        Card lastCard = new Card(suit = Suits.EMPTY, rank = Ranks.EMPTY);
        discardDeck.playCard(firstCard, lastCard,  isFirstCard);
        isFirstCard = false;

        //Beginn des Spiels
        while(winner == false) {
            lastCard = discardDeck.show();
            validInput = false;
            System.out.println(playDeck.pdtoString());
            while (validInput == false) {
                System.out.println("What would you like to do?");
                System.out.println("(put) a card down, (take) a card, (show) your hand or (look) at the current card");
                String input = sc.nextLine();
                System.out.println("");
                switch (input) {
                    case "put":
                        player1.playCardPlayer(lastCard, discardDeck, playDeck);
                        validInput = true;
                        break;
                    case "take":
                        cardDrawn = player1.drawCard(playDeck);
                        System.out.println("You drew the " + cardDrawn + "\n");
                        validInput = true;
                        break;
                    case "show":
                        System.out.print("You have these cards:");
                        System.out.println(player1.toString() + "\n");
                        break;
                    case "look":
                        System.out.println("The current card on the deck is the " + lastCard + "\n");
                        break;
                    case "exit":
                        winner = true;
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }
            if (playDeck.checkIfEmpty()) {
                System.out.println(playDeck.pdtoString());
                System.out.println(discardDeck.ddtoString());
                Card currentPlayingCard = discardDeck.show();
                for(int i = 0; i < 32; i++){
                    playDeck.playDeck[i] = discardDeck.discardDeck[i];
                }
                for(int i = 0; i < 32; i++){
                    discardDeck.discardDeck[i].setSuits(Suits.EMPTY);
                    discardDeck.discardDeck[i].setRanks(Ranks.EMPTY);
                }
                System.out.println(playDeck.pdtoString());
                System.out.println(discardDeck.ddtoString());
                //playDeck.playDeck[playDeck.whereToPlace - 1].setRanks(Ranks.EMPTY);
                //playDeck.playDeck[playDeck.whereToPlace - 1].setSuits(Suits.EMPTY);
                //System.out.println(playDeck.pdtoString());
                //System.out.println(discardDeck.ddtoString());

            }
            lastCard = discardDeck.show();
            playerC.playCardComputer(lastCard, discardDeck, playDeck);
            System.out.println("");
            if (playDeck.checkIfEmpty()) {

            }
            if (player1.playerHand.size() == 0) {
                winner = true;
                System.out.println("Congratulations " + playerName + ", you won!");
            } else if (playerC.computerHand.size() == 0) {
                winner = true;
                System.out.println("Sorry " + playerName + ", you lost :(");
            }
        }
    }
}
