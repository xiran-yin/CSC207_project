package entity;

/**
 * The representation of recipe for our application.
 */
public class Recipe {
    private final String label;
    private final double calories;
    private final Cuisine cuisine;
    private final Diet diet;
    private final String[] ingredients;

    public Recipe(String label, double calories, Cuisine cuisine, Diet diet, String[] ingredients) {
        this.label = label;
        this.calories = calories;
        this.cuisine = cuisine;
        this.diet = diet;
        this.ingredients = ingredients;
    }

    public String getLabel() {
        return label;
    }

    public double getCalories() {
        return calories;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public Diet getDiet() {
        return diet;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        String ingredientsString = String.join(", ", ingredients);
        String dietLabelsString = String.join(", ", diet.getDietLabels());

        return String.format(
                "[Recipe: %s, Calories: %.2f, Cuisine: %s, Diet: [%s], Ingredients: [%s]]",
                label,
                calories,
                cuisine,
                dietLabelsString,
                ingredientsString
        );
    }
}