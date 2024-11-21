package interface_adapter.DietLevel;

import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.CuisineType.CuisineTypeInputData;
import usecase.DietLevel.DietLevelInputBoundary;
import usecase.DietLevel.DietLevelInputData;
import view.MainFrame;
import view.RecipeChoiceView;

import javax.swing.*;
import java.awt.*;

public class DietSearchView extends JPanel {

    private JPanel recipePanel;
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;
    private JComboBox<String> dietComboBox;


    private static final String[] DIET = {"","low-fat", "low-carb", "balanced", "high-fiber", "low-sodium", "high-protein"};


    public DietSearchView(MainFrame mainFrame, DietLevelInputBoundary dietLevelInputBoundary, JPanel cardPanel) {
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
        dietComboBox = new JComboBox<>(DIET);
        dietComboBox.setPreferredSize(new Dimension(200, 40));
        dietComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        dietComboBox.setBorder(BorderFactory.createTitledBorder("Select Diet Label"));
        cuisinePanel.add(dietComboBox, BorderLayout.CENTER);
        cuisinePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around cuisine panel

        // Combine searchBarPanel and filterPanel into a single panel
        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(cuisinePanel);

        // Add combined panel to the layout
        add(combinedPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(e -> {
            String keyword = keywordField.getText().trim();
            String diet = (String) dietComboBox.getSelectedItem();
            if (!keyword.isEmpty()) {
                try {
                    dietLevelInputBoundary.searchDietLevelRecipe(new DietLevelInputData(keyword, diet));
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
