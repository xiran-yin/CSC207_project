package usecase.diet_level;

import java.util.List;

import entity.Recipe;

/**
 * The Output Data of the Diet Search Use Case.
 */
public class DietLevelOutputData {
    private final List<Recipe> recipes;

    public DietLevelOutputData(List<Recipe> recipes) {
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
