package interface_adapter.Keyword;

import view.MainFrame;

import javax.swing.*;
import java.awt.*;public class KeywordSearchView extends JPanel {
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;
    private KeywordController controller;

    public KeywordSearchView(KeywordController controller, MainFrame mainFrame) {

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

        // Search button action
        searchButton.addActionListener(e -> {
            String keyword = keywordField.getText().trim();
            if (!keyword.isEmpty()) {
                try {
                    controller.keywordRecipes(keyword);
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
