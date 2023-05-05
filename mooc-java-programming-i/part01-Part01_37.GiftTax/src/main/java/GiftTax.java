
import java.util.Scanner;

public class GiftTax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Value of the gift?");
        int value = Integer.valueOf(scan.nextLine());
        
        if (value < 5000) {
            System.out.println("No tax!");
        } else if (value >= 5000 && value <=25000) {
            System.out.println(100 + (value - 5000) * 0.08);
        } else if (value > 25000 && value <= 55000) {
            System.out.println(1700 + (value - 25000) * 0.10);
        } else if (value > 55000 && value <=200000) {
            System.out.println(4700 + (value - 55000) * 0.12);
        } else if (value > 200000 && value <= 1000000) {
            System.out.println(22100 + (value - 200000) * .15);
        } else if (value > 1000000) {
            System.out.println(142100 + (value - 1000000) * .17);
        }

    }
}
