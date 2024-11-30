package usecase.random;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import api.RecipeDataBase;
import entity.Recipe;

/**
 * The Random Search Interactor.
 */
public class RandomInteractor implements RandomInputBoundary {
    private RandomOutputBoundary randomPresenter;
    private final RecipeDataBase recipeDataBase;

    public RandomInteractor(RandomOutputBoundary randomOutputBoundary, RecipeDataBase recipeDataBase) {
        this.randomPresenter = randomOutputBoundary;
        this.recipeDataBase = recipeDataBase;
    }

    @Override
    public void searchRandomRecipe(RandomInputData randomInputData) {
        try {
            final List<Recipe> recipes;
            if ("Diet".equals(randomInputData.getFilter())) {
                recipes = recipeDataBase.getAllRecipes(
                    randomInputData.getKeyword(), randomInputData.getDietLevel().toString(),
                        null, 0, 0);
            }

            else if ("CuisineType".equals(randomInputData.getFilter())) {
                recipes = recipeDataBase.getAllRecipes(
                        randomInputData.getKeyword(), null,
                        randomInputData.getCuisineType().toString(), 0, 0);
            }

            else if ("Calories".equals(randomInputData.getFilter())) {
                recipes = recipeDataBase.getAllRecipes(
                        randomInputData.getKeyword(), null,
                        null, randomInputData.getCaloriesRange().getMinCalories(),
                        randomInputData.getCaloriesRange().getMaxCalories());
            }

            else {
                recipes = recipeDataBase.getAllRecipes(
                    randomInputData.getKeyword(), null,
                    null, 0, 0);}

            randomPresenter.presentRecipes(new RandomOutputData(recipes));
        }
        catch (IOException ex) {
            ex.printStackTrace();
            randomPresenter.presentRecipes(new RandomOutputData(Collections.emptyList()));
        }
    }
}
