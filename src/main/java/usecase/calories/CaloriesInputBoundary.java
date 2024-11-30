package usecase.calories;

/**
 * The Input Boundary of the Calories Search Use Case.
 */
public interface CaloriesInputBoundary {
    /**
     * Excute the Calories Use Case.
     * @param caloriesInputData the input data
     */
    void searchCaloriesRecipes(CaloriesInputData caloriesInputData);
}
