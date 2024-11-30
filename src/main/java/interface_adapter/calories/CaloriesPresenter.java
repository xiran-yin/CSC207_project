package interface_adapter.calories;

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
    }
}
