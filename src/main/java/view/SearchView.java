package view;

import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.CuisineType.CuisineTypeInputData;
import usecase.DietLevel.DietLevelInputBoundary;
import usecase.DietLevel.DietLevelInputData;
import usecase.DietLevel.DietLevelOutputBoundary;
import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordInputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// the top part, which let user enter the keyword and press "GO"
public class SearchView extends JPanel {
    private final KeywordInputBoundary keywordInputBoundary;
    private JTextField keywordField;
    private JTextField dietField;
    private final CuisineTypeInputBoundary cuisineInputBounary;
    private final DietLevelInputBoundary dietInputBoundary;
    private JComboBox<String> cuisineComboBox;
    private JComboBox<String> dietComboBox;
    private JTextField minCaloriesField;
    private JTextField maxCaloriesField;
    private JButton searchButton;
    private JPanel recipePanel;
    private JButton randomButton;
    private final JButton backButton;

    // List of cuisines for the combo box
    private static final String[] CUISINES = {"","American", "Asian", "British", "Caribbean", "Central Europe", "Chinese",
            "Eastern Europe", "French", "Indian", "Italian", "Japanese", "Kosher", "Mediterranean", "Mexican",
            "Middle Eastern", "Nordic", "South American", "South East Asian"};
    private static final String[] DIET = {"","low-fat", "low-carb", "balanced", "high-fiber", "low-sodium", "high-protein"};

    public SearchView(KeywordInputBoundary keywordInputBoundary, CuisineTypeInputBoundary cuisineInputBoundary,
                      DietLevelInputBoundary dietInputBoundary, RecipeChoiceView recipePanel) {
        this.keywordInputBoundary = keywordInputBoundary;
        this.cuisineInputBounary = cuisineInputBoundary;
        this.dietInputBoundary = dietInputBoundary;
        this.recipePanel = recipePanel;

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridLayout(2, 1, 10, 10));

        // Search Bar Panel + 2 button
        JPanel searchBarPanel = new JPanel(new BorderLayout());
        keywordField = new JTextField();
        searchButton = new JButton("Go");
        backButton = new JButton("Back");
        randomButton = new JButton("Random");
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0)); // Holds Go and Back buttons
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.add(randomButton);
        searchBarPanel.add(keywordField, BorderLayout.CENTER);
        searchBarPanel.add(buttonPanel, BorderLayout.EAST);

        // Filter Panel
        JPanel filterPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        dietComboBox = new JComboBox<>(DIET);
        dietComboBox.setBorder(BorderFactory.createTitledBorder("Diet"));
        cuisineComboBox = new JComboBox<>(CUISINES);
        cuisineComboBox.setBorder(BorderFactory.createTitledBorder("Cuisine"));
        minCaloriesField = new JTextField();
        minCaloriesField.setBorder(BorderFactory.createTitledBorder("Min Calories"));
        maxCaloriesField = new JTextField();
        maxCaloriesField.setBorder(BorderFactory.createTitledBorder("Max Calories"));

        filterPanel.add(dietComboBox);
        filterPanel.add(cuisineComboBox);
        filterPanel.add(minCaloriesField);
        filterPanel.add(maxCaloriesField);

        // Add search bar and filter panel to the top panel
        topPanel.add(searchBarPanel);
        topPanel.add(filterPanel);

        // Add top panel to the main panel
        add(topPanel, BorderLayout.NORTH);

        // Action listener for the search button (GO)
        searchButton.addActionListener((ActionEvent e) -> {
            System.out.println("Go button pressed");

            if (recipePanel.getComponentCount() != 0) {
                recipePanel.removeAll();
                String keyword = keywordField.getText();
                String cuisine = (String) cuisineComboBox.getSelectedItem();//Get selected cuisine from combo box
                String diet = (String) dietComboBox.getSelectedItem();

                //Only search if keyword typed in
                if (!keyword.isEmpty()) {
                    if (!cuisine.isEmpty()) {
                        cuisineInputBoundary.searchCuisineRecipe(new CuisineTypeInputData(keyword, cuisine));
                    }
                    else if (!diet.isEmpty()) {
                        dietInputBoundary.searchDietLevelRecipe(new DietLevelInputData(keyword, diet));
                    }
                    else {
                        keywordInputBoundary.searchKeywordRecipe(new KeywordInputData(keyword));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a keyword to search or click random");
                }
                recipePanel.revalidate();
                recipePanel.repaint();
            }
            else{
                String keyword = keywordField.getText();
                String cuisine = (String) cuisineComboBox.getSelectedItem();//Get selected cuisine from combo box
                String diet = (String) dietComboBox.getSelectedItem();

                //Only search if keyword typed in
                if (!keyword.isEmpty()) {
                    if (!cuisine.isEmpty()) {
                        cuisineInputBoundary.searchCuisineRecipe(new CuisineTypeInputData(keyword, cuisine));
                    }
                    else if (!diet.isEmpty()) {
                        dietInputBoundary.searchDietLevelRecipe(new DietLevelInputData(keyword, diet));
                    }
                    else {
                        keywordInputBoundary.searchKeywordRecipe(new KeywordInputData(keyword));
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter a keyword to search or click random");
                }
            }
        });

        //hmmmm doesn't work right now

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("Back button pressed");
            // Clear the recipe panel and reset the view
            recipePanel.removeAll();
            recipePanel.revalidate();
            recipePanel.repaint();
        }
        );

    }
}
