package usecase.keyword;

/**
 * The Output Boundary of the Keyword Search Use Case.
 */
public interface KeywordOutputBoundary {

    /**
     * Prepare the view for final Recipe.
     * @param keywordOutputData the output data.
     */
    void presentRecipesKeyword(KeywordOutputData keywordOutputData);
}
