package view;

import entity.Recipe;
import usecase.CuisineType.CuisineTypeOutputBoundary;
import usecase.DietLevel.DietLevelOutputBoundary;
import usecase.DietLevel.DietLevelOutputData;
import usecase.CuisineType.CuisineTypeOutputData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeChoiceView extends JPanel implements CuisineTypeOutputBoundary, DietLevelOutputBoundary {

    private List<Recipe> keywordRecipes; // Store recipes from keyword search
    private List<Recipe> cuisineRecipes; // Store recipes from cuisine search
    private List<Recipe> dietRecipes;
    private MainFrame mainFrame;         // Reference to MainFrame for navigation
    private JButton backButton;
    private String previousView;


    public RecipeChoiceView(MainFrame mainFrame) {
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
            } else if ("DietSearchView".equals(previousView)) {
                mainFrame.showView("DietSearchView");
            }
            keywordRecipes = null;
            cuisineRecipes = null;
            dietRecipes = null;
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.NORTH);
    }

    public void presentRecipesCuisine(CuisineTypeOutputData cuisineOutputData) {
        this.cuisineRecipes = cuisineOutputData.getRecipes();
        this.previousView = "CuisineSearchView"; // Set the previous view
        displayRecipes();
    }

    public void presentRecipesDiet(DietLevelOutputData dietLevelOutputData) {
        this.dietRecipes = dietLevelOutputData.getRecipes();
        this.previousView = "DietSearchView"; // Set the previous view
        displayRecipes();
    }

    public void setDietRecipes(List<Recipe> dietRecipes) {
        this.dietRecipes = dietRecipes;
        this.previousView = "DietSearchView";
    }
    public void setKeywordRecipes(List<Recipe> recipes) {
        this.keywordRecipes = recipes;
        this.previousView = "KeywordSearchView";
        System.out.println("Keyword recipes set in RecipeChoiceView: " + keywordRecipes);// Store recipes in the class for rendering
    }

    public void setCuisineRecipes(List<Recipe> recipes) {
        this.cuisineRecipes = recipes;
        this.previousView = "CuisineSearchView";
        System.out.println("Cuisine recipes set in recipeChoiceView: " + cuisineRecipes);
    }

    public void displayRecipes() {

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
        if (dietRecipes != null) {allRecipes.addAll(dietRecipes); }
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


                JButton ingredientButton = new JButton("Ingredient");
                ingredientButton.addActionListener(e -> {
                    String[] ingredients = recipe.getIngredients();
                    String ingredientList = String.join("\n", ingredients);
                    String dietInfo = recipe.getDiet() != null ? "Diet: " + recipe.getDiet().toString() : "Diet: Not available";
                    String cuisineInfo = recipe.getCuisine() != null ? "Cuisine: " + recipe.getCuisine().toString() : "Cuisine: Not available";

                    String message = cuisineInfo + "\n\n" + dietInfo + "\n\n" + ingredientList;


                    JOptionPane.showMessageDialog(
                            this,
                            ingredientList.isEmpty() ? "No ingredients available" : message,
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

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

}
