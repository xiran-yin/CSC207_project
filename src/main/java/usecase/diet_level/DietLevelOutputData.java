package usecase.diet_level;

import entity.Recipe;

import java.util.List;

/**
 * The Output Data of the Diet Search Use Case.
 */
public class DietLevelOutputData {
    private final List<Recipe> recipes;
    public DietLevelOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
