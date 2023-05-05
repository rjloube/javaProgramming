
import java.util.Scanner;
import java.util.ArrayList;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String pieces[] = input.split(",");
            names.add(pieces[0]);
            ages.add(Integer.valueOf(pieces[1]));
        }
        
        int maxAge = ages.get(0);
        String maxName = names.get(0);
        for (int i = 0; i < ages.size(); i++) {
            if (ages.get(i) > maxAge) {
                maxAge = ages.get(i);
                maxName = names.get(i);
            }
        }
        
        System.out.println("Name of the oldest: " + maxName);


    }
}
