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
import interface_adapter.diet_level.DietLevelController;


/**
 * The View for when the user is used the Diet Filter in the program.
 */
public class DietSearchView extends JPanel {

    private JPanel recipePanel;
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;
    private JComboBox<String> dietComboBox;
    private DietLevelController dietLevelController;


    private static final String[] DIET = {"","low-fat", "low-carb", "balanced", "high-fiber", "low-sodium", "high-protein"};


    public DietSearchView(MainFrame mainFrame, DietLevelController dietLevelController) {
        setLayout(new BorderLayout());

        // Search bar setup
        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        keywordField = new JTextField();
        keywordField.setPreferredSize(new Dimension(250, 30));
        searchButton = new JButton("Go");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        searchPanel.add(keywordField, BorderLayout.CENTER);
        searchPanel.add(buttonPanel, BorderLayout.EAST);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10)); // Padding around search panel

        // Cuisine Panel
        JPanel dietPanel = new JPanel(new BorderLayout());
        dietComboBox = new JComboBox<>(DIET);
        dietComboBox.setPreferredSize(new Dimension(200, 80));
        dietComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        dietComboBox.setBorder(BorderFactory.createTitledBorder("Select Diet Label"));
        dietPanel.add(dietComboBox, BorderLayout.CENTER);
        dietPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around cuisine panel

        // Combine searchBarPanel and filterPanel into a single panel
        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(dietPanel);

        // Add combined panel to the layout
        add(combinedPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(e -> {
            String keyword = keywordField.getText().trim();
            String diet = (String) dietComboBox.getSelectedItem();
            if (!keyword.isEmpty()) {
                try {
                    //dietLevelInputBoundary.searchDietLevelRecipe(new DietLevelInputData(keyword, diet));
                    dietLevelController.searchDietLevelRecipe(keyword, diet);
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
