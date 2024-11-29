package usecase.random;

import entity.Recipe;

import java.util.List;

public class RandomOutputData {
    private final List<Recipe> recipes;
    public RandomOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
