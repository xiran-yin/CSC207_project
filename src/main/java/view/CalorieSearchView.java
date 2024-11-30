package view;

import java.awt.*;

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
        setBackground(new Color(249, 249, 232));

        final JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
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

        final JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(new Color(249, 249, 232));

        searchPanel.add(keywordField, BorderLayout.CENTER);
        searchPanel.add(buttonPanel, BorderLayout.EAST);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10)); // Padding around search panel
        searchPanel.setBackground(new Color(249, 249, 232));

        // Setup for the calories input panel
        final JPanel caloriePanel = new JPanel(new GridLayout(1, 2, 10, 10)); // GridLayout for min and max calories input
        minCaloriesField = new JTextField();
        minCaloriesField.setPreferredSize(new Dimension(100, 40));
        minCaloriesField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        minCaloriesField.setBorder(BorderFactory.createTitledBorder("Minimum Calories"));

        maxCaloriesField = new JTextField();
        maxCaloriesField.setPreferredSize(new Dimension(100, 40));
        maxCaloriesField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        maxCaloriesField.setBorder(BorderFactory.createTitledBorder("Maximum Calories"));

        // Add both fields to the caloriePanel
        caloriePanel.add(minCaloriesField);
        caloriePanel.add(maxCaloriesField);
        caloriePanel.setBackground(new Color(249, 249, 232));

        // Combine searchPanel and caloriePanel into a single panel
        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.add(caloriePanel);
        caloriePanel.setBackground(new Color(249, 249, 232));

        // Add combined panel to the main layout
        setLayout(new BorderLayout());
        add(combinedPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(evt -> {
            handelCaloriesSearch(mainFrame, caloriesController);
        });

        // Back button action
        backButton.addActionListener(evt -> mainFrame.showView("HomeView"));
    }

    private void handelCaloriesSearch(MainFrame mainFrame, CaloriesController caloriesController) {
        final String keyword = keywordField.getText().trim();
        final String minCalories = minCaloriesField.getText().trim();
        final String maxCalories = maxCaloriesField.getText().trim();

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
    }
}