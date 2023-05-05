
import java.util.Scanner;

public class Greeting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for their name
        System.out.println("What's your name?");
        
        // Save user input as variable
        String name = scanner.nextLine();
        
        // Print "Hi " followed by the user's name
        System.out.println("Hi " + name);
    }
}
