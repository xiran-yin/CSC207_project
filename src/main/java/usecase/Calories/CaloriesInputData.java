package usecase.Calories;

import entity.CaloriesRange;

public class CaloriesInputData {
    private final String keyword;
    private final CaloriesRange caloriesRange;

    public CaloriesInputData(String keyword, CaloriesRange caloriesRange) {
        this.keyword = keyword;
        this.caloriesRange = caloriesRange;
    }

    public String getKeyword() {return keyword;}

    public CaloriesRange getCaloriesRange() {return caloriesRange;}
}
