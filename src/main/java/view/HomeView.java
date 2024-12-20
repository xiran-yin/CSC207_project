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

/**
 * The View for when the user open the program, the home view.
 */
public class HomeView extends JPanel {
    public static final int HEIGHT1 = 20;
    public static final int WIDTH1 = 400;
    public static final int HEIGHT2 = 65;
    private final MainFrame mainFrame;

    public HomeView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        final Color background = new Color(249, 249, 232);
        setBackground(background);

        final JButton randomRecipeButton = createStyledButton("Random Recipe");
        final JButton keywordSearchButton = createStyledButton("Search by Keyword");
        final JButton cuisineSearchButton = createStyledButton("Search by Cuisine Type");
        final JButton dietSearchButton = createStyledButton("Search by Diet Label");
        final JButton calorieSearchButton = createStyledButton("Search by Calories");

        // Add buttons to the panel
        add(Box.createVerticalGlue());

        add(keywordSearchButton);
        add(Box.createVerticalStrut(HEIGHT1));

        add(calorieSearchButton);
        add(Box.createVerticalStrut(HEIGHT1));

        add(cuisineSearchButton);
        add(Box.createVerticalStrut(HEIGHT1));

        add(dietSearchButton);
        add(Box.createVerticalStrut(HEIGHT1));

        add(randomRecipeButton);
        add(Box.createVerticalGlue());

        // Add action listeners to buttons
        keywordSearchButton.addActionListener(evt -> mainFrame.showView("KeywordSearchView"));
        cuisineSearchButton.addActionListener(evt -> mainFrame.showView("CuisineSearchView"));
        dietSearchButton.addActionListener(evt -> mainFrame.showView("DietSearchView"));
        calorieSearchButton.addActionListener(evt -> mainFrame.showView("CalorieSearchView"));
        randomRecipeButton.addActionListener(evt -> mainFrame.showView("RandomSearchView"));

    }

    private JButton createStyledButton(String text) {
        final JButton button = new JButton(text);

        // Style the button
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setBackground(Color.PINK);
        button.setPreferredSize(new Dimension(WIDTH1, HEIGHT2));
        button.setMaximumSize(new Dimension(WIDTH1, HEIGHT2));

        // Set background and word color
        button.setOpaque(true);
        final Color lightGreen = new Color(185, 224, 84);
        button.setBackground(lightGreen);
        button.setBorderPainted(false);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, HEIGHT1));

        return button;
    }
}
