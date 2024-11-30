package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.MainFrame;
import interface_adapter.cuisine_type.CuisineTypeController;

/**
 * The View for when the user is used the Cuisine Filter in the program.
 */
public class CuisineSearchView extends JPanel {
    private static final String[] CUISINES = {"", "American", "Asian", "British", "Caribbean",
        "Central Europe", "Chinese", "Eastern Europe", "French",
        "Indian", "Italian", "Japanese", "Kosher", "Mediterranean", "Mexican",
        "Middle Eastern", "Nordic", "South American", "South East Asian"};
    private JPanel recipePanel;
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;
    private JComboBox<String> cuisineComboBox;

    public CuisineSearchView(CuisineTypeController cuisineController, MainFrame mainFrame) {
        setLayout(new BorderLayout());

        // Search bar setup
        final JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        keywordField = new JTextField();
        keywordField.setPreferredSize(new Dimension(250, 30));
        searchButton = new JButton("Go");
        backButton = new JButton("Back");

        final JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        searchPanel.add(keywordField, BorderLayout.CENTER);
        searchPanel.add(buttonPanel, BorderLayout.EAST);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10));

        // Cuisine Panel
        final JPanel cuisinePanel = new JPanel(new BorderLayout());
        cuisineComboBox = new JComboBox<>(CUISINES);
        cuisineComboBox.setPreferredSize(new Dimension(200, 80));
        cuisineComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        cuisineComboBox.setBorder(BorderFactory.createTitledBorder("Select Cuisine"));
        cuisinePanel.add(cuisineComboBox, BorderLayout.CENTER);
        cuisinePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Combine searchBarPanel and filterPanel into a single panel
        final JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(cuisinePanel);

        // Add combined panel to the layout
        add(combinedPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(evt -> {
            final String keyword = keywordField.getText().trim();
            final String cuisine = (String) cuisineComboBox.getSelectedItem();
            if (!keyword.isEmpty()) {
                try {
                    cuisineController.cuisineRecipes(keyword, cuisine);
                    mainFrame.showView("RecipeChoiceView");
                }
                catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid keyword.");
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Please enter a keyword.");
            }
        });

        // Back button action
        backButton.addActionListener(evt -> mainFrame.showView("HomeView"));
    }
}
