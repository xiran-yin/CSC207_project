package interface_adapter.calories;

import interface_adapter.ViewManagerModel;
import usecase.calories.CaloriesOutputBoundary;
import usecase.calories.CaloriesOutputData;

/**
 * The Presenter for Calories Use Case.
 */
public class CaloriesPresenter implements CaloriesOutputBoundary {
    private final CaloriesViewModel caloriesViewModel;
    private final ViewManagerModel viewManagerModel;

    public CaloriesPresenter(CaloriesViewModel caloriesViewModel, ViewManagerModel viewManagerModel) {
        this.caloriesViewModel = caloriesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentRecipesCalories(CaloriesOutputData caloriesOutputData) {
        viewManagerModel.firePropertyChanged();
    }
}
