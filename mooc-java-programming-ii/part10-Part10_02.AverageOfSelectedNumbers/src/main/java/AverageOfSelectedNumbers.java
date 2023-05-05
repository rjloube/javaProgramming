
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> commands = new ArrayList<>();
        // toteuta ohjelmasi tänne

        System.out.println("Input numbers, type \"end\" to stop.");

        while (true) {
            String command = scanner.nextLine();

            if (command.equals("end")) {
                break;
            } else {
                commands.add(command);
            }
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String sign = scanner.nextLine();

        if (sign.equals("p")) {
            double averageOfPositives = commands.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(i -> i > 0)
                    .average()
                    .getAsDouble();

            System.out.println("Average of the positive numbers: " + averageOfPositives);
        } else if (sign.equals("n")) {
            double averageOfNegatives = commands.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(i -> i < 0)
                    .average()
                    .getAsDouble();

            System.out.println("Average of the negative numbers: " + averageOfNegatives);
        }

    }
}
