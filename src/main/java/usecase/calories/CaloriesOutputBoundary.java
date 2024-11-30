package usecase.calories;

/**
 * The Output Boundary of Calories Search Use Case.
 */
public interface CaloriesOutputBoundary {
    /**
     * Prepare the view for final Recipe.
     * @param caloriesOutputData the output data.
     */
    void presentRecipesCalories(CaloriesOutputData caloriesOutputData);
}
