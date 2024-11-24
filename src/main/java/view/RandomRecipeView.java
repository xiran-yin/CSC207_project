package view;

import usecase.Random.RandomInputBoundary;
import usecase.Random.RandomInputData;

import javax.swing.*;
import java.awt.*;

public class RandomRecipeView extends JPanel{
    private JPanel recipePanel;
    private JButton searchButton;
    private JButton backButton;

    public RandomRecipeView(MainFrame mainFrame, RandomInputBoundary randomInputBoundary, JPanel cardPanel) {
        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        JButton searchButton = new JButton("Randomly Search");
        JButton backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        searchPanel.add(buttonPanel, BorderLayout.CENTER);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Padding around search panel

        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);

        setLayout(new BorderLayout());
        add(combinedPanel, BorderLayout.NORTH);

        searchButton.addActionListener(e ->  {
            randomInputBoundary.searchRandomRecipe(new RandomInputData());
            RecipeChoiceView recipeChoiceView = (RecipeChoiceView) recipePanel;
            mainFrame.showView("RecipeChoiceView");
        });

        backButton.addActionListener(e -> mainFrame.showView("HomeView"));
    }
}