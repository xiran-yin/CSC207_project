package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import app.MainFrame;
import javax.swing.*;
import java.awt.*;

/**
 * The View for when the user open the program, the home view.
 */
public class HomeView extends JPanel {
    private final MainFrame mainFrame;

    public HomeView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
//        setLayout(new GridLayout(5, 1, 10, 10)); // 5 buttons in a vertical layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        setBackground(new Color(255, 245, 238));
        setBackground(new Color(249, 249, 232));

        final JButton randomRecipeButton = createStyledButton("Random Recipe");
        final JButton keywordSearchButton = createStyledButton("Search by Keyword");
        final JButton cuisineSearchButton = createStyledButton("Search by Cuisine Type");
        final JButton dietSearchButton = createStyledButton("Search by Diet Label");
        final JButton calorieSearchButton = createStyledButton("Search by Calories");


        // Add buttons to the panel
        add(Box.createVerticalGlue());

        add(keywordSearchButton);
        add(Box.createVerticalStrut(20)); // Space between buttons

        add(calorieSearchButton);
        add(Box.createVerticalStrut(20));

        add(cuisineSearchButton);
        add(Box.createVerticalStrut(20)); // Space between buttons

        add(dietSearchButton);
        add(Box.createVerticalStrut(20)); // Space between buttons

        add(randomRecipeButton);
        add(Box.createVerticalGlue());

        // Add action listeners to buttons
        keywordSearchButton.addActionListener(e -> mainFrame.showView("KeywordSearchView"));
        cuisineSearchButton.addActionListener(e -> mainFrame.showView("CuisineSearchView"));
        dietSearchButton.addActionListener(e -> mainFrame.showView("DietSearchView"));
        calorieSearchButton.addActionListener(e -> mainFrame.showView("CalorieSearchView"));
        randomRecipeButton.addActionListener(e -> mainFrame.showView("RandomSearchView"));

    }

    private JButton createStyledButton(String text) {
        final JButton button = new JButton(text);

        // Style the button
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(Color.PINK);
        button.setPreferredSize(new Dimension(400, 65)); // Button size
        button.setMaximumSize(new Dimension(400, 65)); // Prevents resizing

        // Set background and word color
        button.setOpaque(true);
        button.setBackground(new Color(185,224,84));
//        button.setBackground(new Color(247, 185, 195));
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        // Add action listener to navigate to views
        return button;
    }
}
