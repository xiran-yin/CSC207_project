package interface_adapter.keyword;

import interface_adapter.ViewManagerModel;
import usecase.keyword.KeywordOutputBoundary;
import usecase.keyword.KeywordOutputData;

/**
 * The Presenter for Keyword Use Case.
 */
public class KeywordPresenter implements KeywordOutputBoundary {
    private final KeywordViewModel keywordViewModel;
    private final ViewManagerModel viewManagerModel;

    public KeywordPresenter(KeywordViewModel keywordViewModel) {
        this.keywordViewModel = keywordViewModel;
        this.viewManagerModel = new ViewManagerModel();
    }

    @Override
    public void presentRecipesKeyword(KeywordOutputData keywordOutputData) {
        viewManagerModel.firePropertyChanged();
    }
}
