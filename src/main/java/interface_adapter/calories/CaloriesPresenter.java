package interface_adapter.calories;

import java.util.List;

import entity.Recipe;
import usecase.calories.CaloriesOutputBoundary;
import usecase.calories.CaloriesOutputData;

/**
 * The Presenter for Calories Use Case.
 */
public class CaloriesPresenter implements CaloriesOutputBoundary {
    private final CaloriesViewModel caloriesViewModel;

    public CaloriesPresenter(CaloriesViewModel caloriesViewModel) {
        this.caloriesViewModel = caloriesViewModel;
    }

    @Override
    public void presentRecipesCalories(CaloriesOutputData caloriesOutputData) {
        final List<Recipe> recipes = caloriesOutputData.getRecipes();
        caloriesViewModel.setRecipeNames(recipes);
        caloriesViewModel.setLoading(false);
    }
}
