
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
public class RecipeBook {

    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }

    public void add(Recipe recipe) {
        this.recipes.add(recipe);
    }
    
    public void printRecipes() {
        for (Recipe recipe : this.recipes) {
            System.out.println(recipe);
        }
    }
    
    public void findName(String word) {
        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(word)) {
                System.out.println(recipe);
            }
        }
    }
    
    public void findCookingTime(int maxCookingTime) {
        for (Recipe recipe : this.recipes) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                System.out.println(recipe);
            }
        }
    }
    
    public void findIngredient(String ingredient) {
        for (Recipe recipe: this.recipes) {
            System.out.println(recipe.getIngredients().contains(ingredient));
            if(recipe.getIngredients().contains(ingredient)) {
                System.out.println(recipe);
            }
        }
    }

}
