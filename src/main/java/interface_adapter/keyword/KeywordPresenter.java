package interface_adapter.keyword;

import entity.Recipe;
import usecase.keyword.KeywordOutputBoundary;
import usecase.keyword.KeywordOutputData;

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
