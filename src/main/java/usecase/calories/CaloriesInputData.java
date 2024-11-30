package usecase.calories;

import entity.CaloriesRange;

/**
 * The Input Data of Calories Search Use Case.
 */
public class CaloriesInputData {
    private final String keyword;
    private final CaloriesRange caloriesRange;

    public CaloriesInputData(String keyword, CaloriesRange caloriesRange) {
        this.keyword = keyword;
        this.caloriesRange = caloriesRange;
    }

    /**
     * Get the keyword of the Input Data.
     * @return the keyword of the search
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * Get the calories range of the input data.
     * @return the calories range of the search
     */
    public CaloriesRange getCaloriesRange() {
        return caloriesRange;
    }
}
