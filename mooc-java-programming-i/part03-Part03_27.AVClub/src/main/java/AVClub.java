
import java.util.Scanner;

public class AVClub {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] pieces = input.split(" ");
            for (String item : pieces) {
                if (item.contains("av")) {
                    System.out.println(item);
                }
            }
        }

    }
}
