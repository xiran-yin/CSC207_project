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
    public static final int FONTSIZE = 16;
    public static final int TOP = 200;
    public static final int LEFT = 10;
    private JTextField keywordField;
    private JButton searchButton;
    private JButton backButton;

    public KeywordSearchView(KeywordController controller, MainFrame mainFrame) {

        setLayout(new BorderLayout());
        final Color background = new Color(249, 249, 232);
        setBackground(background);

        // Search bar setup
        keywordField = new JTextField();
        searchButton = new JButton("Go");
        backButton = new JButton("Back");
        final String font = "Comic Sans MS";
        keywordField.setFont(new Font(font, Font.PLAIN, FONTSIZE));

        searchButton.setOpaque(true);
        final Color lightGreen = new Color(185, 224, 84);
        searchButton.setBackground(lightGreen);
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font(font, Font.BOLD, FONTSIZE));
        final Dimension preferredSize = new Dimension(80, 30);
        searchButton.setPreferredSize(preferredSize);

        backButton.setOpaque(true);
        backButton.setBackground(lightGreen);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font(font, Font.BOLD, FONTSIZE));
        backButton.setPreferredSize(preferredSize);

        final JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, LEFT));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(background);

        final JPanel searchBarPanel = new JPanel(new BorderLayout());
        searchBarPanel.add(keywordField, BorderLayout.CENTER);
        searchBarPanel.add(buttonPanel, BorderLayout.EAST);
        searchBarPanel.setBorder(BorderFactory.createEmptyBorder(TOP, LEFT, LEFT, LEFT));
        searchBarPanel.setBackground(background);

        add(searchBarPanel, BorderLayout.NORTH);

        // Search button action
        searchButton.addActionListener(evt -> handleKeywordSearch(mainFrame, controller));

        // Back button action
        backButton.addActionListener(evt -> {
            keywordField.setText("");
            mainFrame.showView("HomeView");
        });
    }

    private void handleKeywordSearch(MainFrame mainFrame, KeywordController controller) {
        final String keyword = keywordField.getText().trim();
        if (!keyword.isEmpty()) {
            try {
                controller.keywordRecipes(keyword);
                mainFrame.showView("RecipeChoiceView");
                keywordField.setText("");
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
