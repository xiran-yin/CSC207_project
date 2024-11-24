package app;

import api.RecipeDataBase;
import api.getRecipeDataBase;
import interface_adapter.Keyword.KeywordController;
import interface_adapter.Keyword.KeywordPresenter;
import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.CuisineType.CuisineTypeOutputBoundary;
import usecase.DietLevel.DietLevelInteractor;
import usecase.DietLevel.DietLevelOutputBoundary;
import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordInteractor;
import usecase.CuisineType.CuisineTypeInteractor;
import usecase.Keyword.KeywordOutputBoundary;
import view.RecipeChoiceView;
import view.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        RecipeDataBase recipeDataBase = new getRecipeDataBase();

        // Create a temporary placeholder for RecipeChoiceView
        RecipeChoiceView recipeChoiceView = new RecipeChoiceView(null);

        KeywordPresenter keywordPresenter = new KeywordPresenter(recipeChoiceView);
        KeywordInteractor keywordInteractor = new KeywordInteractor(recipeDataBase, keywordPresenter);
        KeywordController keywordController = new KeywordController(keywordInteractor);

        // Create the Keyword and CuisineType Interactors
        CuisineTypeInteractor cuisineTypeInteractor = new CuisineTypeInteractor(recipeDataBase, recipeChoiceView);
        DietLevelInteractor dietLevelInteractor = new DietLevelInteractor(recipeDataBase,recipeChoiceView);

        // Create the MainFrame and assign it to RecipeChoiceView
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(keywordController, cuisineTypeInteractor, dietLevelInteractor, recipeChoiceView);
            recipeChoiceView.setMainFrame(mainFrame); // Link the MainFrame to RecipeChoiceView
            mainFrame.setVisible(true);
        });
    }


}
