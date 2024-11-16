package usecase.Keyword;

import entity.Recipe;

import java.util.List;

public class KeywordOutputData {
    private final List<Recipe> recipes;
    public KeywordOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
