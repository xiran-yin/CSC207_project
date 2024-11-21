package usecase.DietLevel;

import entity.Recipe;

import java.util.List;

public class DietLevelOutputData {
    private final List<Recipe> recipes;
    public DietLevelOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
