package usecase.keyword;

import java.util.List;

import entity.Recipe;

/**
 * The Output Data of the Keyword Search Use Case.
 */
public class KeywordOutputData {
    private final List<Recipe> recipes;

    public KeywordOutputData(List<Recipe> recipes) {
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
