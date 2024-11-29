package interface_adapter.calories;

import entity.Recipe;
import usecase.calories.CaloriesOutputBoundary;
import usecase.calories.CaloriesOutputData;

import java.util.List;

public class CaloriesPresenter implements CaloriesOutputBoundary {
    private final CaloriesViewModel caloriesViewModel;

    public CaloriesPresenter(CaloriesViewModel caloriesViewModel) {
        this.caloriesViewModel = caloriesViewModel;
    }

    @Override
    public void presentRecipesCalories(CaloriesOutputData caloriesOutputData) {
        List<Recipe> recipes = caloriesOutputData.getRecipes();
        caloriesViewModel.setRecipeNames(recipes);
        caloriesViewModel.setLoading(false);
    }
}
