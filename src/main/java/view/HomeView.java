package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeView extends JPanel {
    private final MainFrame mainFrame;
    public HomeView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
//        setLayout(new GridLayout(5, 1, 10, 10)); // 5 buttons in a vertical layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton randomRecipeButton = createStyledButton("Random Recipe");
        JButton keywordSearchButton = createStyledButton("Search by Keyword");
        JButton cuisineSearchButton = createStyledButton("Search by Cuisine Type");
        JButton dietSearchButton = createStyledButton("Search by Diet Label");
        JButton calorieSearchButton = createStyledButton("Search by Calories");


        // Add buttons to the panel
        add(Box.createVerticalGlue());

        add(randomRecipeButton);
        add(Box.createVerticalStrut(20)); // Space between buttons

        add(keywordSearchButton);
        add(Box.createVerticalStrut(20)); // Space between buttons

        add(cuisineSearchButton);
        add(Box.createVerticalStrut(20)); // Space between buttons

        add(dietSearchButton);
        add(Box.createVerticalStrut(20)); // Space between buttons

        add(calorieSearchButton);
        add(Box.createVerticalGlue());

        // Add action listeners to buttons
        keywordSearchButton.addActionListener(e -> mainFrame.showView("KeywordSearchView"));
        cuisineSearchButton.addActionListener(e -> mainFrame.showView("CuisineSearchView"));
        dietSearchButton.addActionListener(e -> mainFrame.showView("DietSearchView"));
        calorieSearchButton.addActionListener(e -> mainFrame.showView("CalorieSearchView"));
        randomRecipeButton.addActionListener(e -> mainFrame.showView("RandomSearchView"));

    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);

        // Style the button
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setPreferredSize(new Dimension(200, 40)); // Button size
        button.setMaximumSize(new Dimension(200, 40)); // Prevents resizing

        // Add action listener to navigate to views
        return button;
    }
}
