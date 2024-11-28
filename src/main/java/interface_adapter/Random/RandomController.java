package interface_adapter.Random;

import usecase.Random.RandomInputBoundary;
import usecase.Random.RandomInputData;

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
