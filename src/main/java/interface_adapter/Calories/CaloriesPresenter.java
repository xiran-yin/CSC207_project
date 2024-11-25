package interface_adapter.Calories;

import entity.CaloriesRange;
import entity.Recipe;
import interface_adapter.Random.RandomViewModel;
import usecase.Calories.CaloriesOutputBoundary;
import usecase.Calories.CaloriesOutputData;
import usecase.Random.RandomOutputData;

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
