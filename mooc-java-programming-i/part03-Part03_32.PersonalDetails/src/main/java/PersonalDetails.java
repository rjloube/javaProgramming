
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        int ageCount = 0;
        int ageSum = 0;

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String pieces[] = input.split(",");
            names.add(pieces[0]);
            ageCount += 1;
            ageSum += Integer.valueOf(pieces[1]);
        }

        String maxName = (names.get(0));
        for (int i = 0; i < names.size(); i++) {
            if ((names.get(i)).length() > maxName.length()) {
                maxName = names.get(i);
            }
        }

        System.out.println("Longest name: " + maxName);
        System.out.println("Average age of birth years: " + (double) ageSum / ageCount);

    }
}
