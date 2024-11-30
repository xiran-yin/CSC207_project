package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.MainFrame;
import entity.CaloriesRange;
import interface_adapter.calories.CaloriesController;

/**
 * The View for when the user is used the Calories Filter in the program.
 */
public class CalorieSearchView extends JPanel {
    private JTextField keywordField;
    private JTextField minCaloriesField;
    private JTextField maxCaloriesField;
    private JButton searchButton;
    private JButton backButton;

    public CalorieSearchView(MainFrame mainFrame, CaloriesController caloriesController) {
        // Setup for the search bar
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

        // Setup for the calories input panel
        final JPanel caloriePanel = new JPanel(new GridLayout(1, 2, 10, 10));
        minCaloriesField = new JTextField();
        minCaloriesField.setPreferredSize(new Dimension(100, 40));
        minCaloriesField.setFont(new Font("Arial", Font.PLAIN, 16));
        minCaloriesField.setBorder(BorderFactory.createTitledBorder("Minimum Calories"));

        maxCaloriesField = new JTextField();
        maxCaloriesField.setPreferredSize(new Dimension(100, 40));
        maxCaloriesField.setFont(new Font("Arial", Font.PLAIN, 16));
        maxCaloriesField.setBorder(BorderFactory.createTitledBorder("Maximum Calories"));

        // Add both fields to the caloriePanel
        caloriePanel.add(minCaloriesField);
        caloriePanel.add(maxCaloriesField);

        // Combine searchPanel and caloriePanel into a single panel
        final JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(caloriePanel);

        // Add combined panel to the main layout
        setLayout(new BorderLayout());
        add(combinedPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(evt -> {
            String keyword = keywordField.getText().trim();
            String minCalories = minCaloriesField.getText().trim();
            String maxCalories = maxCaloriesField.getText().trim();

            if (!minCalories.isEmpty() && !maxCalories.isEmpty()) {
                try {
                    final int minCal = Integer.parseInt(minCalories);
                    final int maxCal = Integer.parseInt(maxCalories);
                    final CaloriesRange caloriesRange = new CaloriesRange(minCal, maxCal);

                    if (!keyword.isEmpty()) {
                        caloriesController.execute(keyword, caloriesRange);
                        mainFrame.showView("RecipeChoiceView");
                    }
                    else {
                        JOptionPane.showMessageDialog(this, "Please enter a keyword.");
                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter valid calorie values.");
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Please enter both minimum and maximum calorie values.");
            }
        });

        // Back button action
        backButton.addActionListener(evt -> mainFrame.showView("HomeView"));
    }
}
