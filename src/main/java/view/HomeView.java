package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class HomeView extends JPanel {
    private final MainFrame mainFrame;
    public HomeView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(5, 1, 10, 10)); // 5 buttons in a vertical layout

        // Create buttons for different search views
        JButton randomRecipeButton = new JButton("Random Recipe");
        JButton keywordSearchButton = new JButton("Search by Keyword");
        JButton cuisineSearchButton = new JButton("Search by Cuisine Type");
        JButton dietSearchButton = new JButton("Search by Diet Label");
        JButton calorieSearchButton = new JButton("Search by Calories");

        // Add action listeners to buttons
        keywordSearchButton.addActionListener(e -> mainFrame.showView("KeywordSearchView"));
        cuisineSearchButton.addActionListener(e -> mainFrame.showView("CuisineSearchView"));
        dietSearchButton.addActionListener(e -> mainFrame.showView("DietSearchView"));
        calorieSearchButton.addActionListener(e -> mainFrame.showView("CalorieSearchView"));


        // Add buttons to the panel
        add(randomRecipeButton);
        add(keywordSearchButton);
        add(cuisineSearchButton);
        add(dietSearchButton);
        add(calorieSearchButton);
    }
}
