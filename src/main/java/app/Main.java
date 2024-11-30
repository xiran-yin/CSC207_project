package app;

import javax.swing.SwingUtilities;

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

/**
 * The Main class of our application.
 */
public class Main {

    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        final RecipeDataBase recipeDataBase = new getRecipeDataBase();

        // Create a temporary placeholder for RecipeChoiceView
        final RecipeChoiceView recipeChoiceView = new RecipeChoiceView(null);

        final KeywordController keywordController = new KeywordController(
                new KeywordInteractor(recipeChoiceView, recipeDataBase));
        final DietLevelController dietLevelController = new DietLevelController(
                new DietLevelInteractor(recipeDataBase, recipeChoiceView));
        final CuisineTypeController cuisineController = new CuisineTypeController(
                new CuisineTypeInteractor(recipeDataBase, recipeChoiceView));
        final CaloriesController caloriesController = new CaloriesController(
                new CaloriesInteractor(recipeDataBase, recipeChoiceView));
        final RandomController randomController = new RandomController(
                new RandomInteractor(recipeChoiceView, recipeDataBase));

        // Create the MainFrame and assign it to RecipeChoiceView
        SwingUtilities.invokeLater(() -> {
            final MainFrame mainFrame = new MainFrame(keywordController, cuisineController,
                    recipeChoiceView, caloriesController, randomController, dietLevelController);
            recipeChoiceView.setMainFrame(mainFrame);
            mainFrame.setVisible(true);
        });
    }
}
