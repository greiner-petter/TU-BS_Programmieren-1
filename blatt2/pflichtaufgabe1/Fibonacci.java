public class Fibonacci {
  public static void main(String[] args) {
    int max = Integer.parseInt(args[0]);
    int f0 = 0; // Fibonaccizahl 0
    int f1 = 1; // Fibonaccizahl 1
    int fn = 0;

    System.out.println(f0);
    System.out.println(f1);

    while (f0 + f1 <= max) {
      fn = f0 + f1;
      f0 = f1;
      f1 = fn;
      System.out.println(fn);
    }
  }
}
