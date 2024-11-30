package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
    private JButton searchButton;
    private JButton backButton;

    public RandomSearchView(MainFrame mainFrame, RandomController randomController) {
        final JPanel searchPanel = new JPanel(new BorderLayout(10, 10));
        searchButton = new JButton("Randomly Search");
        searchButton.setPreferredSize(new Dimension(100, 50));
        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 50));

        final JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        searchPanel.add(buttonPanel, BorderLayout.CENTER);
        searchPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10));

        final JPanel combinedPanel = new JPanel();
        combinedPanel.setLayout(new BoxLayout(combinedPanel, BoxLayout.Y_AXIS));
        combinedPanel.add(searchPanel);

        setLayout(new BorderLayout());
        add(combinedPanel, BorderLayout.NORTH);

        searchButton.addActionListener(evt -> {
            randomController.execute();
            mainFrame.showView("RecipeChoiceView");
        });

        backButton.addActionListener(evt -> mainFrame.showView("HomeView"));
    }
}
