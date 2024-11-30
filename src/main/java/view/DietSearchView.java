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
    private static final String[] DIET = {"", "balanced", "high-fiber", "high-protein",
        "low-fat", "low-carb", "low-sodium"};
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;
    private JComboBox<String> dietComboBox;

    public DietSearchView(MainFrame mainFrame, DietLevelController dietLevelController) {
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
        final JPanel dietPanel = new JPanel(new BorderLayout());
        dietComboBox = new JComboBox<>(DIET);
        dietComboBox.setPreferredSize(new Dimension(200, 80));
        dietComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
        dietComboBox.setBorder(BorderFactory.createTitledBorder("Select Diet Label"));
        dietPanel.add(dietComboBox, BorderLayout.CENTER);
        dietPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Combine searchBarPanel and filterPanel into a single panel
        final JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(dietPanel);

        // Add combined panel to the layout
        add(combinedPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(evt -> {
            handleDietSearch(mainFrame, dietLevelController);
        });

        // Back button action
        backButton.addActionListener(evt -> mainFrame.showView("HomeView"));
    }

    private void handleDietSearch(MainFrame mainFrame, DietLevelController dietLevelController) {
        final String keyword = keywordField.getText().trim();
        final String diet = (String) dietComboBox.getSelectedItem();
        if (!keyword.isEmpty()) {
            try {
                dietLevelController.searchDietLevelRecipe(keyword, diet);
                mainFrame.showView("RecipeChoiceView");
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
