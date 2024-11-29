package interface_adapter.calories;

import entity.CaloriesRange;
import usecase.calories.CaloriesInputBoundary;
import usecase.calories.CaloriesInputData;


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

