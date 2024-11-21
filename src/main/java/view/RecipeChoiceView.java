package view;

import entity.Recipe;
import usecase.CuisineType.CuisineTypeOutputBoundary;
import usecase.Keyword.KeywordOutputBoundary;
import usecase.Keyword.KeywordOutputData;
import usecase.CuisineType.CuisineTypeOutputData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeChoiceView extends JPanel implements KeywordOutputBoundary, CuisineTypeOutputBoundary {

    private List<Recipe> keywordRecipes; // Store recipes from keyword search
    private List<Recipe> cuisineRecipes; // Store recipes from cuisine search
    private MainFrame mainFrame;         // Reference to MainFrame for navigation
    private JButton backButton;
    private String previousView;


    public RecipeChoiceView(MainFrame mainFrame) {
//        setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns, variable rows
        this.mainFrame = mainFrame;
        initializeUI();}

    private void initializeUI() {

        setLayout(new BorderLayout());

        // Back Button
        backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            if ("KeywordSearchView".equals(previousView)) {
                mainFrame.showView("KeywordSearchView");
            } else if ("CuisineSearchView".equals(previousView)) {
                mainFrame.showView("CuisineSearchView");
            }
            keywordRecipes = null;
            cuisineRecipes = null;
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.NORTH);
    }

    public void presentRecipesKeyword(KeywordOutputData keywordOutputData) {
        System.out.println("Presenting recipes in RecipeChoiceView");
        this.keywordRecipes = keywordOutputData.getRecipes();
        this.previousView = "KeywordSearchView"; // Set the previous view

        displayRecipes();
    }

    public void presentRecipesCuisine(CuisineTypeOutputData cuisineOutputData) {
        this.cuisineRecipes = cuisineOutputData.getRecipes();
        this.previousView = "CuisineSearchView"; // Set the previous view
        displayRecipes();
    }
    public void updateRecipes(List<Recipe> recipes) {
        keywordRecipes = recipes;
        displayRecipes();
    }

    public void displayRecipes() {

//        removeAll(); // Clear existing components
//        add(backButton, BorderLayout.NORTH); // Ensure the back button is always present
//        setLayout(new GridLayout(0, 3, 10, 10));
//
//        if (keywordRecipes != null && !keywordRecipes.isEmpty()) {
//            for (Recipe recipe : keywordRecipes) {
//                add(createRecipeCard(recipe), BorderLayout.CENTER);
//            }
//        } else if (cuisineRecipes != null && !cuisineRecipes.isEmpty()) {
//            JPanel recipePanel = new JPanel(new GridLayout(0, 3, 10, 10));
//            for (Recipe recipe : cuisineRecipes) {
//                add(createRecipeCard(recipe), BorderLayout.CENTER);
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "No recipes found.");
//        }
//        revalidate();
//        repaint();
//    }
        removeAll();
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(backButton, BorderLayout.NORTH);
        add(backButtonPanel, BorderLayout.NORTH);

        JPanel recipesPanel = new JPanel();
        recipesPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns, dynamic rows

        List<Recipe> allRecipes = new ArrayList<>();
        if (keywordRecipes != null) {allRecipes.addAll(keywordRecipes); }
        if (cuisineRecipes != null) {allRecipes.addAll(cuisineRecipes); }
        if (allRecipes.isEmpty()) {
            System.out.println("No recipes to display.");
            JOptionPane.showMessageDialog(this, "No recipes found.");
        } else {
            // Display recipes
            for (Recipe recipe : allRecipes) {
                System.out.println("Displaying recipe: " + recipe);
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
                recipesPanel.add(recipeCard);
            }
        }
        add(recipesPanel, BorderLayout.CENTER);

        revalidate(); // Update UI layout
        repaint(); // Redraw the panel
    }

    private JPanel createRecipeCard(Recipe recipe) {
        JPanel recipeCard = new JPanel(new BorderLayout());
        recipeCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));

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

        return recipeCard;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }


}
