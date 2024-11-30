package interface_adapter.keyword;

import java.util.List;

import entity.Recipe;
import usecase.keyword.KeywordOutputBoundary;
import usecase.keyword.KeywordOutputData;

/**
 * The Presenter for Keyword Use Case.
 */
public class KeywordPresenter implements KeywordOutputBoundary {
    private final KeywordViewModel keywordViewModel;

    public KeywordPresenter(KeywordViewModel keywordViewModel) {
        this.keywordViewModel = keywordViewModel;
    }

    @Override
    public void presentRecipesKeyword(KeywordOutputData keywordOutputData) {
        final List<Recipe> recipes = keywordOutputData.getRecipes();
    }
}
