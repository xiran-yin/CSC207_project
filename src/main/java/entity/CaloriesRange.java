package entity;

public class CaloriesRange {
    private final int minCalories;
    private final int maxCalories;

    public CaloriesRange(int minCalories, int maxCalories) {
        this.minCalories = minCalories;
        this.maxCalories = maxCalories;
    }

    public int getMinCalories() {
        return minCalories;
    }

    public int getMaxCalories() {
        return maxCalories;
    }

    public boolean isWithinRange(int calories) {return minCalories <= calories && calories <= maxCalories;
    }
}