import java.util.Scanner;
public class Zahlenraten{
  public static void main(String[] args){

    if(args.length == 0 ){
      selberRaten();
    }

    if (args.length >= 1) {
      int numToGuess = Integer.parseInt (args[0]);
      computerRaten(numToGuess);
    }

  }

  public static void selberRaten(){
    double zufallsZahl = Math.random() *100 + 1;
    int randomNumber = (int)zufallsZahl;

    System.out.println("Schreibe bitte eine Zahlen zwischen 1 und 100.");

    Scanner sc = new Scanner(System.in);
    int nextNumber = sc.nextInt();

    while(randomNumber != nextNumber){
      if(randomNumber < nextNumber && nextNumber < 101){
        System.out.println("Die eingegebende Zahl ist zu groß!");
      }else if(randomNumber > nextNumber && nextNumber > 0){
        System.out.println("Die eingegebende Zahl ist zu klein!");
      }else{
        System.out.println("Die Eingabe ist nicht korrekt! Beachte es soll eine Zahl zwischen 1 und 100 sein.");
      }
      nextNumber = sc.nextInt();

    }
    System.out.println("Richtige Nummer!");
  }

  public static void computerRaten(int a) {
    if (a >= 101) {
      System.out.println("Diese Zahl ist leider zu groß.");
    }
    else if (a <= 0) {
      System.out.println("Diese Zahl ist leider zu klein.");
    }
    else {
      int randomNumber = 0;
      int counter = 0;
      while (randomNumber != a) {
        double zahl = ((Math.random() * (101 - 1)) + 1);
        randomNumber = (int)zahl;
        counter++;
      }
      System.out.println("Der Computer hat " + counter + " Versuche gebraucht um die Zahl zu erraten.");
    }
  }
}
