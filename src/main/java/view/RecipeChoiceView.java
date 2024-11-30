package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
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

    private void initializeUi() {

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
        this.previousView = "KeywordSearchView";
        displayRecipes();
    }

    /**
     * Present Recipe.
     * @param cuisineOutputData the output data
     */
    public void presentRecipesCuisine(CuisineTypeOutputData cuisineOutputData) {
        this.cuisineRecipes = cuisineOutputData.getRecipes();
        this.previousView = "CuisineSearchView";
        displayRecipes();
    }

    /**
     * Present Recipe.
     * @param dietLevelOutputData the output data
     */
    public void presentRecipesDiet(DietLevelOutputData dietLevelOutputData) {
        this.dietRecipes = dietLevelOutputData.getRecipes();
        this.previousView = "DietSearchView";
        displayRecipes();
    }

    /**
     * Set Recipe.
     * @param recipes the recipe
     */
    public void setKeywordRecipes(List<Recipe> recipes) {
        this.keywordRecipes = recipes;
        this.previousView = "KeywordSearchView";
        System.out.println("Keyword recipes set in RecipeChoiceView: " + keywordRecipes);
    }

    /**
     * Set Recipe.
     * @param recipes the recipe
     */
    public void setCuisineRecipes(List<Recipe> recipes) {
        this.cuisineRecipes = recipes;
        this.previousView = "CuisineSearchView";
        System.out.println("Cuisine recipes set in recipeChoiceView: " + cuisineRecipes);
    }

    /**
     * Set Recipe.
     * @param recipes the recipe
     */
    public void setDietRecipes(List<Recipe> recipes) {
        this.dietRecipes = recipes;
        this.previousView = "DietSearchView";
        System.out.println("Diet recipes set in RecipeChoiceView: " + dietRecipes);
    }

    /**
     * Present Recipe.
     * @param randomOutputData the output data
     */
    public void presentRecipes(RandomOutputData randomOutputData) {
        this.randomRecipes = randomOutputData.getRecipes();
        this.previousView = "RandomSearchView";
        displayRecipes();
    }

    /**
     * Present Recipe.
     * @param caloriesOutputData the output data
     */
    public void presentRecipesCalories(CaloriesOutputData caloriesOutputData) {
        this.caloriesRecipes = caloriesOutputData.getRecipes();
        this.previousView = "CalorieSearchView";
        displayRecipes();
    }

    /**
     * Present the Recipes.
     */
    public void displayRecipes() {
        removeAll();
        final JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backButtonPanel.add(backButton, BorderLayout.NORTH);
        backButtonPanel.setBackground(new Color(249, 249, 232));
        add(backButtonPanel, BorderLayout.NORTH);

        final JPanel recipesPanel = new JPanel();
        recipesPanel.setBackground(new Color(249, 249, 232));
        recipesPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 3 columns, dynamic rows

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
        if (allRecipes.isEmpty()) {
            System.out.println("No recipes to display.");
            JOptionPane.showMessageDialog(this, "No recipes found.");
        }
        else {
            // Display recipes
            for (Recipe recipe : allRecipes) {
                System.out.println("Displaying recipe: " + recipe);
                final JPanel recipeCard = new JPanel();

                recipeCard.setBackground(new Color(249, 249, 232));
                recipeCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                recipeCard.setLayout(new BorderLayout());
                // Recipe Label
                final JLabel recipeLabel = new JLabel(recipe.getLabel(), SwingConstants.CENTER);
                recipeCard.add(recipeLabel, BorderLayout.CENTER);
                recipeLabel.setBackground(new Color(185,224,84));

                final JButton ingredientButton = new JButton("Ingredient");
                ingredientButton.setBackground(new Color(185,224,84));
                ingredientButton.addActionListener(evt -> {
                    final String[] ingredients = recipe.getIngredients();
                    final String ingredientList = String.join("\n", ingredients);

                    final StringBuilder messageBuilder = new StringBuilder();

                    // Include cuisine information if not null
                    if (recipe.getCuisine() != null) {
                        messageBuilder.append("Cuisine: ").append(recipe.getCuisine().toString()).append("\n\n");
                    }

                    // Include diet information if not null
                    if (recipe.getDiet().getDietLabels().length > 0) {
                        messageBuilder.append("Diet: ").append(recipe.getDiet().toString()).append("\n\n");
                    }

                    // Include the ingredients
                    messageBuilder.append(ingredientList);

                    JOptionPane.showMessageDialog(
                            this, messageBuilder.toString(),
                            "Ingredients for " + recipe.getLabel(),
                            JOptionPane.INFORMATION_MESSAGE
                    );
                });

                recipeCard.add(ingredientButton, BorderLayout.SOUTH);
                recipesPanel.add(recipeCard);
            }
        }
        add(recipesPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
