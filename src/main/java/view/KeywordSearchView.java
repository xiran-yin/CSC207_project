package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.MainFrame;
import interface_adapter.keyword.KeywordController;

/**
 * The View for when the user is used the Keyword Search of the program.
 */
public class KeywordSearchView extends JPanel {
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

        final JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        final JPanel searchBarPanel = new JPanel(new BorderLayout());
        searchBarPanel.add(keywordField, BorderLayout.CENTER);
        searchBarPanel.add(buttonPanel, BorderLayout.EAST);
        searchBarPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10));

        add(searchBarPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(evt -> {
            final String keyword = keywordField.getText().trim();
            if (!keyword.isEmpty()) {
                try {
                    controller.keywordRecipes(keyword);
                    mainFrame.showView("RecipeChoiceView");

                }
                catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(this, "Please enter a valid keyword.");
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Please enter a keyword.");
            }
        });

        // Back button action
        backButton.addActionListener(evt -> mainFrame.showView("HomeView"));
    }
}
