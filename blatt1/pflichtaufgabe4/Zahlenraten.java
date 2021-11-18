public class Zahlenraten {
  public static void main(String[] args) {
    if (args.length >= 1) {
      int numToGuess = Integer.parseInt (args[0]);
      computerRaten(numToGuess);
    }
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
      System.out.println(counter);
    }
  }
}
