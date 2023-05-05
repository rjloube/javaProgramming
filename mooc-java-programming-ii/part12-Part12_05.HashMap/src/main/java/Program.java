
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here
        
        HashMap myHashMap = new HashMap();
        
        myHashMap.add("key", "value");
        myHashMap.remove("key");
        
        String myVar = "" + 1;
        System.out.println(myVar instanceof String);

    }

}
