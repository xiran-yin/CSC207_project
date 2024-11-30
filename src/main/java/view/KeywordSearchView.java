package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

    public KeywordSearchView(KeywordController controller, MainFrame mainFrame) {

        setLayout(new BorderLayout());
        setBackground(new Color(249, 249, 232));

        // Search bar setup
        keywordField = new JTextField();
        searchButton = new JButton("Go");
        backButton = new JButton("Back");
        final String font = "Comic Sans MS";
        keywordField.setFont(new Font(font, Font.PLAIN, 16));

        searchButton.setOpaque(true);
        searchButton.setBackground(new Color(185, 224, 84));
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font(font, Font.BOLD, 16));
        searchButton.setPreferredSize(new Dimension(80, 30));

        backButton.setOpaque(true);
        backButton.setBackground(new Color(185, 224, 84));
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font(font, Font.BOLD, 16));
        backButton.setPreferredSize(new Dimension(80, 30));

        final JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(new Color(249, 249, 232));

        final JPanel searchBarPanel = new JPanel(new BorderLayout());
        searchBarPanel.add(keywordField, BorderLayout.CENTER);
        searchBarPanel.add(buttonPanel, BorderLayout.EAST);
        searchBarPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10));

        add(searchBarPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(evt -> {
            handleKeywordSearch(mainFrame, controller);
        });

        // Back button action
        backButton.addActionListener(evt -> mainFrame.showView("HomeView"));
    }

    private void handleKeywordSearch(MainFrame mainFrame, KeywordController controller) {
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
    }
}
