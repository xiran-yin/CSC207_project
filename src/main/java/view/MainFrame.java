package view;

import interface_adapter.Calories.CalorieSearchView;
import interface_adapter.Calories.CaloriesController;
import interface_adapter.CuisineType.CuisineSearchView;
import interface_adapter.CuisineType.CuisineTypeController;
import interface_adapter.Keyword.KeywordController;
import interface_adapter.Keyword.KeywordSearchView;
import interface_adapter.Random.RandomController;
import usecase.DietLevel.DietLevelInputBoundary;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainFrame(KeywordController keywordController,
                     CuisineTypeController cuisineTypeController,
                     DietLevelInputBoundary dietLevelInputBoundary,
                     RecipeChoiceView recipeChoiceView,
                     CaloriesController caloriesController,
                     RandomController randomController){
        setTitle("Recipe Finder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize CardLayout and Main Panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create and add views
        HomeView homeView = new HomeView(this); // Home view

        // Add views to the main panel
        mainPanel.add(homeView, "HomeView");
        addView("KeywordSearchView", new KeywordSearchView(keywordController, this));
        addView("CuisineSearchView", new CuisineSearchView(cuisineTypeController, this));
        addView("RecipeChoiceView", recipeChoiceView);
        addView("CalorieSearchView", new CalorieSearchView(this, caloriesController));
        addView("RandomSearchView", new RandomSearchView(this, randomController));

        // Add main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // Start with HomeView
        showView("HomeView");

        setVisible(true);
    }

    // Method to navigate between views
    public void showView(String viewName) {
        System.out.println("Switching to view: " + viewName);
        cardLayout.show(mainPanel, viewName);
    }

    private void addView(String viewName, JPanel view) {
        mainPanel.add(view, viewName);
    }








}
