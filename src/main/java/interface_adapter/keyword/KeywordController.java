package interface_adapter.keyword;

import usecase.keyword.KeywordInputBoundary;
import usecase.keyword.KeywordInputData;

/**
 * The Controller for Keyword Use Case.
 */
public class KeywordController {

    private final KeywordInputBoundary keywordUseCaseInteractor;

    public KeywordController(KeywordInputBoundary keywordUseCaseInteractor) {
        this.keywordUseCaseInteractor = keywordUseCaseInteractor;
    }
    /**
     * Executes the keyword use case.
     * @param keyword the keyword entered for recipe search
     */
    public void keywordRecipes(String keyword) {
        // Create input data for the use case
        KeywordInputData inputData = new KeywordInputData(keyword);

        // Delegate the search to the interactor
        keywordUseCaseInteractor.searchKeywordRecipe(inputData);
    }
}
