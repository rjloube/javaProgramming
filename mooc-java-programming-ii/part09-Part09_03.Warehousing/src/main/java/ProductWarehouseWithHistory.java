/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjloube
 */
public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory changeHistory;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        this.changeHistory = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }

    @Override
    public void addToWarehouse(double amount) {
        this.changeHistory.add(super.getBalance() + amount);
        super.addToWarehouse(amount);
    }

    @Override
    public double takeFromWarehouse(double amount) {
        this.changeHistory.add(super.getBalance() - amount);
        return super.takeFromWarehouse(amount);
    }

    public void printAnalysis() {
        System.out.println("Product: " + this.getName()
                + "\n History: " + this.history()
                + "\nLargest amount of product: " + this.changeHistory.maxValue()
                + "\nSmallest amount of product: " + this.changeHistory.minValue()
                + "\nAverage: " + this.changeHistory.average()
        );
    }

    public String history() {
        return this.changeHistory.toString();
    }

}
