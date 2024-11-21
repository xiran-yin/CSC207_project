package interface_adapter.Keyword;

import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordInputData;
import usecase.Keyword.KeywordOutputBoundary;
import view.MainFrame;
import view.RecipeChoiceView;

import javax.swing.*;
import java.awt.*;public class KeywordSearchView extends JPanel {
    private final KeywordInputBoundary keywordInputBoundary;
    private JPanel recipePanel;
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;

    public KeywordSearchView(MainFrame mainFrame, KeywordInputBoundary keywordInputBoundary, RecipeChoiceView recipePanel) {
        this.keywordInputBoundary = keywordInputBoundary;
        this.recipePanel = recipePanel;

        setLayout(new BorderLayout());

        // Search bar setup
        keywordField = new JTextField();
        searchButton = new JButton("Go");
        backButton = new JButton("Back");

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        JPanel searchBarPanel = new JPanel(new BorderLayout());
        searchBarPanel.add(keywordField, BorderLayout.CENTER);
        searchBarPanel.add(buttonPanel, BorderLayout.EAST);

        add(searchBarPanel, BorderLayout.NORTH);

        // Add RecipeChoiceView below the search bar
//        JScrollPane scrollPane = new JScrollPane(recipePanel);
//        add(scrollPane, BorderLayout.CENTER);

        // Search button action
        searchButton.addActionListener(e -> {
            String keyword = keywordField.getText().trim();
            if (!keyword.isEmpty()) {
                try {
                    keywordInputBoundary.searchKeywordRecipe(new KeywordInputData(keyword));
                    RecipeChoiceView recipeChoiceView = (RecipeChoiceView) recipePanel;
                    mainFrame.showView("RecipeChoiceView");

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid keyword.");


                                    }
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a keyword.");
            }
        });

        // Back button action
        backButton.addActionListener(e -> mainFrame.showView("HomeView"));

    }


}
