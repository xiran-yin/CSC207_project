package interface_adapter.Keyword;

import entity.Recipe;
import usecase.Keyword.KeywordOutputBoundary;
import usecase.Keyword.KeywordOutputData;
import view.RecipeChoiceView;

import java.util.List;

public class KeywordPresenter implements KeywordOutputBoundary {
    private final KeywordViewModel keywordViewModel;

    public KeywordPresenter(KeywordViewModel keywordViewModel) {
        this.keywordViewModel = keywordViewModel;
    }
    @Override
    public void presentRecipesKeyword(KeywordOutputData keywordOutputData) {
        List<Recipe> recipes = keywordOutputData.getRecipes();
        keywordViewModel.setRecipeNames(recipes);
        keywordViewModel.setLoading(false);

    }
}
