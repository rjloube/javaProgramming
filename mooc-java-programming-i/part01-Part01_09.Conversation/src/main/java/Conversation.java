
import java.util.Scanner;

public class Conversation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask how the user is doing, save response
        System.out.println("Greetings! How are you doing?");
        String status = scanner.nextLine();
        
        // Ask user for more details, save response
        System.out.println("Oh, how interesting. Tell me more!");
        String more = scanner.nextLine();
        
        // Print thank you message to user
        System.out.println("Thanks for sharing!");

    }
}
