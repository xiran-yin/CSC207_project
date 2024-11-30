package interface_adapter.keyword;

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
    }
}
