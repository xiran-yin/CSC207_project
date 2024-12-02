package interface_adapter.calories;

import entity.CaloriesRange;
import usecase.calories.CaloriesInputBoundary;
import usecase.calories.CaloriesInputData;
import usecase.calories.CaloriesInputDataFactory;

/**
 * The Controller for Calories Use Case.
 */
public class CaloriesController {
    private final CaloriesInputBoundary caloriesInteractor;

    public CaloriesController(CaloriesInputBoundary caloriesInteractor) {
        this.caloriesInteractor = caloriesInteractor;
    }

    /**
     * Executes the calories use case.
     * @param keyword the keyword entered for recipe search
     * @param caloriesRange the calories eneter for recipe search
     */
    public void execute(String keyword, CaloriesRange caloriesRange) {
        final CaloriesInputData caloriesInputData = CaloriesInputDataFactory
                .createCaloriesInputData(keyword, caloriesRange);

        caloriesInteractor.searchCaloriesRecipes(caloriesInputData);
    }
}

