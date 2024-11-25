package interface_adapter.Keyword;

import entity.Recipe;
import usecase.Keyword.KeywordOutputBoundary;
import usecase.Keyword.KeywordOutputData;
import view.RecipeChoiceView;

import java.util.List;

public class KeywordPresenter implements KeywordOutputBoundary {
    private final RecipeChoiceView recipeChoiceView;

    public KeywordPresenter(RecipeChoiceView recipeChoiceView) {
        this.recipeChoiceView = recipeChoiceView;
    }
    @Override
    public void presentRecipesKeyword(KeywordOutputData keywordOutputData) {
        List<Recipe> recipes = keywordOutputData.getRecipes();
        recipeChoiceView.setKeywordRecipes(recipes);
        recipeChoiceView.displayRecipes();

    }
}
