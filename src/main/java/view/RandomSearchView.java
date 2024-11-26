package view;

import interface_adapter.Random.RandomController;

import javax.swing.*;
import java.awt.*;

public class RandomSearchView extends JPanel{
    private JPanel recipePanel;
    private JButton searchButton;
    private JButton backButton;

    public RandomSearchView(MainFrame mainFrame, RandomController randomController) {
        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        JButton searchButton = new JButton("Randomly Search");
        searchButton.setPreferredSize(new Dimension(100, 50));
        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 50));

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