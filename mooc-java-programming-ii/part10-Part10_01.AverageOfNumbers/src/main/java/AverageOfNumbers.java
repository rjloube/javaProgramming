
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> commands = new ArrayList<>();
        // Write your program here

        System.out.println("Input numbers, type \"end\" to stop.");

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            } else {
                commands.add(command);
            }
        }

        double average = commands.stream()
                .mapToInt(s -> Integer.valueOf(s))
                .average()
                .getAsDouble();
        
        System.out.println("average of the numbers: " + average);
    }
}
