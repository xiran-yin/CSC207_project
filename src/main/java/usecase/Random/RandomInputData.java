package usecase.Random;
import entity.CaloriesRange;
import entity.Cuisine;
import entity.Diet;

import java.util.Random;

public class RandomInputData {
    private final String keyword;
    private final Diet dietLevel;
    private final Cuisine cuisineType;
    private final CaloriesRange caloriesRange;
    private final String filter;

    public RandomInputData() {
        // Randomly select a keyword
        Random random = new Random();
        String[] keywords = {
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
        this.keyword = keywords[random.nextInt(keywords.length)];

        // Randomly decide whether to apply a filter and which one
        String[] filters = {"Diet", "CuisineType", "Calories", null};
        String selectedFilter = filters[random.nextInt(filters.length)];

        if ("Diet".equals(selectedFilter)) {
            Diet.DietLabels[] dietLabels = Diet.DietLabels.values();
            this.dietLevel = new Diet(new String[]{dietLabels[random.nextInt(dietLabels.length)].name()});
            this.cuisineType = null;
            this.caloriesRange = null;
            this.filter = "Diet";
        } else if ("CuisineType".equals(selectedFilter)) {
            Cuisine.CuisineType[] cuisines = Cuisine.CuisineType.values();
            this.cuisineType = new Cuisine(cuisines[random.nextInt(cuisines.length)].name());
            this.dietLevel = null;
            this.caloriesRange = null;
            this.filter = "CuisineType";
        } else if ("Calories".equals(selectedFilter)) {
            int minCalories = random.nextInt(250);
            int maxCalories = minCalories + random.nextInt(500);
            this.caloriesRange = new CaloriesRange(minCalories, maxCalories);
            this.dietLevel = null;
            this.cuisineType = null;
            this.filter = "Calories";
        } else {
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