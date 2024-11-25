package app;

import api.RecipeDataBase;
import api.getRecipeDataBase;
import interface_adapter.Calories.CaloriesController;
import interface_adapter.Random.RandomController;
import usecase.Calories.CaloriesInteractor;
import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.CuisineType.CuisineTypeOutputBoundary;
import usecase.DietLevel.DietLevelInteractor;
import usecase.DietLevel.DietLevelOutputBoundary;
import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordInteractor;
import usecase.CuisineType.CuisineTypeInteractor;
import usecase.Keyword.KeywordOutputBoundary;
import usecase.Random.RandomInteractor;
import view.RecipeChoiceView;
import view.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        RecipeDataBase recipeDataBase = new getRecipeDataBase();

        // Create a temporary placeholder for RecipeChoiceView
        RecipeChoiceView recipeChoiceView = new RecipeChoiceView(null);

        // Create the Keyword and CuisineType Interactors
        KeywordInteractor keywordInteractor = new KeywordInteractor(recipeDataBase, recipeChoiceView);
        CuisineTypeInteractor cuisineTypeInteractor = new CuisineTypeInteractor(recipeDataBase, recipeChoiceView);
        DietLevelInteractor dietLevelInteractor = new DietLevelInteractor(recipeDataBase,recipeChoiceView);
        CaloriesController caloriesController = new CaloriesController(new CaloriesInteractor(recipeDataBase,recipeChoiceView));
        RandomController randomController = new RandomController(new RandomInteractor(recipeDataBase, recipeChoiceView));

        // Create the MainFrame and assign it to RecipeChoiceView
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(keywordInteractor, cuisineTypeInteractor, dietLevelInteractor, recipeChoiceView, caloriesController, randomController);
            recipeChoiceView.setMainFrame(mainFrame); // Link the MainFrame to RecipeChoiceView
            mainFrame.setVisible(true);
        });
    }


}
