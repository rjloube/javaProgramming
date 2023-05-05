
import java.util.ArrayList;
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
public class BirdDatabase {

    private ArrayList<Bird> birds;
    private Scanner scanner;

    public BirdDatabase(Scanner scan) {
        this.birds = new ArrayList<>();
        this.scanner = scan;
    }

    public void addBird(Bird bird) {
        this.birds.add(bird);
    }

    public Bird query(String englishName) {
        for (Bird bird : this.birds) {
            if (bird.getEnglishName().equals(englishName)) {
                return bird;
            }
        }

        return null;
    }

    public void printAll() {
        for (Bird bird : this.birds) {
            System.out.println(bird);
        }
    }

    public void printOne(String englishName) {
        System.out.println(this.query(englishName));
    }

}
