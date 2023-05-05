
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
public class Bird {

    private String englishName;
    private String latinName;
    private Scanner scanner;

    private int observations;

    public Bird(String englishName, String latinName, Scanner scan) {
        this.englishName = englishName;
        this.latinName = latinName;
        this.observations = 0;
        this.scanner = scan;
    }

    public void addObservation() {
        this.observations++;
    }

    public String getEnglishName() {
        return englishName;
    }
    
    public int getObservations() {
        return this.observations;
    }

    @Override
    public String toString() {
        return this.englishName + " (" + this.latinName + "): " + this.observations + " observations";
    }

}
