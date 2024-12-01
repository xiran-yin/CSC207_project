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

    /**
     * Get calories.
     * @return int calories.
     */
    public int getCalories() {
        final int newcalories = (int) Math.round(calories);
        return newcalories;
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
        // Safely handle null for ingredients
        final String ingredientsString;
        if (ingredients != null) {
            ingredientsString = String.join(", ", ingredients);
        }
        else {
            ingredientsString = "No ingredients";
        }

        // Safely handle null for dietLabels
        final String dietLabelsString;
        if (diet != null && diet.getDietLabels() != null) {
            dietLabelsString = String.join(", ", diet.getDietLabels());
        }
        else {
            dietLabelsString = "No diet labels";
        }

        // Handle null for cuisine
        final String cuisineString;
        if (cuisine != null) {
            cuisineString = cuisine.toString();
        }
        else {
            cuisineString = "Unknown cuisine";
        }

        return String.format(
                "[Recipe: %s, Calories: %.2f, Cuisine: %s, Diet: [%s], Ingredients: [%s]]",
                label,
                calories,
                cuisineString,
                dietLabelsString,
                ingredientsString
        );
    }
}
