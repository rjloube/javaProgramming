
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
public class ChangeHistory {

    private ArrayList<Double> changeHistory;

    public ChangeHistory() {
        this.changeHistory = new ArrayList<>();
    }

    public void add(double status) {
        this.changeHistory.add(status);
    }

    public void clear() {
        this.changeHistory.clear();
    }

    public double maxValue() {
        if (this.changeHistory.isEmpty()) {
            return 0;
        } else {
            double maxValue = this.changeHistory.get(0);
            for (int i = 1; i < this.changeHistory.size(); i++) {
                if (this.changeHistory.get(i) > maxValue) {
                    maxValue = this.changeHistory.get(i);
                }
            }

            return maxValue;
        }
    }

    public double minValue() {
        if (this.changeHistory.isEmpty()) {
            return 0;
        } else {
            double minValue = this.changeHistory.get(0);
            for (int i = 1; i < this.changeHistory.size(); i++) {
                if (this.changeHistory.get(i) < minValue) {
                    minValue = this.changeHistory.get(i);
                }
            }

            return minValue;
        }
    }
    
    public double average() {
        if (this.changeHistory.isEmpty()) {
            return 0;
        } else {
            int count = 0;
            double sum = 0;
            
            for (double i : this.changeHistory) {
                count++;
                sum += i;
            }
            
            return sum / count;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.changeHistory);
    }

}
