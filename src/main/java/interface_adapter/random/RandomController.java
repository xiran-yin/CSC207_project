package interface_adapter.random;

import usecase.random.RandomInputBoundary;
import usecase.random.RandomInputData;

/**
 * The Controller for Random Use Case.
 */
public class RandomController {
    private final RandomInputBoundary randomInteractor;

    public RandomController(RandomInputBoundary randomInteractor) {
        this.randomInteractor = randomInteractor;
    }

    /**
     * Executes the random use case.
     */
    public void execute() {
        final RandomInputData randomInputData = new RandomInputData();
        randomInteractor.searchRandomRecipe(randomInputData);
    }
}
