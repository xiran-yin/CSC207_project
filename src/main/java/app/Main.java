package app;

import api.RecipeDataBase;
import api.getRecipeDataBase;
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
//    public static void main(String[] args) {
//        // Initialize Dependencies
//        RecipeDataBase recipeDataBase = new getRecipeDataBase();
//        RecipeChoiceView recipePanel = new RecipeChoiceView();
//
//        KeywordInteractor keywordInteractor = new KeywordInteractor(recipeDataBase, recipePanel);
//        CuisineTypeInteractor cuisineInteractor = new CuisineTypeInteractor(recipeDataBase, recipePanel);
//
//        // Launch Main Frame
//        new MainFrame(keywordInteractor, cuisineInteractor, recipePanel);
//    }

//    public static void main(String[] args) {
//        RecipeDataBase recipeDataBase = new getRecipeDataBase();
//
//        RecipeChoiceView recipeChoiceView = new RecipeChoiceView();
//
//        KeywordInteractor keywordInteractor = new KeywordInteractor(recipeDataBase, recipeChoiceView);
//        CuisineTypeInteractor cuisineTypeInteractor = new CuisineTypeInteractor(recipeDataBase, recipeChoiceView);
//
//        SwingUtilities.invokeLater(() -> {
//            new MainFrame(keywordInteractor, cuisineTypeInteractor, recipeChoiceView);
//
//        });
//    }

    public static void main(String[] args) {
        RecipeDataBase recipeDataBase = new getRecipeDataBase();

        // Create a temporary placeholder for RecipeChoiceView
        RecipeChoiceView recipeChoiceView = new RecipeChoiceView(null);

        // Create the Keyword and CuisineType Interactors
        KeywordInteractor keywordInteractor = new KeywordInteractor(recipeDataBase, recipeChoiceView);
        CuisineTypeInteractor cuisineTypeInteractor = new CuisineTypeInteractor(recipeDataBase, recipeChoiceView);
        DietLevelInteractor dietLevelInteractor = new DietLevelInteractor(recipeDataBase,recipeChoiceView);

        // Create the MainFrame and assign it to RecipeChoiceView
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(keywordInteractor, cuisineTypeInteractor, dietLevelInteractor, recipeChoiceView);
            recipeChoiceView.setMainFrame(mainFrame); // Link the MainFrame to RecipeChoiceView
            mainFrame.setVisible(true);
        });
    }


}
