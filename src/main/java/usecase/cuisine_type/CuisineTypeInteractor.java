package usecase.cuisine_type;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import api.RecipeDataBase;
import entity.Recipe;

/**
 * The Cuisine Search Interactor.
 */
public class CuisineTypeInteractor implements CuisineTypeInputBoundary {
    private final RecipeDataBase recipeDataBase;
    private final CuisineTypeOutputBoundary cuisineOutputBoundary;

    public CuisineTypeInteractor(RecipeDataBase recipeDataBase, CuisineTypeOutputBoundary cuisineOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.cuisineOutputBoundary = cuisineOutputBoundary;
    }

    @Override
    public void searchCuisineRecipe(CuisineTypeInputData cuisineInputData) {
        try {
            final List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    cuisineInputData.getKeyword(), null, cuisineInputData.getCuisine(), 0, 0
            );
            final CuisineTypeOutputData cuisineOutputData = new CuisineTypeOutputData(recipes);
            cuisineOutputBoundary.presentRecipesCuisine(cuisineOutputData);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            cuisineOutputBoundary.presentRecipesCuisine(new CuisineTypeOutputData(Collections.emptyList()));
        }

    }
}
