package view;

import entity.Recipe;
import usecase.Keyword.KeywordOutputBoundary;
import usecase.Keyword.KeywordOutputData;

import javax.swing.*;
import java.awt.*;

public class RecipeChoiceView extends JPanel implements KeywordOutputBoundary {
    public RecipeChoiceView() {
        setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns, variable rows
    }

    @Override
    public void presentRecipes(KeywordOutputData keywordOutputData) {
        removeAll(); // Clear previous recipes

        // Display each recipe in a card format
        for (Recipe recipe : keywordOutputData.getRecipes()) {
            JPanel recipeCard = new JPanel();
            recipeCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            recipeCard.setLayout(new BorderLayout());

            // Recipe Label
            JLabel recipeLabel = new JLabel(recipe.getLabel(), SwingConstants.CENTER);
            recipeCard.add(recipeLabel, BorderLayout.CENTER);

            // Link Button -- want to do a prettier one later hehehe
            JButton ingredientButton = new JButton("Ingredient");
            ingredientButton.addActionListener(e -> {
                // Show ingredients in a dialog box
                String[] ingredients = recipe.getIngredients();
                String ingredientList = String.join("\n", ingredients);
                JOptionPane.showMessageDialog(
                        this, // Parent component
                        ingredientList.isEmpty() ? "No ingredients available" : ingredientList,
                        "Ingredients for " + recipe.getLabel(),
                        JOptionPane.INFORMATION_MESSAGE
                );
            });
            recipeCard.add(ingredientButton, BorderLayout.SOUTH);

            add(recipeCard);
        }

        revalidate(); // Update UI layout
        repaint(); // Redraw the panel
    }



}
