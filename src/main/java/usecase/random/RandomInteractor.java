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
    private final RecipeDataBase recipeDataBase;
    private final RandomOutputBoundary randomOutputBoundary;

    public RandomInteractor(RecipeDataBase recipeDataBase, RandomOutputBoundary randomOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.randomOutputBoundary = randomOutputBoundary;
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
                    null, 0, 0);
            }

            final RandomOutputData randomOutputData = new RandomOutputData(recipes);
            randomOutputBoundary.presentRecipes(randomOutputData);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            randomOutputBoundary.presentRecipes(new RandomOutputData(Collections.emptyList()));
        }
    }
}
