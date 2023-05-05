
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("First number? ");
        int min = Integer.valueOf(scanner.nextLine());
        
        System.out.print("Second number? ");
        int max = Integer.valueOf(scanner.nextLine());
        
        int sum = 0;
        
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        
        System.out.println("The sum is " + sum);

    }
}
