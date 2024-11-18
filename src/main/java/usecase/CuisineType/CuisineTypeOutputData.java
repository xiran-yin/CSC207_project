package usecase.CuisineType;

import entity.Recipe;

import java.util.List;

public class CuisineTypeOutputData {
    private final List<Recipe> recipes;
    public CuisineTypeOutputData(List<Recipe> recipes) {
        this.recipes = recipes;
    }
    public List<Recipe> getRecipes() {
        return recipes;
    }
}
