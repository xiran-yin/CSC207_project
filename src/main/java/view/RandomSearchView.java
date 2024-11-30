package view;

import app.MainFrame;
import interface_adapter.random.RandomController;

import javax.swing.*;
import java.awt.*;

public class RandomSearchView extends JPanel{
    private JPanel recipePanel;
    private JButton searchButton;
    private JButton backButton;

    public RandomSearchView(MainFrame mainFrame, RandomController randomController) {
//        setBackground(new Color(255, 255, 238));
        setBackground(new Color(249, 249, 232));

        JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        searchPanel.setBackground(new Color(249, 249, 232));

        JButton searchButton = new JButton("Randomly Search");
        searchButton.setPreferredSize(new Dimension(100, 40));
        searchButton.setOpaque(true);
        searchButton.setBackground(new Color(185,224,84));
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));

        JButton backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.setOpaque(true);
        backButton.setBackground(new Color(185,224,84));
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));


        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(new Color(249, 249, 232));


        searchPanel.add(buttonPanel, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.NORTH);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10)); // Padding around search panel

        JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.setBackground(new Color(249, 249, 232));

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