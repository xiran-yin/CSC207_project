package usecase.calories;

import entity.CaloriesRange;

public class CaloriesInputDataFactory {
    /**
     * Create an instance of CaloriesInputData with the given parameters.
     * @param keyword the search keyword
     * @param caloriesRange the range of calories
     * @return a new instance of CaloriesInputData
     */
    public static CaloriesInputData createCaloriesInputData(String keyword, CaloriesRange caloriesRange) {
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword cannot be null or empty");
        }
        if (caloriesRange == null) {
            throw new IllegalArgumentException("CaloriesRange cannot be null");
        }

        return new CaloriesInputData(keyword, caloriesRange);
    }
}
