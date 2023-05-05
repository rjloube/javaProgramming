
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rjloube
 */
public class Box implements Packable {

    private ArrayList<Packable> items;
    private double capacity;

    public Box(double capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Packable newItem) {
        double weight = this.weight();

        if (weight + newItem.weight() <= this.capacity) {
            this.items.add(newItem);
        }
    }

    @Override
    public double weight() {
        double weight = 0;
        for (Packable existingItem : this.items) {
            weight += existingItem.weight();
        }
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + this.weight() + " kg";
    }

}
