
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rjloube
 */
public class Warehouse {

    private Map<String, Integer> products;
    private Map<String, Integer> stock;

    public Warehouse() {
        this.products = new HashMap<>();
        this.stock = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product) {
        if (this.products.containsKey(product)) {
            return this.products.get(product);
        } else {
            return -99;
        }
    }

    public int stock(String product) {
        if (this.products.containsKey(product)) {
            return this.stock.get(product);
        } else {
            return 0;
        }
    }

    public boolean take(String product) {
        if (this.stock(product) > 0) {
            this.stock.put(product, this.stock.get(product) - 1);
            return true;
        } else {
            return false;
        }
    }
    
    public Set<String> products() {
        return this.products.keySet();
    }

}
