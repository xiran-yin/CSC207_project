package interface_adapter.Calories;

import entity.CaloriesRange;
import usecase.Calories.CaloriesInputBoundary;
import usecase.Calories.CaloriesInputData;


public class CaloriesController {
    private final CaloriesInputBoundary caloriesInteractor;

    public CaloriesController(CaloriesInputBoundary caloriesInteractor) {
        this.caloriesInteractor = caloriesInteractor;
    }

    /**
     * Executes the calories use case.
     */
    public void execute(String keyword, CaloriesRange caloriesRange) {
        final CaloriesInputData caloriesInputData = new CaloriesInputData(keyword, caloriesRange);

        caloriesInteractor.searchCaloriesRecipes(caloriesInputData);
    }
}

