public class Calculator {
  public static void main(String[] args) {
    int nummer1 = Integer.parseInt (args[0]);
    int nummer2 = Integer.parseInt (args[2]);
    char operator = args[1].charAt(0);
    if (operator == '+') {
      System.out.println(nummer1 + nummer2);
    }
    else {
      System.out.println(nummer1 - nummer2);
    }
  }
}
