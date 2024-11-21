package view;

import interface_adapter.CuisineType.CuisineSearchView;
import interface_adapter.Keyword.KeywordSearchView;
import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel mainPanel;
    private CardLayout cardLayout;

//    public MainFrame(KeywordInputBoundary keywordInputBoundary, CuisineTypeInputBoundary cuisineInputBoundary, KeywordOutputBoundary keywordOutputBoundary) {
//        setTitle("Recipe Finder");
//        setSize(800, 600);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());
//
//        // Create Panels
//        RecipeChoiceView recipePanel = (RecipeChoiceView) keywordOutputBoundary;
//        SearchView searchView = new SearchView(keywordInputBoundary, cuisineInputBoundary, recipePanel);
//
//        // Add Panels
//        add(searchView, BorderLayout.NORTH);
//        add(new JScrollPane(recipePanel), BorderLayout.CENTER);
//
//        setVisible(true);
//
//    }

    public MainFrame(KeywordInputBoundary keywordInputBoundary,
                     CuisineTypeInputBoundary cuisineInputBoundary,
                     KeywordOutputBoundary keywordOutputBoundary) {
        setTitle("Recipe Finder");
        setSize(800, 600);
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

        // Add views to the main panel
        mainPanel.add(homeView, "HomeView");
        mainPanel.add(keywordSearchView, "KeywordSearchView");
        mainPanel.add(cuisineSearchView, "CuisineSearchView");
        mainPanel.add(recipePanel, "RecipeChoiceView");

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
