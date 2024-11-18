package view;

import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.CuisineType.CuisineTypeOutputBoundary;
import usecase.DietLevel.DietLevelInputBoundary;
import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordOutputBoundary;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(KeywordInputBoundary keywordInputBoundary, CuisineTypeInputBoundary cuisineInputBoundary,
                     DietLevelInputBoundary dietLevelInputBoundary, KeywordOutputBoundary keywordOutputBoundary) {
        setTitle("Recipe Finder");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create Panels
        RecipeChoiceView recipePanel = (RecipeChoiceView) keywordOutputBoundary;
        SearchView searchView = new SearchView(keywordInputBoundary, cuisineInputBoundary, dietLevelInputBoundary,
                recipePanel);

        // Add Panels
        add(searchView, BorderLayout.NORTH);
        add(new JScrollPane(recipePanel), BorderLayout.CENTER);

        setVisible(true);
    }
}
