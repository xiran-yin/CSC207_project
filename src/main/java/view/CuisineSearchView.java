package view;

import java.awt.BorderLayout;
import java.awt.Color;
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
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;
    private JComboBox<String> cuisineComboBox;

    public CuisineSearchView(CuisineTypeController cuisineController, MainFrame mainFrame) {
        final Color backgroundColor = new Color(249, 249, 232);
        final Color lightGreenColor = new Color(185, 224, 84);
        final int ten = 10;
        final int sixteen = 16;
        final int thirty = 30;
        final int twohundred = 200;
        final int width = 250;
        final int eighty = 80;

        setLayout(new BorderLayout());
        setBackground(backgroundColor);

        // Search bar setup
        final JPanel searchPanel = new JPanel(new BorderLayout(ten, ten));
        keywordField = new JTextField();
        keywordField.setPreferredSize(new Dimension(width, thirty));
        final String font = "Comic Sans MS";
        keywordField.setFont(new Font(font, Font.PLAIN, sixteen));

        searchButton = new JButton("Go");
        backButton = new JButton("Back");

        searchButton.setOpaque(true);
        searchButton.setBackground(lightGreenColor);
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font(font, Font.BOLD, sixteen));
        searchButton.setPreferredSize(new Dimension(eighty, thirty));

        backButton.setOpaque(true);
        backButton.setBackground(lightGreenColor);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font(font, Font.BOLD, sixteen));
        backButton.setPreferredSize(new Dimension(eighty, thirty));

        final JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, ten));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(backgroundColor);

        searchPanel.add(keywordField, BorderLayout.CENTER);
        searchPanel.add(buttonPanel, BorderLayout.EAST);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(twohundred, ten, ten, ten));
        searchPanel.setBackground(backgroundColor);

        // Cuisine Panel
        final JPanel cuisinePanel = new JPanel(new BorderLayout());
        cuisineComboBox = new JComboBox<>(CUISINES);
        cuisineComboBox.setPreferredSize(new Dimension(twohundred, eighty));
        cuisineComboBox.setFont(new Font(font, Font.PLAIN, sixteen));
        cuisineComboBox.setBorder(BorderFactory.createTitledBorder("Select Cuisine"));
        cuisineComboBox.setBackground(Color.white);
        cuisinePanel.add(cuisineComboBox, BorderLayout.CENTER);
        cuisinePanel.setBorder(BorderFactory.createEmptyBorder(ten, ten, ten, ten));
        cuisinePanel.setBackground(backgroundColor);

        // Combine searchBarPanel and filterPanel into a single panel
        final JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(cuisinePanel);
        combinedPanel.setBackground(backgroundColor);

        // Add combined panel to the layout
        add(combinedPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(evt -> handleCuisineSearch(cuisineController, mainFrame));

        // Back button action
        backButton.addActionListener(evt -> {
            cuisineComboBox.setSelectedIndex(0);
            keywordField.setText("");
            mainFrame.showView("HomeView");
        });
    }

    private void handleCuisineSearch(CuisineTypeController cuisineController, MainFrame mainFrame) {
        final String keyword = keywordField.getText().trim();
        final String cuisine = (String) cuisineComboBox.getSelectedItem();
        if (!keyword.isEmpty()) {
            try {
                cuisineController.cuisineRecipes(keyword, cuisine);
                mainFrame.showView("RecipeChoiceView");
                keywordField.setText("");
                cuisineComboBox.setSelectedIndex(0);
            }
            catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid keyword.");
            }
        }
        else {
            JOptionPane.showMessageDialog(this, "Please enter a keyword.");
        }
    }
}
