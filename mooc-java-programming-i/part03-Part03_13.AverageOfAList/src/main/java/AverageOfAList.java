
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfAList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // implement here a program, that first reads user input
        // adding them on a list until user gives -1.
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }
            list.add(input);
        }
        
        // Then it computes the average of the numbers on the list
        // and prints it.
        
        int sum = 0;
        int count = 0;
        
        for (int number:list) {
            sum += number;
            count += 1;
        }
        
        System.out.println("Average: " + (double) sum / count);
        
    }
}
