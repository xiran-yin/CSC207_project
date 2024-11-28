package app;

import api.RecipeDataBase;
import api.getRecipeDataBase;
import interface_adapter.Calories.CaloriesController;
import interface_adapter.Calories.CaloriesPresenter;
import interface_adapter.DietLevel.DietLevelController;
import interface_adapter.Random.RandomController;
import usecase.Calories.CaloriesInteractor;
import interface_adapter.CuisineType.CuisineTypePresenter;
import interface_adapter.Keyword.KeywordController;
import interface_adapter.Keyword.KeywordPresenter;
import interface_adapter.CuisineType.CuisineTypeController;
import usecase.DietLevel.DietLevelInteractor;
import usecase.Keyword.KeywordInteractor;
import usecase.CuisineType.CuisineTypeInteractor;
import usecase.Random.RandomInteractor;
import view.RecipeChoiceView;
import view.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        RecipeDataBase recipeDataBase = new getRecipeDataBase();

        // Create a temporary placeholder for RecipeChoiceView
        RecipeChoiceView recipeChoiceView = new RecipeChoiceView(null);

        KeywordController keywordController = new KeywordController(new KeywordInteractor(recipeDataBase, recipeChoiceView));
        DietLevelController dietLevelController = new DietLevelController(new DietLevelInteractor(recipeDataBase,recipeChoiceView));
        CuisineTypeController cuisineController = new CuisineTypeController(new CuisineTypeInteractor(recipeDataBase, recipeChoiceView));

        CaloriesController caloriesController = new CaloriesController(new CaloriesInteractor(recipeDataBase,recipeChoiceView));
        RandomController randomController = new RandomController(new RandomInteractor(recipeDataBase, recipeChoiceView));

        // Create the MainFrame and assign it to RecipeChoiceView
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(keywordController, cuisineController,
                    recipeChoiceView, caloriesController, randomController, dietLevelController);
            recipeChoiceView.setMainFrame(mainFrame); // Link the MainFrame to RecipeChoiceView
            mainFrame.setVisible(true);
        });
    }

}
