public class Calculator2 {
  public static void main(String[] args) {
    float nummer1 = Float.parseFloat (args[0]);
    float nummer2 = Float.parseFloat (args[2]);
    String operator = args[1];
    switch (operator) {
      case "+": System.out.println(nummer1 + nummer2);
      break;
      case "-": System.out.println(nummer1 - nummer2);
      break;
      case "*": System.out.println(nummer1 * nummer2);
      break;
      case "/": System.out.println(nummer1 / nummer2);
      break;
    }
  }
}
