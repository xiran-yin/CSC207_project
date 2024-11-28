package view;

import interface_adapter.Random.RandomController;

import javax.swing.*;
import java.awt.*;

public class RandomSearchView extends JPanel{
    private JPanel recipePanel;
    private JButton searchButton;
    private JButton backButton;

    public RandomSearchView(MainFrame mainFrame, RandomController randomController) {
        setBackground(new Color(255, 255, 238));

        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        JButton searchButton = new JButton("Randomly Search");
        searchButton.setPreferredSize(new Dimension(100, 50));
        searchButton.setOpaque(true);
        searchButton.setBackground(new Color(190,232,95));
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setOpaque(true);
        backButton.setBackground(new Color(190,232,95));
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));


        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        searchPanel.add(buttonPanel, BorderLayout.CENTER);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10)); // Padding around search panel

        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);

        setLayout(new BorderLayout());
        add(combinedPanel, BorderLayout.NORTH);

        searchButton.addActionListener(e ->  {
            randomController.execute();
            RecipeChoiceView recipeChoiceView = (RecipeChoiceView) recipePanel;
            mainFrame.showView("RecipeChoiceView");
        });

        backButton.addActionListener(e -> mainFrame.showView("HomeView"));
    }
}