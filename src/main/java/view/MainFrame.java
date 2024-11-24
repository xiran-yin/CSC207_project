package view;

import api.RecipeDataBase;
import api.getRecipeDataBase;
import interface_adapter.CuisineType.CuisineSearchView;
import interface_adapter.DietLevel.DietSearchView;
import interface_adapter.Keyword.KeywordController;
import interface_adapter.Keyword.KeywordPresenter;
import interface_adapter.Keyword.KeywordSearchView;
import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.DietLevel.DietLevelInputBoundary;
import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordInteractor;
import usecase.Keyword.KeywordOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public MainFrame(KeywordController keywordController,
                     CuisineTypeInputBoundary cuisineInputBoundary,
                     DietLevelInputBoundary dietLevelInputBoundary,
                     RecipeChoiceView recipeChoiceView) {
        setTitle("Recipe Finder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize CardLayout and Main Panel
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Create and add views
        HomeView homeView = new HomeView(this); // Home view
//        RecipeChoiceView recipePanel = (RecipeChoiceView) keywordOutputBoundary;
//        CuisineSearchView cuisineSearchView = new CuisineSearchView(this, cuisineInputBoundary, recipePanel);
//        DietSearchView dietSearchView = new DietSearchView(this, dietLevelInputBoundary, recipePanel);

        // Add views to the main panel
        mainPanel.add(homeView, "HomeView");
        addView("KeywordSearchView", new KeywordSearchView(keywordController, this));
//        mainPanel.add(cuisineSearchView, "CuisineSearchView");
        addView("RecipeChoiceView", recipeChoiceView);//        mainPanel.add(dietSearchView, "DietSearchView");

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
