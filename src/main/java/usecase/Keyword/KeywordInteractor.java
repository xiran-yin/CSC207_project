package usecase.Keyword;

import api.RecipeDataBase;
import entity.Recipe;

import java.util.Collections;
import java.util.List;

public class KeywordInteractor implements KeywordInputBoundary{
    private final RecipeDataBase recipeDataBase;
    private final KeywordOutputBoundary keywordOutputBoundary;

    public KeywordInteractor(RecipeDataBase recipeDataBase, KeywordOutputBoundary keywordOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.keywordOutputBoundary = keywordOutputBoundary;
    }

    @Override
    public void searchKeywordRecipe(KeywordInputData keywordInputData) {
        try {
            List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    keywordInputData.getKeyword(), null, null, 0, 0
            );
            KeywordOutputData keywordOutputData = new KeywordOutputData(recipes);
            keywordOutputBoundary.presentRecipesKeyword(keywordOutputData);
        } catch (Exception e) {
            e.printStackTrace();
            keywordOutputBoundary.presentRecipesKeyword(new KeywordOutputData(Collections.emptyList()));
        }

    }
}
