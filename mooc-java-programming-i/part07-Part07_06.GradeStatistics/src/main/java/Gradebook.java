
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
public class Gradebook {

    private ArrayList<Integer> grades;

    public Gradebook() {
        this.grades = new ArrayList<>();
    }

    public void add(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grades.add(grade);
        }
    }

    public double averageAll() {
        int sum = 0;
        int count = 0;
        for (int grade : this.grades) {
            sum += grade;
            count++;
        }

        return (double) sum / count;
    }

    public double averagePassing() {
        int sum = 0;
        int count = 0;
        for (int grade : this.grades) {
            if (grade >= 50) {
                sum += grade;
                count++;
            }
        }

        if (count == 0) {
            return -1;
        } else {
            return (double) sum / count;
        }
    }

    public double passPercentage() {
        int totalCount = 0;
        int passCount = 0;
        for (int grade : this.grades) {
            totalCount++;
            if (grade >= 50) {
                passCount++;
            }
        }

        return 100.0 * passCount / totalCount;
    }

    public int count(int i) {
        int[] distribution = new int[6]; // each index represents grade interval
        for (int grade : grades) {
            if (grade < 50) {
                distribution[0]++;
            } else if (grade < 60) {
                distribution[1]++;
            } else if (grade < 70) {
                distribution[2]++;
            } else if (grade < 80) {
                distribution[3]++;
            } else if (grade < 90) {
                distribution[4]++;
            } else {
                distribution[5]++;
            }
        }
        
        return distribution[i];
    }

}
