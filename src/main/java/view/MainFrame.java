package view;

import interface_adapter.Calories.CalorieSearchView;
import interface_adapter.CuisineType.CuisineSearchView;
import interface_adapter.DietLevel.DietSearchView;
import interface_adapter.Keyword.KeywordSearchView;
import usecase.Calories.CaloriesInputBoundary;
import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.DietLevel.DietLevelInputBoundary;
import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordOutputBoundary;
import usecase.Random.RandomInputBoundary;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainFrame(KeywordInputBoundary keywordInputBoundary,
                     CuisineTypeInputBoundary cuisineInputBoundary,
                     DietLevelInputBoundary dietLevelInputBoundary,
                     KeywordOutputBoundary keywordOutputBoundary,
                     CaloriesInputBoundary caloriesInputBoundary,
                     RandomInputBoundary randomInputBoundary) {
        setTitle("Recipe Finder");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize CardLayout and Main Panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create and add views
        HomeView homeView = new HomeView(this); // Home view
        RecipeChoiceView recipePanel = (RecipeChoiceView) keywordOutputBoundary;
        KeywordSearchView keywordSearchView = new KeywordSearchView(this, keywordInputBoundary,recipePanel);
        CuisineSearchView cuisineSearchView = new CuisineSearchView(this, cuisineInputBoundary, recipePanel);
        DietSearchView dietSearchView = new DietSearchView(this, dietLevelInputBoundary, recipePanel);
        CalorieSearchView calorieSearchView = new CalorieSearchView(this, caloriesInputBoundary, recipePanel);
        RandomRecipeView randomRecipeView = new RandomRecipeView(this, randomInputBoundary, recipePanel);

        // Add views to the main panel
        mainPanel.add(homeView, "HomeView");
        mainPanel.add(keywordSearchView, "KeywordSearchView");
        mainPanel.add(cuisineSearchView, "CuisineSearchView");
        mainPanel.add(recipePanel, "RecipeChoiceView");
        mainPanel.add(dietSearchView, "DietSearchView");
        mainPanel.add(calorieSearchView, "CalorieSearchView");
        mainPanel.add(randomRecipeView, "RandomRecipeView");

        // Add main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // Start with HomeView
        showView("HomeView");

        setVisible(true);
    }

    // Method to navigate between views
    public void showView(String viewName) {
        cardLayout.show(mainPanel, viewName);
    }
}
