/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjloube
 */
import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Item> items;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        int existingWeight = 0;

        for (Item existingItem : this.items) {
            existingWeight += existingItem.getWeight();
        }

        if (!(existingWeight + item.getWeight() > this.maxWeight)) {
            this.items.add(item);
        }
    }

    public void printItems() {
        String inTheList = "";

        for (int i = 0; i < this.items.size() - 1; i++) {
            inTheList += this.items.get(i).getName() + " (" + this.items.get(i).getWeight() + " kg)\n";
        }

        if (!(this.items.isEmpty())) {
            Item lastItem = this.items.get(this.items.size() - 1);
            inTheList += lastItem.getName() + " (" + lastItem.getWeight() + " kg)";
        }

        System.out.println(inTheList);
        /*
        for (Item existingItem : this.items) {
            inTheList += existingItem.getName() + " (" + existingItem.getWeight() + " kg)\n";
        }

        System.out.println(inTheList);
         */
    }

    public int totalWeight() {
        int totalWeight = 0;

        for (Item existingItem : this.items) {
            totalWeight += existingItem.getWeight();
        }

        return totalWeight;
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }

        Item heaviestItem = this.items.get(0);

        for (Item existingItem : this.items) {
            if (existingItem.getWeight() > heaviestItem.getWeight()) {
                heaviestItem = existingItem;
            }
        }

        return heaviestItem;

    }

    @Override
    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.items.size() == 1) {
            return "1 item (" + this.items.get(0).getWeight() + " kg)";
        }

        int existingWeight = 0;

        for (Item existingItem : this.items) {
            existingWeight += existingItem.getWeight();
        }

        return this.items.size() + " items (" + existingWeight + " kg)";

    }

}
