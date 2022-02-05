import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean validPassword = false;
        Scanner scan = new Scanner(System.in);
        while (!validPassword) {
            System.out.print("Enter a password: ");
            Password password = new Password(scan.nextLine());
            try {
                if (password.checkPassword()) {
                    validPassword = true;
                } else {
                    throw new WeakPasswordException();
                }
            } catch (WeakPasswordException e) {
                System.out.println("Weak password, try again.");
            }
        }
    }
}
