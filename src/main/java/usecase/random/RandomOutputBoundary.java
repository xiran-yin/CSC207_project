package usecase.random;

/**
 * The Output Boundary of the Random Use Case.
 */
public interface RandomOutputBoundary {

    /**
     * Prepare the view for final Recipe.
     * @param randomOutputData the output data.
     */
    void presentRecipes(RandomOutputData randomOutputData);
}
