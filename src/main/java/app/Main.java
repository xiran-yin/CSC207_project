package app;

import api.RecipeDataBase;
import api.getRecipeDataBase;
import interface_adapter.calories.CaloriesController;
import interface_adapter.cuisine_type.CuisineTypeController;
import interface_adapter.diet_level.DietLevelController;
import interface_adapter.keyword.KeywordController;
import interface_adapter.random.RandomController;
import usecase.calories.CaloriesInteractor;
import usecase.cuisine_type.CuisineTypeInteractor;
import usecase.diet_level.DietLevelInteractor;
import usecase.keyword.KeywordInteractor;
import usecase.random.RandomInteractor;
import view.RecipeChoiceView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        RecipeDataBase recipeDataBase = new getRecipeDataBase();

        // Create a temporary placeholder for RecipeChoiceView
        RecipeChoiceView recipeChoiceView = new RecipeChoiceView(null);

        KeywordController keywordController = new KeywordController(new KeywordInteractor(recipeChoiceView, recipeDataBase));
        DietLevelController dietLevelController = new DietLevelController(new DietLevelInteractor(recipeDataBase,recipeChoiceView));
        CuisineTypeController cuisineController = new CuisineTypeController(new CuisineTypeInteractor(recipeDataBase, recipeChoiceView));

        CaloriesController caloriesController = new CaloriesController(new CaloriesInteractor(recipeDataBase,recipeChoiceView));
        RandomController randomController = new RandomController(new RandomInteractor(recipeChoiceView, recipeDataBase));

        // Create the MainFrame and assign it to RecipeChoiceView
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame(keywordController, cuisineController,
                    recipeChoiceView, caloriesController, randomController, dietLevelController);
            recipeChoiceView.setMainFrame(mainFrame); // Link the MainFrame to RecipeChoiceView
            mainFrame.setVisible(true);
        });
    }

}
