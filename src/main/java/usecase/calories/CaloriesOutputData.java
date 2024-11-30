package usecase.calories;

import entity.Recipe;

import java.util.List;

public class CaloriesOutputData {
    private final List<Recipe> recipes;
    public CaloriesOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
