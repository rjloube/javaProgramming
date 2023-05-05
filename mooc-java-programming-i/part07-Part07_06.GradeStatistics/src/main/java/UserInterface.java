
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rjloube
 */
public class UserInterface {

    private Scanner scanner;
    private Gradebook gradebook;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.gradebook = new Gradebook();
    }

    public void start() {
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int grade = Integer.valueOf(scanner.nextLine());
            if (grade == -1) {
                break;
            } else {
                this.gradebook.add(grade);
            }
        }
        
        System.out.println("Point average (all): " + this.gradebook.averageAll());
        if (this.gradebook.averagePassing() == -1) {
            System.out.println("Point average (passing):-");
        } else {
            System.out.println("Point average (passing): " + this.gradebook.averagePassing());
        }
        
        System.out.println("Pass percentage: " + this.gradebook.passPercentage());
        
        System.out.println("Grade distribution:");
        for (int i = 5; i >= 0; i--) {
            int count = this.gradebook.count(i);
            System.out.print(i + ": ");
            for (int s = 0; s < count; s++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

}
