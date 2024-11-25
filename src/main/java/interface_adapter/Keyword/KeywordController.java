package interface_adapter.Keyword;

import usecase.Keyword.KeywordInputBoundary;
import usecase.Keyword.KeywordInputData;

public class KeywordController {

    private final KeywordInputBoundary keywordUseCaseInteractor;

    public KeywordController(KeywordInputBoundary keywordUseCaseInteractor) {
        this.keywordUseCaseInteractor = keywordUseCaseInteractor;
    }

    public void keywordRecipes(String keyword) {
        // Create input data for the use case
        KeywordInputData inputData = new KeywordInputData(keyword);

        // Delegate the search to the interactor
        keywordUseCaseInteractor.searchKeywordRecipe(inputData);
    }
}
