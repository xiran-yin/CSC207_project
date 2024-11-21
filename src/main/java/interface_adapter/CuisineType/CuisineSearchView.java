package interface_adapter.CuisineType;

import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.CuisineType.CuisineTypeInputData;
import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordInputData;
import view.MainFrame;
import view.RecipeChoiceView;

import javax.swing.*;
import java.awt.*;

public class CuisineSearchView extends JPanel{
    private JPanel recipePanel;
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;
    private JComboBox<String> cuisineComboBox;


    private static final String[] CUISINES = {"", "American", "Asian", "British", "Caribbean", "Central Europe", "Chinese",
            "Eastern Europe", "French", "Indian", "Italian", "Japanese", "Kosher", "Mediterranean", "Mexican",
            "Middle Eastern", "Nordic", "South American", "South East Asian"};

    public CuisineSearchView(MainFrame mainFrame, CuisineTypeInputBoundary cuisineTypeInputBoundary, JPanel cardPanel) {
        setLayout(new BorderLayout());

        // Search bar setup
        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        keywordField = new JTextField();
        keywordField.setPreferredSize(new Dimension(400, 30));
        searchButton = new JButton("Go");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        searchPanel.add(keywordField, BorderLayout.CENTER);
        searchPanel.add(buttonPanel, BorderLayout.EAST);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around search panel

        // Cuisine Panel
        JPanel cuisinePanel = new JPanel(new BorderLayout());
        cuisineComboBox = new JComboBox<>(CUISINES);
        cuisineComboBox.setPreferredSize(new Dimension(200, 40));
        cuisineComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        cuisineComboBox.setBorder(BorderFactory.createTitledBorder("Select Cuisine"));
        cuisinePanel.add(cuisineComboBox, BorderLayout.CENTER);
        cuisinePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around cuisine panel

        // Combine searchBarPanel and filterPanel into a single panel
        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(cuisinePanel);

        // Add combined panel to the layout
        add(combinedPanel, BorderLayout.NORTH);





        // Add RecipeChoiceView below the search bar
        JScrollPane scrollPane = new JScrollPane(recipePanel);
        add(scrollPane, BorderLayout.CENTER);

        // Search button action
        searchButton.addActionListener(e -> {
            String keyword = keywordField.getText().trim();
            String cuisine = (String) cuisineComboBox.getSelectedItem();
            if (!keyword.isEmpty()) {
                try {
                    cuisineTypeInputBoundary.searchCuisineRecipe(new CuisineTypeInputData(keyword, cuisine));
                    RecipeChoiceView recipeChoiceView = (RecipeChoiceView) recipePanel;
                    // Switch to the RecipeChoiceView card
                    mainFrame.showView("RecipeChoiceView");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid keyword.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a keyword.");
            }
        });

        // Back button action
        backButton.addActionListener(e -> mainFrame.showView("HomeView"));
    }
}
