package app;

import api.RecipeDataBase;
import api.getRecipeDataBase;
import usecase.Keyword.KeywordInteractor;
import usecase.CuisineType.CuisineTypeInteractor;
import usecase.Random.RandomInteractor;
import view.RecipeChoiceView;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        // Initialize Dependencies
        RecipeDataBase recipeDataBase = new getRecipeDataBase();
        RecipeChoiceView recipePanel = new RecipeChoiceView();

        KeywordInteractor keywordInteractor = new KeywordInteractor(recipeDataBase, recipePanel);
        CuisineTypeInteractor cuisineInteractor = new CuisineTypeInteractor(recipeDataBase, recipePanel);
        RandomInteractor randomInteractor = new RandomInteractor(recipeDataBase, recipePanel);

        // Launch Main Frame
        new MainFrame(keywordInteractor, cuisineInteractor, randomInteractor, recipePanel);
    }
}
