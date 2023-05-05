
import java.util.Scanner;

public class FromWhereToWhere {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Where to? ");
        int max = Integer.valueOf(scanner.nextLine());
        
        System.out.print("Where from? ");
        int min = Integer.valueOf(scanner.nextLine());
        
        for (int count = min; count <= max; count++) {
            System.out.println(count);
        }
    }
}
