package entity;

/**
 * The representation of CaloriesRange for our application.
 */
public class CaloriesRange {
    private final int minCalories;
    private final int maxCalories;

    public CaloriesRange(int minCalories, int maxCalories) {
        this.minCalories = minCalories;
        this.maxCalories = maxCalories;
    }

    /**
     * Get the minimum calories.
     * @return get the minimum calories
     */
    public int getMinCalories() {
        return minCalories;
    }

    /**
     * Get the maximmum calories.
     * @return get the maximum calories.
     */
    public int getMaxCalories() {
        return maxCalories;
    }

    /**
     * Check whether the calories is in the range.
     * @param calories the input calories
     * @return true of calories is in the range, false if is not.
     */
    public boolean isWithinRange(int calories) {
        return minCalories <= calories && calories <= maxCalories;
    }
}
