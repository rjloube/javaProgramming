
import java.util.Scanner;

public class SecondsInADay {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the number of days and collect response
        System.out.println("How many days would you like to convert to seconds?");
        int days = Integer.valueOf(scanner.nextLine());
        
        // Convert to seconds (86,400 seconds in a day) and print
        System.out.println(days * 86400);
        
    }
}
