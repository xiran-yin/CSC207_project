package usecase.keyword;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import api.RecipeDataBase;
import entity.Recipe;

/**
 * The Keyword Search Interactor.
 */
public class KeywordInteractor implements KeywordInputBoundary {
    private final RecipeDataBase recipeDataBase;
    private final KeywordOutputBoundary keywordPresenter;

    public KeywordInteractor(KeywordOutputBoundary keywordOutputBoundary, RecipeDataBase recipeDataBase) {
        this.keywordPresenter = keywordOutputBoundary;
        this.recipeDataBase = recipeDataBase;
    }

    @Override
    public void searchKeywordRecipe(KeywordInputData keywordInputData) {
        try {
            System.out.println("Fetching recipes for keyword: " + keywordInputData.getKeyword());
            final List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    keywordInputData.getKeyword(), null, null, 0, 0
            );
            System.out.println("Recipes retrieved: " + recipes);
            keywordPresenter.presentRecipesKeyword(new KeywordOutputData(recipes));
        }
        catch (IOException ex) {
            ex.printStackTrace();
            keywordPresenter.presentRecipesKeyword(new KeywordOutputData(Collections.emptyList()));
        }

    }
}
