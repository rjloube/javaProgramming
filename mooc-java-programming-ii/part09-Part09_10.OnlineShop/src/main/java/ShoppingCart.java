
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjloube
 */
public class ShoppingCart {
    
    private Map<String, Item> items;
    
    public ShoppingCart() {
        this.items = new HashMap<>();
    }
    
    public void add(String product, int price) {
        Item itemToAdd = new Item(product, 1, price);
        
        if (this.items.containsKey(product)) {
            this.items.get(product).increaseQuantity();
        } else {
            this.items.put(product, itemToAdd);
        }
        
    }
    
    public int price() {
        int totalPrice = 0;
        
        for (Item item : this.items.values()) {
            totalPrice += item.price();
        }
        
        return totalPrice;
    }
    
    public void print() {
        for (Item item : this.items.values()) {
            System.out.println(item);
        }
    }
    
}
