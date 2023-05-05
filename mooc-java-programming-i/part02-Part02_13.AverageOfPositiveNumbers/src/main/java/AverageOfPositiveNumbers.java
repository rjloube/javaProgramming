
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int countOfPositives = 0;
        int sumOfPositives = 0;
        
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            
            if (number == 0) {
                break;
            }
            
            if (number > 0) {
                countOfPositives = countOfPositives + 1;
                sumOfPositives = sumOfPositives + number;
            }
        }
        
        double average = (double) sumOfPositives / countOfPositives;
        
        if (average > 0) {
            System.out.println(average);
        } else {
            System.out.println("Cannot calculate the average");
        }
        
    }
}
