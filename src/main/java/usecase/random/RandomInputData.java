package usecase.random;

import java.util.Random;

import entity.CaloriesRange;
import entity.Cuisine;
import entity.Diet;

/**
 * The Input Data of the Diet Search Use Case.
 */
public class RandomInputData {
    private final String keyword;
    private final Diet dietLevel;
    private final Cuisine cuisineType;
    private final CaloriesRange caloriesRange;
    private final String filter;

    public RandomInputData() {
        final Random random = new Random();
        final String[] keywords = {
            "Apple", "Banana", "Orange", "Strawberry", "Blueberry", "Grapes", "Watermelon",
            "Pineapple", "Mango", "Peach", "Carrot", "Broccoli", "Spinach", "Potato", "Tomato", "Onion",
            "Garlic", "Cucumber", "Pepper", "Mushroom", "Rice", "Wheat", "Quinoa", "Oats", "Barley",
            "Lentils", "Chickpeas", "Black Beans", "Soybeans", "Pasta", "Milk", "Cheese",
            "Yogurt", "Cream", "Eggs", "Chicken", "Beef", "Pork", "Lamb", "Turkey", "Salmon", "Tuna",
            "Shrimp", "Crab", "Scallops", "Salt", "Pepper", "Cinnamon", "Turmeric", "Basil", "Thyme",
            "Rosemary", "Parsley", "Chili Powder", "Cumin", "Olive Oil", "Vegetable Oil", "Coconut Oil",
            "Butter", "Ghee", "Lard", "Almonds", "Peanuts", "Cashews", "Walnuts", "Chia Seeds", "Flaxseeds",
            "Sunflower Seeds", "Sesame Seeds", "Sugar", "Honey", "Maple Syrup", "Brown Sugar", "Molasses",
            "Water", "Tea", "Coffee", "Juice", "Milkshake", "Soda", "Soy Sauce", "Vinegar", "Mustard",
            "Mayonnaise", "Ketchup", "Chocolate", "Bread", "Tofu", "Pickles"
        };

        final String[] dietLabels = {"low-carb", "low-fat", "balanced", "high-fiber", "low-sodium", "high-protein"};
        final String[] randomDiet = {dietLabels[random.nextInt(dietLabels.length)]};
        this.keyword = keywords[random.nextInt(keywords.length)];

        // Randomly decide whether to apply a filter and which one
        final String[] filters = {"Diet", "CuisineType", "Calories", null};
        final String selectedFilter = filters[random.nextInt(filters.length)];

        if ("Diet".equals(selectedFilter)) {
            this.dietLevel = new Diet(randomDiet);
            this.cuisineType = null;
            this.caloriesRange = null;
            this.filter = "Diet";
        }
        else if ("CuisineType".equals(selectedFilter)) {
            final Cuisine.CuisineType[] cuisines = Cuisine.CuisineType.values();
            this.cuisineType = new Cuisine(cuisines[random.nextInt(cuisines.length)].name());
            this.dietLevel = null;
            this.caloriesRange = null;
            this.filter = "CuisineType";
        }
        else if ("Calories".equals(selectedFilter)) {
            final int minCalories = random.nextInt(250);
            final int maxCalories = minCalories + random.nextInt(500);
            this.caloriesRange = new CaloriesRange(minCalories, maxCalories);
            this.dietLevel = null;
            this.cuisineType = null;
            this.filter = "Calories";
        }
        else {
            this.dietLevel = null;
            this.cuisineType = null;
            this.caloriesRange = null;
            this.filter = null;
        }
    }

    public String getKeyword() {
        return keyword;
    }

    public Diet getDietLevel() {
        return dietLevel;
    }

    public Cuisine getCuisineType() {
        return cuisineType;
    }

    public CaloriesRange getCaloriesRange() {
        return caloriesRange;
    }

    public String getFilter() {
        return filter;
    }
}
