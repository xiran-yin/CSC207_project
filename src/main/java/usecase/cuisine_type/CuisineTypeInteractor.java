package usecase.cuisine_type;

import api.RecipeDataBase;
import entity.Recipe;

import java.util.Collections;
import java.util.List;

public class CuisineTypeInteractor implements CuisineTypeInputBoundary{
    private final RecipeDataBase recipeDataBase;
    private final CuisineTypeOutputBoundary cuisineOutputBoundary;

    public CuisineTypeInteractor(RecipeDataBase recipeDataBase, CuisineTypeOutputBoundary cuisineOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.cuisineOutputBoundary = cuisineOutputBoundary;
    }

    @Override
    public void searchCuisineRecipe(CuisineTypeInputData cuisineInputData) {
        try {
            List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    cuisineInputData.getKeyword(), null, cuisineInputData.getCuisine(), 0, 0
            );
            CuisineTypeOutputData cuisineOutputData = new CuisineTypeOutputData(recipes);
            cuisineOutputBoundary.presentRecipesCuisine(cuisineOutputData);
        } catch (Exception e) {
            e.printStackTrace();
            cuisineOutputBoundary.presentRecipesCuisine(new CuisineTypeOutputData(Collections.emptyList()));
        }

    }
}
