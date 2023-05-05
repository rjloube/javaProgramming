
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username1 = "alex";
        String password1 = "sunshine";

        String username2 = "emma";
        String password2 = "haskell";

        System.out.print("Enter username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Enter password: ");
        String passwordInput = scanner.nextLine();

        if (usernameInput.equals("alex") && passwordInput.equals("sunshine")) {
            System.out.println("You have successfully logged in!");
        } else if (usernameInput.equals("emma") && passwordInput.equals("haskell")) {
            System.out.println("You have successfully logged in!");
        } else {
            System.out.println("Incorrect username or password!");
        }

    }
}
