package view;

import app.MainFrame;
import entity.Recipe;
import usecase.calories.CaloriesOutputBoundary;
import usecase.calories.CaloriesOutputData;
import usecase.cuisine_type.CuisineTypeOutputBoundary;
import usecase.diet_level.DietLevelOutputBoundary;
import usecase.diet_level.DietLevelOutputData;
import usecase.keyword.KeywordOutputBoundary;
import usecase.keyword.KeywordOutputData;
import usecase.cuisine_type.CuisineTypeOutputData;
import usecase.random.RandomOutputBoundary;
import usecase.random.RandomOutputData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeChoiceView extends JPanel implements KeywordOutputBoundary, CuisineTypeOutputBoundary, DietLevelOutputBoundary, CaloriesOutputBoundary, RandomOutputBoundary {
    private List<Recipe> keywordRecipes; // Store recipes from keyword search
    private List<Recipe> cuisineRecipes; // Store recipes from cuisine search
    private List<Recipe> dietRecipes;
    private List<Recipe> caloriesRecipes;
    private List<Recipe> randomRecipes;
    private MainFrame mainFrame;         // Reference to MainFrame for navigation
    private JButton backButton;
    private String previousView;

    public RecipeChoiceView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();}


    private void initializeUI() {

        setLayout(new BorderLayout());
        setBackground(new Color(249, 249, 232));

        // Back Button
        backButton = new JButton("Back");
        backButton.setOpaque(true);
        backButton.setBackground(new Color(185,224,84));
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        backButton.addActionListener(e -> {
            if ("KeywordSearchView".equals(previousView)) {
                mainFrame.showView("KeywordSearchView");
            } else if ("CuisineSearchView".equals(previousView)) {
                mainFrame.showView("CuisineSearchView");
            } else if ("DietSearchView".equals(previousView)) {
                mainFrame.showView("DietSearchView");
            }else if ("CalorieSearchView".equals(previousView)) {
                mainFrame.showView("CalorieSearchView");
            }else if ("RandomSearchView".equals(previousView)) {
                mainFrame.showView("RandomSearchView");
            }
            keywordRecipes = null;
            cuisineRecipes = null;
            dietRecipes = null;
            caloriesRecipes = null;
            randomRecipes = null;
        });
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(backButton);
        buttonPanel.setBackground(new Color(249, 249, 232));
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

    public void presentRecipesDiet(DietLevelOutputData dietLevelOutputData) {
        this.dietRecipes = dietLevelOutputData.getRecipes();
        this.previousView = "DietSearchView"; // Set the previous view
        displayRecipes();
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

    public void setDietRecipes(List<Recipe> recipes) {
        this.dietRecipes = recipes;
        this.previousView = "DietSearchView";
        System.out.println("Diet recipes set in RecipeChoiceView: " + dietRecipes);
    }

    public void presentRecipes(RandomOutputData randomOutputData) {
        this.randomRecipes = randomOutputData.getRecipes();
        this.previousView = "RandomSearchView";
        displayRecipes();
    }

    public void presentRecipesCalories(CaloriesOutputData caloriesOutputData){
        this.caloriesRecipes = caloriesOutputData.getRecipes();
        this.previousView = "CalorieSearchView";
        displayRecipes();
    }

    public void displayRecipes() {
        removeAll();
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(backButton, BorderLayout.NORTH);
        backButtonPanel.setBackground(new Color(249, 249, 232));
        add(backButtonPanel, BorderLayout.NORTH);

        JPanel recipesPanel = new JPanel();
        recipesPanel.setBackground(new Color(249, 249, 232));
        recipesPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns, dynamic rows

        List<Recipe> allRecipes = new ArrayList<>();
        if (keywordRecipes != null) {allRecipes.addAll(keywordRecipes); }
        if (cuisineRecipes != null) {allRecipes.addAll(cuisineRecipes); }
        if (dietRecipes != null) {allRecipes.addAll(dietRecipes); }
        if (caloriesRecipes != null) {allRecipes.addAll(caloriesRecipes); }
        if (randomRecipes != null) {allRecipes.addAll(randomRecipes); }
        if (allRecipes.isEmpty()) {
            System.out.println("No recipes to display.");
            JOptionPane.showMessageDialog(this, "No recipes found.");
        } else {
            // Display recipes
            for (Recipe recipe : allRecipes) {
                System.out.println("Displaying recipe: " + recipe);
                JPanel recipeCard = new JPanel();

                recipeCard.setBackground(new Color(249, 249, 232));
                recipeCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                recipeCard.setLayout(new BorderLayout());
                // Recipe Label
                JLabel recipeLabel = new JLabel(recipe.getLabel(), SwingConstants.CENTER);
                recipeCard.add(recipeLabel, BorderLayout.CENTER);

                recipeLabel.setBackground(new Color(185,224,84));

                JButton ingredientButton = new JButton("Ingredient");
                ingredientButton.setBackground(new Color(185,224,84));
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

    public void setMainFrame(MainFrame mainFrame){
            this.mainFrame = mainFrame;
        }
    }