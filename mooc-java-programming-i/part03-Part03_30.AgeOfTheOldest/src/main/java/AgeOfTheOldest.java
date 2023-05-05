
import java.util.Scanner;
import java.util.ArrayList;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> ages = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String pieces[] = input.split(",");
            int value = Integer.valueOf(pieces[1]);
            ages.add(value);

        }

        int max = ages.get(0);
        for (int i = 1; i < ages.size(); i++) {
            if (ages.get(i) > max) {
                max = ages.get(i);
            }
        }
        System.out.println("Age of the oldest: " + max);
    }

}
