package usecase.random;

/**
 * The Input Boundary of the Random Use Case.
 */
public interface RandomInputBoundary {

    /**
     * Excute the random Use Case.
     * @param randomInputData the input data
     */
    void searchRandomRecipe(RandomInputData randomInputData);
}
