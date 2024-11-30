package interface_adapter.random;

import java.util.List;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
import usecase.random.RandomOutputBoundary;
import usecase.random.RandomOutputData;

/**
 * The Presenter for Random Use Case.
 */
public class RandomPresenter implements RandomOutputBoundary {
    private final RandomViewModel randomViewModel;

    public RandomPresenter(RandomViewModel randomViewModel) {
        this.randomViewModel = randomViewModel;
    }

    @Override
    public void presentRecipes(RandomOutputData randomOutputData) {
        // note: this use case actually just passing data:)
    }
}
