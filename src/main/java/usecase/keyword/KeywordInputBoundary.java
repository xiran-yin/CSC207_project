package usecase.keyword;

/**
 * The Input Boundary of the Keyword Search Use Case.
 */
public interface KeywordInputBoundary {

    /**
     * Excute the keyword Use Case.
     * @param keywordInputData the input data
     */
    void searchKeywordRecipe(KeywordInputData keywordInputData);
}
