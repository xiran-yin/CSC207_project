package usecase.keyword;

import entity.Recipe;

import java.util.List;

/**
 * The Output Data of the Keyword Search Use Case.
 */
public class KeywordOutputData {
    private final List<Recipe> recipes;
    public KeywordOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
