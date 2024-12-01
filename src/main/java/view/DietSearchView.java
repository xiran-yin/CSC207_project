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
        final Color background = new Color(249, 249, 232);
        setBackground(background);

        // Search bar setup
        final int gap = 10;
        final JPanel searchPanel = new JPanel(new BorderLayout(gap, gap));

        keywordField = new JTextField();
        final String font = "Comic Sans MS";
        final int size = 16;
        keywordField.setFont(new Font(font, Font.PLAIN, size));

        final int width = 250;
        final int height = 30;

        keywordField.setPreferredSize(new Dimension(width, height));
        searchButton = new JButton("Go");
        backButton = new JButton("Back");

        searchButton.setOpaque(true);
        final Color lightGreen = new Color(185, 224, 84);
        searchButton.setBackground(lightGreen);
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font(font, Font.BOLD, size));
        final int buttonWide = 80;
        searchButton.setPreferredSize(new Dimension(buttonWide, height));

        backButton.setOpaque(true);
        backButton.setBackground(lightGreen);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font(font, Font.BOLD, size));
        backButton.setPreferredSize(new Dimension(buttonWide, height));

        final JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, gap));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(background);

        searchPanel.add(keywordField, BorderLayout.CENTER);
        searchPanel.add(buttonPanel, BorderLayout.EAST);
        final int top = 200;

        searchPanel.setBorder(BorderFactory.createEmptyBorder(top, gap, gap, gap));
        searchPanel.setBackground(background);

        // Cuisine Panel
        final JPanel dietPanel = new JPanel(new BorderLayout());
        dietComboBox = new JComboBox<>(DIET);
        dietComboBox.setPreferredSize(new Dimension(top, buttonWide));
        dietComboBox.setFont(new Font(font, Font.PLAIN, size));
        dietComboBox.setBorder(BorderFactory.createTitledBorder("Select Diet Label"));
        dietComboBox.setBackground(Color.white);
        dietPanel.add(dietComboBox, BorderLayout.CENTER);
        dietPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
        dietPanel.setBackground(background);

        // Combine searchBarPanel and filterPanel into a single panel
        final JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(dietPanel);
        combinedPanel.setBackground(background);

        // Add combined panel to the layout
        add(combinedPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(evt -> handleDietSearch(mainFrame, dietLevelController));

        // Back button action
        backButton.addActionListener(evt -> {
            dietComboBox.setSelectedIndex(0);
            keywordField.setText("");
            mainFrame.showView("HomeView");
        });
    }

    private void handleDietSearch(MainFrame mainFrame, DietLevelController dietLevelController) {
        final String keyword = keywordField.getText().trim();
        final String diet = (String) dietComboBox.getSelectedItem();
        if (!keyword.isEmpty()) {
            try {
                dietLevelController.searchDietLevelRecipe(keyword, diet);
                mainFrame.showView("RecipeChoiceView");
                keywordField.setText("");
                dietComboBox.setSelectedIndex(0);
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
