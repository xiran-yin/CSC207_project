package usecase.keyword;

import api.RecipeDataBase;
import entity.Recipe;
import interface_adapter.keyword.KeywordViewModel;

import java.util.Collections;
import java.util.List;

public class KeywordInteractor implements KeywordInputBoundary{
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
            List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    keywordInputData.getKeyword(), null, null, 0, 0
            );
            System.out.println("Recipes retrieved: " + recipes);
            keywordPresenter.presentRecipesKeyword(new KeywordOutputData(recipes));
        } catch (Exception e) {
            e.printStackTrace();
            keywordPresenter.presentRecipesKeyword(new KeywordOutputData(Collections.emptyList()));
        }

    }
}
