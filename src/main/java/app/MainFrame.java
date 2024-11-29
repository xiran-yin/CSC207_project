package app;

import interface_adapter.calories.CaloriesController;
import interface_adapter.cuisine_type.CuisineTypeController;
import interface_adapter.diet_level.DietLevelController;
import interface_adapter.keyword.KeywordController;
import interface_adapter.random.RandomController;

import javax.swing.*;
import java.awt.*;
import view.CalorieSearchView;
import view.CuisineSearchView;
import view.DietSearchView;
import view.HomeView;
import view.KeywordSearchView;
import view.RandomSearchView;
import view.RecipeChoiceView;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainFrame(KeywordController keywordController,
                     CuisineTypeController cuisineTypeController,
                     RecipeChoiceView recipeChoiceView,
                     CaloriesController caloriesController,
                     RandomController randomController,
                     DietLevelController dietLevelController){
        setTitle("Recipe Finder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        // Initialize CardLayout and Main Panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Set the background color.
        setBackground(new Color(102,204,0));

        // Create and add views
        HomeView homeView = new HomeView(this); // Home view

        // Add views to the main panel
        mainPanel.add(homeView, "HomeView");
        addView("KeywordSearchView", new KeywordSearchView(keywordController, this));
        addView("CuisineSearchView", new CuisineSearchView(cuisineTypeController, this));
        addView("RecipeChoiceView", recipeChoiceView);
        addView("CalorieSearchView", new CalorieSearchView(this, caloriesController));
        addView("RandomSearchView", new RandomSearchView(this, randomController));
        addView("DietSearchView", new DietSearchView(this, dietLevelController));

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
