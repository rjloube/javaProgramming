
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
    private BirdDatabase database;
    
    public UserInterface(Scanner scan) {
        this.scanner = scan;
        this.database = new BirdDatabase(this.scanner);
    }
    
    public void start() {
        while (true) {
            System.out.print("? ");
            String command = this.scanner.nextLine();
            
            if (command.equals("Add")) {
                System.out.print("Name: ");
                String englishName = this.scanner.nextLine();
                System.out.print("Name in Latin: ");
                String latinName = this.scanner.nextLine();
                
               Bird newBird = new Bird(englishName, latinName, this.scanner);
               this.database.addBird(newBird);
            }
            
            if (command.equals("Observation")) {
                System.out.print("Bird? ");
                String englishName = this.scanner.nextLine();
                if (this.database.query(englishName) == null) {
                    System.out.println("Not a bird!");
                } else {
                    this.database.query(englishName).addObservation();
                }
            }
            
            if (command.equals("All")) {
                this.database.printAll();
            }
            
            if (command.equals("One")) {
                System.out.print("Bird? ");
                String englishName = this.scanner.nextLine();
                this.database.printOne(englishName);
            }
            
            if (command.equals("Quit")) {
                break;
            }
        }
    }
    
}
