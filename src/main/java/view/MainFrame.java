package view;

import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(KeywordInputBoundary inputBoundary, KeywordOutputBoundary outputBoundary) {
        setTitle("Recipe Finder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create Panels
        SearchView searchView = new SearchView(inputBoundary);
        RecipeChoiceView recipePanel = (RecipeChoiceView) outputBoundary;

        // Add Panels
        add(searchView, BorderLayout.NORTH);
        add(new JScrollPane(recipePanel), BorderLayout.CENTER);

        setVisible(true);
    }
}
