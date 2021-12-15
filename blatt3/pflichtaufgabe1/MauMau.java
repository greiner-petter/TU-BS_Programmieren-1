import java.util.Scanner;
public class MauMau{
    public static void main(String[] args) {

        boolean isDiscardDeck = true;
        boolean isFirstCard = true;
        Stack playDeck = new Stack();
        Stack discardDeck = new Stack(isDiscardDeck);

        //Player
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name:");
        String playerName = sc.nextLine();

        Player player1 = new Player(playerName);
        Player playerC = new Player();

        //System.out.println(player1.showHand());

        //First Card
        //System.out.println(playDeck.toString());
        Card firstCard = playDeck.draw();
        //System.out.println(" " + firstCard.toString());
        Card lastCard = discardDeck.show();
        discardDeck.playCard(firstCard, lastCard,  isFirstCard);
        isFirstCard = false;

        System.out.println(discardDeck.show());
        lastCard = discardDeck.show();


        //System.out.println(player1.toString());
        player1.playCardPlayer(lastCard);






    }
}
