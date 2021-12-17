import java.util.Scanner;

public class MauMau {
    public static void main(String[] args) {
        //variables
        boolean isDiscardDeck = true;
        Stack playDeck = new Stack();
        Stack discardDeck = new Stack(isDiscardDeck);
        boolean winner = false;
        boolean validInput;
        Card cardDrawn;
        Card cardToBePlayed;
        Card emptyCard = new Card(Suits.EMPTY, Ranks.EMPTY);

        //create player and computer
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String playerName = sc.nextLine();
        System.out.println("");
        Player player1 = new Player(playerName, playDeck);
        Player playerC = new Player(playDeck);

        //play the first card
        Card firstCard = playDeck.draw();
        Card lastCard = emptyCard;
        discardDeck.playCard(firstCard, lastCard,  true);

        //start of the game loop
        while (winner == false) {
            lastCard = discardDeck.show();
            validInput = false;
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
                        System.out.println(player1.showHand() + "\n");
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
                firstCard = discardDeck.show();
                for (int i = 0; i < 32; i++) {
                    playDeck.getPlayDeck()[i] = discardDeck.getDiscardDeck()[i];
                    if (playDeck.getPlayDeck()[i] == firstCard) {
                        playDeck.getPlayDeck()[i] = emptyCard;
                    }
                }
                discardDeck = new Stack(isDiscardDeck);
                discardDeck.playCard(firstCard, lastCard, true);
            }
            if (player1.getPlayerHand().size() == 0) {
                winner = true;
                System.out.println("Congratulations " + playerName + ", you won!");
            } else if (playerC.getComputerHand().size() == 0) {
                winner = true;
                System.out.println("Sorry " + playerName + ", you lost :(");
            }
            if (winner == false) {
                lastCard = discardDeck.show();
                playerC.playCardComputer(lastCard, discardDeck, playDeck);
                System.out.println("");
                if (playDeck.checkIfEmpty()) {
                    firstCard = discardDeck.show();
                    for (int i = 0; i < 32; i++) {
                        playDeck.getPlayDeck()[i] = discardDeck.getDiscardDeck()[i];
                        if (playDeck.getPlayDeck()[i] == firstCard) {
                            playDeck.getPlayDeck()[i] = emptyCard;
                        }
                    }
                    discardDeck = new Stack(isDiscardDeck);
                    discardDeck.playCard(firstCard, lastCard, true);
                }
                if (player1.getPlayerHand().size() == 0) {
                    winner = true;
                    System.out.println("Congratulations " + playerName + ", you won!");
                } else if (playerC.getComputerHand().size() == 0) {
                    winner = true;
                    System.out.println("Sorry " + playerName + ", you lost :(");
                }
            }
        }
    }
}
