package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import app.MainFrame;
import interface_adapter.random.RandomController;

/**
 * The View for when the user is used the Random generator in the program.
 */
public class RandomSearchView extends JPanel {
    public static final int SIZE = 20;
    public static final int TOP = 200;
    public static final int LEFT = 10;
    private JButton searchButton;
    private JButton backButton;

    public RandomSearchView(MainFrame mainFrame, RandomController randomController) {
        final Color background = new Color(249, 249, 232);
        setBackground(background);

        final JPanel searchPanel = new JPanel(new BorderLayout(LEFT, LEFT));
        searchPanel.setBackground(background);

        searchButton = new JButton("Randomly Search");
        final Dimension preferredSize = new Dimension(100, 40);
        searchButton.setPreferredSize(preferredSize);
        searchButton.setOpaque(true);
        final Color lightGreen = new Color(185, 224, 84);
        searchButton.setBackground(lightGreen);
        searchButton.setBorderPainted(false);
        searchButton.setForeground(Color.WHITE);
        searchButton.setFont(new Font("Comic Sans MS", Font.BOLD, SIZE));

        backButton = new JButton("Back");
        backButton.setPreferredSize(preferredSize);
        backButton.setOpaque(true);
        backButton.setBackground(lightGreen);
        backButton.setBorderPainted(false);
        backButton.setForeground(Color.white);
        backButton.setFont(new Font("Comic Sans MS", Font.BOLD, SIZE));

        final JPanel buttonPanel = new JPanel(new GridLayout(2, 1, LEFT, LEFT));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);
        buttonPanel.setBackground(background);

        searchPanel.add(buttonPanel, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.NORTH);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(TOP, LEFT, LEFT, LEFT));

        final JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);
        combinedPanel.setBackground(background);

        setLayout(new BorderLayout());
        add(combinedPanel, BorderLayout.NORTH);

        searchButton.addActionListener(evt -> {
            randomController.execute();
            mainFrame.showView("RecipeChoiceView");
        });

        backButton.addActionListener(evt -> mainFrame.showView("HomeView"));
    }
}
