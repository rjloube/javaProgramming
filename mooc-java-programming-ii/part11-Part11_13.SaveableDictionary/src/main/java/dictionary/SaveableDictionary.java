/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.file.Paths;

/**
 *
 * @author rjloube
 */
public class SaveableDictionary {

    private HashMap<String, String> terms;
    private String file;

    public SaveableDictionary() {
        this.terms = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }

    public boolean load() {
        try ( Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }

            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void add(String words, String translation) {
        this.terms.putIfAbsent(words, translation);
    }

    public String translate(String word) {
        if (this.terms.containsKey(word)) {
            return this.terms.get(word);
        } else {
            for (String key : this.terms.keySet()) {
                if (word.equals(this.terms.get(key))) {
                    return key;
                }
            }
        }

        return null;
    }

    public void delete(String word) {

        String toDelete = "";

        if (this.terms.containsKey(word)) {
            this.terms.remove(word);
        } else {
            for (String key : this.terms.keySet()) {
                if (word.equals(this.terms.get(key))) {
                    toDelete = key;
                }
            }

            this.terms.remove(toDelete);

        }
    }
    
    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.file);
            
            for (String key : this.terms.keySet()) {
                writer.print(key + ":");
                writer.println(this.terms.get(key));
            }
            
            writer.close();
            return true;
            
        } catch (FileNotFoundException ex) {
            return false;
        }
    }

}
