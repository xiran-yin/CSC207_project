package view;

import app.MainFrame;
import interface_adapter.cuisine_type.CuisineTypeController;

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

    public CuisineSearchView(CuisineTypeController cuisineController, MainFrame mainFrame) {
        setLayout(new BorderLayout());
        setBackground(new Color(249, 249, 232));

        // Search bar setup
        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        keywordField = new JTextField();
        keywordField.setPreferredSize(new Dimension(250, 30));
        keywordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

        searchButton = new JButton("Go");
        backButton = new JButton("Back");

        searchButton.setOpaque(true);
        searchButton.setBackground(new Color(185,224,84));
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        searchButton.setPreferredSize(new Dimension(80, 30));

        backButton.setOpaque(true);
        backButton.setBackground(new Color(185,224,84));
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(80, 30));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(new Color(249, 249, 232));

        searchPanel.add(keywordField, BorderLayout.CENTER);
        searchPanel.add(buttonPanel, BorderLayout.EAST);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10)); // Padding around search panel
        searchPanel.setBackground(new Color(249, 249, 232));

        // Cuisine Panel
        JPanel cuisinePanel = new JPanel(new BorderLayout());
        cuisineComboBox = new JComboBox<>(CUISINES);
        cuisineComboBox.setPreferredSize(new Dimension(200, 80));
        cuisineComboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        cuisineComboBox.setBorder(BorderFactory.createTitledBorder("Select Cuisine"));
        cuisineComboBox.setBackground(Color.white);
        cuisinePanel.add(cuisineComboBox, BorderLayout.CENTER);
        cuisinePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around cuisine panel
        cuisinePanel.setBackground(new Color(249, 249, 232));

        // Combine searchBarPanel and filterPanel into a single panel
        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(cuisinePanel);
        combinedPanel.setBackground(new Color(249, 249, 232));

        // Add combined panel to the layout
        add(combinedPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(e -> {
            String keyword = keywordField.getText().trim();
            String cuisine = (String) cuisineComboBox.getSelectedItem();
            if (!keyword.isEmpty()) {
                try {
                    cuisineController.cuisineRecipes(keyword, cuisine);
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
