package interface_adapter.CuisineType;

import entity.Recipe;
import usecase.CuisineType.CuisineTypeOutputBoundary;
import usecase.CuisineType.CuisineTypeOutputData;
import view.RecipeChoiceView;

import java.util.List;

public class CuisineTypePresenter implements CuisineTypeOutputBoundary {
    private final RecipeChoiceView recipeChoiceView;

    public CuisineTypePresenter(RecipeChoiceView recipeChoiceView) {
        this.recipeChoiceView = recipeChoiceView;
    }

    @Override
    public void presentRecipesCuisine(CuisineTypeOutputData cuisineTypeOutputData) {
        List<Recipe> recipes = cuisineTypeOutputData.getRecipes();
        recipeChoiceView.setCuisineRecipes(recipes);
        recipeChoiceView.displayRecipes();
    }
}
