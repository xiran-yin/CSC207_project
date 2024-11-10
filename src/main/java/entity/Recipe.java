package entity;

/**
 * The representation of recipe for our application.
 */
public class Recipe {

    private final String keyword;
    private final Cuisine cuisine;
    private final Diet diet;
    private final int calories;

    public Recipe(String keyword, Cuisine cuisine, Diet diet, int calories) {
        this.Keyword = keyword;
        this.cuisine = cuisine;
        this.diet = diet;
        this.caloriesRange = calories;
    }

    public String getKeyword() {
        return keyword;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public Diet getDiet() {
        return diet;
    }

    public int getCalories() {
        return calories;
    }
}