package usecase.cuisine_type;

import java.util.List;

import entity.Recipe;

/**
 * The Output Data of the Cuisine Search Use Case.
 */
public class CuisineTypeOutputData {
    private final List<Recipe> recipes;

    public CuisineTypeOutputData(List<Recipe> recipes) {
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
