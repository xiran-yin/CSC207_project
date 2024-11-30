package view;

import app.MainFrame;
import interface_adapter.keyword.KeywordController;

import javax.swing.*;
import java.awt.*;public class KeywordSearchView extends JPanel {
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;
    private KeywordController controller;

    public KeywordSearchView(KeywordController controller, MainFrame mainFrame) {

        setLayout(new BorderLayout());
        setBackground(new Color(249, 249, 232));

        // Search bar setup
        keywordField = new JTextField();
        searchButton = new JButton("Go");
        backButton = new JButton("Back");
        keywordField.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));

        searchButton.setOpaque(true);
        searchButton.setBackground(new Color(185,224,84));
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        searchButton.setPreferredSize(new Dimension(80, 30));

        backButton.setOpaque(true);
        backButton.setBackground(new Color(185,224,84));
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(80, 30));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(new Color(249, 249, 232));

        JPanel searchBarPanel = new JPanel(new BorderLayout());
        searchBarPanel.setBackground(new Color(249, 249, 232));
        searchBarPanel.add(keywordField, BorderLayout.CENTER);
        searchBarPanel.add(buttonPanel, BorderLayout.EAST);
        searchBarPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10));

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
