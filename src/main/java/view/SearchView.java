package view;

import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordInputData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// the top part, which let user enter the keyword and press "GO"
public class SearchView extends JPanel {
    private final KeywordInputBoundary inputBoundary;
    private JTextField keywordField;
    private JTextField dietField;
    private JTextField cuisineField;
    private JTextField minCaloriesField;
    private JTextField maxCaloriesField;
    private JButton searchButton;
    private JPanel recipePanel;
    private JButton randomButton;
    private final JButton backButton;

    public SearchView(KeywordInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;

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
        dietField = new JTextField();
        dietField.setBorder(BorderFactory.createTitledBorder("Diet"));
        cuisineField = new JTextField();
        cuisineField.setBorder(BorderFactory.createTitledBorder("Cuisine"));
        minCaloriesField = new JTextField();
        minCaloriesField.setBorder(BorderFactory.createTitledBorder("Min Calories"));
        maxCaloriesField = new JTextField();
        maxCaloriesField.setBorder(BorderFactory.createTitledBorder("Max Calories"));

        filterPanel.add(dietField);
        filterPanel.add(cuisineField);
        filterPanel.add(minCaloriesField);
        filterPanel.add(maxCaloriesField);

        // Add search bar and filter panel to the top panel
        topPanel.add(searchBarPanel);
        topPanel.add(filterPanel);

        // Add top panel to the main panel
        add(topPanel, BorderLayout.NORTH);

        // Action listener for the search button
        searchButton.addActionListener((ActionEvent e) -> {
            String keyword = keywordField.getText();

            inputBoundary.searchKeywordRecipe(new KeywordInputData(keyword));
        });

        //hmmmm doesn't work right now

        backButton.addActionListener((ActionEvent e) -> {
            System.out.println("Back button pressed");
            // Clear the recipe panel and reset the view
            recipePanel.removeAll();
            revalidate();
            repaint();
        }
        );

    }
}
