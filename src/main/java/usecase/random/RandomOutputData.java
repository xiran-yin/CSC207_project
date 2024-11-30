package usecase.random;

import entity.Recipe;

import java.util.List;

/**
 * The Output Data of the Random Use Case.
 */
public class RandomOutputData {
    private final List<Recipe> recipes;
    public RandomOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
