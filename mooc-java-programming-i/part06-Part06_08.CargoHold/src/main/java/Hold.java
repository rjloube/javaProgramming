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

public class Hold {

    private ArrayList<Suitcase> holdSuitcases;
    private int maximumWeight;

    public Hold(int maximumWeight) {
        holdSuitcases = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        int totalWeight = 0;

        for (Suitcase existingSuitcase : this.holdSuitcases) {
            totalWeight += existingSuitcase.totalWeight();
        }

        if (totalWeight + suitcase.totalWeight() <= this.maximumWeight) {
            this.holdSuitcases.add(suitcase);
        }
    }

    public void printItems() {
        for (Suitcase existingSuitcase : this.holdSuitcases) {
            existingSuitcase.printItems();
        }
    }

    @Override
    public String toString() {
        int totalWeight = 0;

        for (Suitcase existingSuitcase : this.holdSuitcases) {
            totalWeight += existingSuitcase.totalWeight();
        }
        return this.holdSuitcases.size() + " suitcases (" + totalWeight + " kg)";
    }

}
