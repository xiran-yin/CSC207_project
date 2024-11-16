package app;

import api.RecipeDataBase;
import api.getRecipeDataBase;
import usecase.Keyword.KeywordInteractor;
import view.RecipeChoiceView;
import view.MainFrame;

public class Main {
    public static void main(String[] args) {
        // Initialize Dependencies
        RecipeDataBase recipeDataBase = new getRecipeDataBase();
        RecipeChoiceView recipePanel = new RecipeChoiceView();
        KeywordInteractor interactor = new KeywordInteractor(recipeDataBase, recipePanel);

        // Launch Main Frame
        new MainFrame(interactor, recipePanel);
    }
}
