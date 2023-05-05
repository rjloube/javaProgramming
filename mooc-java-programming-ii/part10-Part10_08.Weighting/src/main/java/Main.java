
import java.util.ArrayList;



public class Main {

    public static void main(String[] args) {
        // Use this main program for testing your classes!
        
        Item item100 = new Item("item100", 100);
        Item item50 = new Item("item50", 50);
        
        Suitcase suitcase200 = new Suitcase(200);
        
        suitcase200.addItem(item100);
        suitcase200.addItem(item50);
        
        System.out.println(suitcase200.totalWeight());
        suitcase200.printItems();
        
        Item item1000 = new Item("item1000", 1000);
        Item item500 = new Item("item500", 500);
        
        Suitcase suitcase2000 = new Suitcase(2000);
        
        suitcase2000.addItem(item1000);
        suitcase2000.addItem(item500);
        
        System.out.println("========================");
        
        Hold hold = new Hold(10000);
        
        hold.addSuitcase(suitcase200);
        hold.addSuitcase(suitcase2000);
        
        System.out.println(hold.totalWeight());
        hold.printItems();
    }

}
