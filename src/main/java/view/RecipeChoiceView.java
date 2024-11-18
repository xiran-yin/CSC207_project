package view;

import entity.Recipe;
import usecase.CuisineType.CuisineTypeOutputBoundary;
import usecase.DietLevel.DietLevelInputBoundary;
import usecase.DietLevel.DietLevelInputData;
import usecase.DietLevel.DietLevelOutputBoundary;
import usecase.DietLevel.DietLevelOutputData;
import usecase.Keyword.KeywordOutputBoundary;
import usecase.Keyword.KeywordOutputData;
import usecase.CuisineType.CuisineTypeOutputData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeChoiceView extends JPanel implements KeywordOutputBoundary, CuisineTypeOutputBoundary, DietLevelOutputBoundary {

    private List<Recipe> keywordRecipes; // Store recipes from keyword search
    private List<Recipe> cuisineRecipes; // Store recipes from cuisine search
    private List<Recipe> dietRecipes; // Store recipes from diet search

    public RecipeChoiceView() {
        setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns, variable rows
    }

    public void presentRecipesKeyword(KeywordOutputData keywordOutputData) {
        this.keywordRecipes = keywordOutputData.getRecipes();
        displayRecipes();
    }

    public void presentRecipesCuisine(CuisineTypeOutputData cuisineOutputData) {
        this.cuisineRecipes = cuisineOutputData.getRecipes();
        displayRecipes();
    }

    public void presentRecipesDiet(DietLevelOutputData dietOutputData) {
        this.dietRecipes = dietOutputData.getRecipes();
        displayRecipes();
    }

    public void displayRecipes() {
        removeAll(); // Clear previous recipes

        List<Recipe> allRecipes = new ArrayList<>();

        if (keywordRecipes != null) {
            allRecipes.addAll(keywordRecipes); // Add keyword search results
        }

        if (cuisineRecipes != null) {
            allRecipes.addAll(cuisineRecipes); // Add cuisine search results
        }

        if (dietRecipes != null) {
            allRecipes.addAll(dietRecipes);
        }

        if (allRecipes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No recipes found.");
        } else {
            // Display recipes
            for (Recipe recipe : allRecipes) {
                JPanel recipeCard = new JPanel();
                recipeCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                recipeCard.setLayout(new BorderLayout());

                // Recipe Label
                JLabel recipeLabel = new JLabel(recipe.getLabel(), SwingConstants.CENTER);
                recipeCard.add(recipeLabel, BorderLayout.CENTER);

                // Ingredient Button
                JButton ingredientButton = new JButton("Ingredient");
                ingredientButton.addActionListener(e -> {
                    String[] ingredients = recipe.getIngredients();
                    String ingredientList = String.join("\n", ingredients);
                    JOptionPane.showMessageDialog(
                            this,
                            ingredientList.isEmpty() ? "No ingredients available" : ingredientList,
                            "Ingredients for " + recipe.getLabel(),
                            JOptionPane.INFORMATION_MESSAGE
                    );
                });
                recipeCard.add(ingredientButton, BorderLayout.SOUTH);

                add(recipeCard);
            }
        }

        revalidate(); // Update UI layout
        repaint(); // Redraw the panel
    }
}
