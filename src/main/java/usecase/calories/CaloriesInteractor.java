package usecase.calories;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import api.RecipeDataBase;
import entity.Recipe;

/**
 * The Calories Search Interactor.
 */
public class CaloriesInteractor implements CaloriesInputBoundary {
    private final RecipeDataBase recipeDataBase;
    private final CaloriesOutputBoundary caloriesPresenter;

    public CaloriesInteractor(RecipeDataBase recipeDataBase, CaloriesOutputBoundary caloriesOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.caloriesPresenter = caloriesOutputBoundary;
    }

    @Override
    public void searchCaloriesRecipes(CaloriesInputData caloriesInputData) {
        try {
            final List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    caloriesInputData.getKeyword(),
                    null, null,
                    caloriesInputData.getCaloriesRange().getMinCalories(),
                    caloriesInputData.getCaloriesRange().getMaxCalories()
            );
            caloriesPresenter.presentRecipesCalories(new CaloriesOutputData(recipes));
        }
        catch (IOException ex) {
            ex.printStackTrace();
            caloriesPresenter.presentRecipesCalories(new CaloriesOutputData(Collections.emptyList()));
        }

    }
}
