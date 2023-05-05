
import java.nio.file.Paths;
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
public class UserInterface {

    private Scanner scanner;
    private ArrayList<String> lines;
    private RecipeBook recipeBook;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.lines = new ArrayList<>();
        this.recipeBook = new RecipeBook();
    }

    public void start() {
        System.out.print("File to read: ");
        String file = this.scanner.nextLine();

        try ( Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                this.lines.add(line);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        ArrayList<String> recipeVariables = new ArrayList<>();

        for (int i = 0; i < this.lines.size(); i++) {
            if (!(this.lines.get(i).isEmpty())) {
                recipeVariables.add(this.lines.get(i));
            }
            
            if (this.lines.get(i).isEmpty() || i == (this.lines.size() - 1)) {
                String name = recipeVariables.get(0);
                String cookingTime = recipeVariables.get(1);

                Recipe recipe = new Recipe(name, Integer.valueOf(cookingTime), recipeVariables);
                this.recipeBook.add(recipe);
                                
                for (int j = 2; j < recipeVariables.size(); j++) {
                    recipe.addIngredient(recipeVariables.get(j));
                }
                
                recipeVariables.clear();
            }
        }
        
        System.out.println("\nCommands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.print("\nEnter command: ");
            String command = scanner.nextLine();

            if (command.equals("list")) {
                this.recipeBook.printRecipes();
            }
            
            if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String word = scanner.nextLine();
                this.recipeBook.findName(word);
            }
            
            if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int maxCookingTime = Integer.valueOf(scanner.nextLine());
                System.out.println("\nRecipes:");
                this.recipeBook.findCookingTime(maxCookingTime);
            }
            
            if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String ingredient = scanner.nextLine();
                System.out.println("\nRecipes:");
                this.recipeBook.findIngredient(ingredient);
            }

            if (command.equals("stop")) {
                break;
            }
        }

    }

}
