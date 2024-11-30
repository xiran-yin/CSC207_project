package usecase.calories;

import java.util.List;

import entity.Recipe;

/**
 * The Output Data of Calories Search Use Case.
 */
public class CaloriesOutputData {

    private final List<Recipe> recipes;

    public CaloriesOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    /**
     * Get the Output recipe of the Search.
     * @return the output data
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
