package app;

import api.RecipeDataBase;
import api.getRecipeDataBase;
import usecase.DietLevel.DietLevelInteractor;
import usecase.Keyword.KeywordInteractor;
import usecase.CuisineType.CuisineTypeInteractor;
import view.RecipeChoiceView;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        // Initialize Dependencies
        RecipeDataBase recipeDataBase = new getRecipeDataBase();
        RecipeChoiceView recipePanel = new RecipeChoiceView();

        KeywordInteractor keywordInteractor = new KeywordInteractor(recipeDataBase, recipePanel);
        CuisineTypeInteractor cuisineInteractor = new CuisineTypeInteractor(recipeDataBase, recipePanel);
        DietLevelInteractor dietInteractor = new DietLevelInteractor(recipeDataBase, recipePanel);

        // Launch Main Frame
        new MainFrame(keywordInteractor, cuisineInteractor, dietInteractor, recipePanel);
    }
}
