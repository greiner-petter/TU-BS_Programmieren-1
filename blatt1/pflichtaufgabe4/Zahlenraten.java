import java.util.Scanner;
public class Zahlenraten{
  public static void main(String[] args){

    if(args.length == 0 ){
      selberRaten();
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

}
