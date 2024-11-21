package usecase.Calories;

import api.RecipeDataBase;
import entity.Recipe;

import java.util.Collections;
import java.util.List;

public class CaloriesInteractor implements CaloriesInputBoundary {
    private final RecipeDataBase recipeDataBase;
    private final CaloriesOutputBoundary caloriesOutputBoundary;

    public CaloriesInteractor(RecipeDataBase recipeDataBase, CaloriesOutputBoundary caloriesOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.caloriesOutputBoundary = caloriesOutputBoundary;
    }

    @Override
    public void searchCaloriesRecipes(CaloriesInputData caloriesInputData) {
        try {
            List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    caloriesInputData.getKeyword(), null, null, caloriesInputData.getCaloriesRange().getMinCalories(), caloriesInputData.getCaloriesRange().getMaxCalories()
            );
            CaloriesOutputData caloriesOutputData = new CaloriesOutputData(recipes);
            caloriesOutputBoundary.presentRecipesCalories(caloriesOutputData);
        } catch (Exception e) {
            e.printStackTrace();
            caloriesOutputBoundary.presentRecipesCalories(new CaloriesOutputData(Collections.emptyList()));
        }

    }
}
