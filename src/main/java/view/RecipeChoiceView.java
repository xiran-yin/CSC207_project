package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import app.MainFrame;
import entity.Recipe;
import usecase.calories.CaloriesOutputBoundary;
import usecase.calories.CaloriesOutputData;
import usecase.cuisine_type.CuisineTypeOutputBoundary;
import usecase.cuisine_type.CuisineTypeOutputData;
import usecase.diet_level.DietLevelOutputBoundary;
import usecase.diet_level.DietLevelOutputData;
import usecase.keyword.KeywordOutputBoundary;
import usecase.keyword.KeywordOutputData;
import usecase.random.RandomOutputBoundary;
import usecase.random.RandomOutputData;

/**
 * The View for when the user is search out the recipe in the program.
 */
public class RecipeChoiceView extends JPanel implements KeywordOutputBoundary,
        CuisineTypeOutputBoundary, DietLevelOutputBoundary,
        CaloriesOutputBoundary, RandomOutputBoundary {
    public static final String KEYWORD_SEARCH_VIEW = "KeywordSearchView";
    public static final String CUISINE_SEARCH_VIEW = "CuisineSearchView";
    public static final String DIET_SEARCH_VIEW = "DietSearchView";
    public static final String CALORIE_SEARCH_VIEW = "CalorieSearchView";
    public static final String RANDOM_SEARCH_VIEW = "RandomSearchView";
    public static final String STR = "\n\n";
    private List<Recipe> keywordRecipes;
    private List<Recipe> cuisineRecipes;
    private List<Recipe> dietRecipes;
    private List<Recipe> caloriesRecipes;
    private List<Recipe> randomRecipes;
    private MainFrame mainFrame;
    private JButton backButton;
    private String previousView;

    public RecipeChoiceView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        initializeUi();
    }

    private void navigateToPreviousView(String pView) {
        switch (pView) {
            case KEYWORD_SEARCH_VIEW:
                mainFrame.showView(KEYWORD_SEARCH_VIEW);
                break;
            case CUISINE_SEARCH_VIEW:
                mainFrame.showView(CUISINE_SEARCH_VIEW);
                break;
            case DIET_SEARCH_VIEW:
                mainFrame.showView(DIET_SEARCH_VIEW);
                break;
            case CALORIE_SEARCH_VIEW:
                mainFrame.showView(CALORIE_SEARCH_VIEW);
                break;
            case RANDOM_SEARCH_VIEW:
                mainFrame.showView(RANDOM_SEARCH_VIEW);
                break;
            default:
                throw new IllegalArgumentException("Unknown view: " + pView);
        }
    }

    private void initializeUi() {

        setLayout(new BorderLayout());
        setBackground(new Color(249, 249, 232));

        // Back Button
        backButton = new JButton("Back");
        backButton.setOpaque(true);
        backButton.setBackground(new Color(185, 224, 84));
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        backButton.addActionListener(evt -> navigateToPreviousView(previousView));

        final JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(backButton);
        buttonPanel.setBackground(new Color(249, 249, 232));
        add(buttonPanel, BorderLayout.NORTH);
    }

    /**
     * Present Recipe.
     * @param keywordOutputData the output data
     */
    public void presentRecipesKeyword(KeywordOutputData keywordOutputData) {
        System.out.println("Presenting recipes in RecipeChoiceView");
        this.keywordRecipes = keywordOutputData.getRecipes();
        this.previousView = KEYWORD_SEARCH_VIEW;
        displayRecipes();
    }

    /**
     * Present Recipe.
     * @param cuisineOutputData the output data
     */
    public void presentRecipesCuisine(CuisineTypeOutputData cuisineOutputData) {
        this.cuisineRecipes = cuisineOutputData.getRecipes();
        this.previousView = CUISINE_SEARCH_VIEW;
        displayRecipes();
    }

    /**
     * Present Recipe.
     * @param dietLevelOutputData the output data
     */
    public void presentRecipesDiet(DietLevelOutputData dietLevelOutputData) {
        this.dietRecipes = dietLevelOutputData.getRecipes();
        this.previousView = DIET_SEARCH_VIEW;
        displayRecipes();
    }

    /**
     * Set Recipe.
     * @param recipes the recipe
     */
    public void setKeywordRecipes(List<Recipe> recipes) {
        this.keywordRecipes = recipes;
        this.previousView = KEYWORD_SEARCH_VIEW;
        System.out.println("Keyword recipes set in RecipeChoiceView: " + keywordRecipes);
    }

    /**
     * Set Recipe.
     * @param recipes the recipe
     */
    public void setCuisineRecipes(List<Recipe> recipes) {
        this.cuisineRecipes = recipes;
        this.previousView = CUISINE_SEARCH_VIEW;
        System.out.println("Cuisine recipes set in recipeChoiceView: " + cuisineRecipes);
    }

    /**
     * Set Recipe.
     * @param recipes the recipe
     */
    public void setDietRecipes(List<Recipe> recipes) {
        this.dietRecipes = recipes;
        this.previousView = DIET_SEARCH_VIEW;
        System.out.println("Diet recipes set in RecipeChoiceView: " + dietRecipes);
    }

    /**
     * Present Recipe.
     * @param randomOutputData the output data
     */
    public void presentRecipes(RandomOutputData randomOutputData) {
        this.randomRecipes = randomOutputData.getRecipes();
        this.previousView = RANDOM_SEARCH_VIEW;
        displayRecipes();
    }

    /**
     * Present Recipe.
     * @param caloriesOutputData the output data
     */
    public void presentRecipesCalories(CaloriesOutputData caloriesOutputData) {
        this.caloriesRecipes = caloriesOutputData.getRecipes();
        this.previousView = CALORIE_SEARCH_VIEW;
        displayRecipes();
    }

    /**
     * Present the Recipes.
     */
    public void displayRecipes() {
        removeAll();

        // Add the back button panel
        add(createBackButtonPanel(), BorderLayout.NORTH);

        // Collect all recipes
        final List<Recipe> allRecipes = gatherAllRecipes();

        // Check if there are recipes to display
        if (allRecipes.isEmpty()) {
            handleNoRecipesFound();
        }
        else {
            // Add the recipes panel
            add(createRecipesPanel(allRecipes), BorderLayout.CENTER);
        }

        revalidate();
        repaint();
    }

    /**
     * Creates the back button panel.
     * @return JPanel containing the back button
     */
    private JPanel createBackButtonPanel() {
        final JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(backButton, BorderLayout.NORTH);
        backButtonPanel.setBackground(new Color(249, 249, 232));
        return backButtonPanel;
    }

    /**
     * Gathers all recipes from the different recipe lists.
     * @return a consolidated list of recipes
     */
    private List<Recipe> gatherAllRecipes() {
        final List<Recipe> allRecipes = new ArrayList<>();
        if (keywordRecipes != null) {
            allRecipes.addAll(keywordRecipes);
        }
        if (cuisineRecipes != null) {
            allRecipes.addAll(cuisineRecipes);
        }
        if (dietRecipes != null) {
            allRecipes.addAll(dietRecipes);
        }
        if (caloriesRecipes != null) {
            allRecipes.addAll(caloriesRecipes);
        }
        if (randomRecipes != null) {
            allRecipes.addAll(randomRecipes);
        }
        return allRecipes;
    }

    /**
     * Handles the case where no recipes are found.
     */
    private void handleNoRecipesFound() {
        System.out.println("No recipes to display.");
        JOptionPane.showMessageDialog(this, "No recipes found.");
    }

    /**
     * Creates the recipes panel with the given list of recipes.
     * @param recipes list of recipes to display
     * @return JPanel containing the recipe cards
     */
    private JPanel createRecipesPanel(List<Recipe> recipes) {
        final JPanel recipesPanel = new JPanel(new GridLayout(0, 3, 10, 10));
        recipesPanel.setBackground(new Color(249, 249, 232));

        for (Recipe recipe : recipes) {
            recipesPanel.add(createRecipeCard(recipe));
        }

        return recipesPanel;
    }

    /**
     * Creates a card for an individual recipe.
     * @param recipe the recipe to display
     * @return JPanel representing the recipe card
     */
    private JPanel createRecipeCard(Recipe recipe) {
        final JPanel recipeCard = new JPanel(new BorderLayout());
        recipeCard.setBackground(new Color(249, 249, 232));
        recipeCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Recipe Label
        final JLabel recipeLabel = new JLabel(recipe.getLabel(), SwingConstants.CENTER);
        recipeLabel.setBackground(new Color(185, 224, 84));
        recipeCard.add(recipeLabel, BorderLayout.CENTER);

        // Ingredient Button
        final JButton ingredientButton = createIngredientButton(recipe);
        recipeCard.add(ingredientButton, BorderLayout.SOUTH);

        return recipeCard;
    }

    /**
     * Creates an ingredient button for the given recipe.
     * @param recipe the recipe whose ingredients are displayed on click
     * @return JButton for viewing the recipe's ingredients
     */
    private JButton createIngredientButton(Recipe recipe) {
        final JButton ingredientButton = new JButton("Ingredient");
        ingredientButton.setBackground(new Color(185, 224, 84));
        ingredientButton.addActionListener(evt -> displayRecipeDetails(recipe));
        return ingredientButton;
    }

    /**
     * Displays the details of a recipe in a dialog box.
     * @param recipe the recipe to display
     */
    private void displayRecipeDetails(Recipe recipe) {
        final String[] ingredients = recipe.getIngredients();
        final String ingredientList = String.join("\n", ingredients);

        final StringBuilder messageBuilder = new StringBuilder();

        // Include cuisine information if not null
        if (recipe.getCuisine() != null) {
            messageBuilder.append("Cuisine: ").append(recipe.getCuisine().toString()).append(STR);
        }

        // Include diet information if not null
        if (recipe.getDiet().getDietLabels().length > 0) {
            messageBuilder.append("Diet: ").append(recipe.getDiet().toString()).append(STR);
        }

        // Include calories information
        final String calories = "" + recipe.getCalories();
        if (calories != null) {
            messageBuilder.append("Calories: ").append(calories).append(STR);
        }

        // Include the ingredients
        messageBuilder.append(ingredientList);

        JOptionPane.showMessageDialog(
                this, messageBuilder.toString(),
                "Ingredients for " + recipe.getLabel(),
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
