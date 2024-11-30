package usecase.cuisine_type;

import api.RecipeDataBase;
import entity.Recipe;

import java.util.Collections;
import java.util.List;

public class CuisineTypeInteractor implements CuisineTypeInputBoundary{
    private final RecipeDataBase recipeDataBase;
    private final CuisineTypeOutputBoundary cuisinePresenter;

    public CuisineTypeInteractor(RecipeDataBase recipeDataBase, CuisineTypeOutputBoundary cuisineOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.cuisinePresenter = cuisineOutputBoundary;
    }

    @Override
    public void searchCuisineRecipe(CuisineTypeInputData cuisineInputData) {
        try {
            List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    cuisineInputData.getKeyword(), null, cuisineInputData.getCuisine(), 0, 0
            );
            cuisinePresenter.presentRecipesCuisine(new CuisineTypeOutputData(recipes));
        } catch (Exception e) {
            e.printStackTrace();
            cuisinePresenter.presentRecipesCuisine(new CuisineTypeOutputData(Collections.emptyList()));
        }

    }
}
