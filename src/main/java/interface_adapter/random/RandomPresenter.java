package interface_adapter.random;

import interface_adapter.ViewManagerModel;
import usecase.random.RandomOutputBoundary;
import usecase.random.RandomOutputData;

/**
 * The Presenter for Random Use Case.
 */
public class RandomPresenter implements RandomOutputBoundary {
    private final RandomViewModel randomViewModel;
    private final ViewManagerModel viewManagerModel;

    public RandomPresenter(RandomViewModel randomViewModel, ViewManagerModel viewManagerModel) {
        this.randomViewModel = randomViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentRecipes(RandomOutputData randomOutputData) {
        // note: this use case actually just passing data:)
        viewManagerModel.firePropertyChanged();
    }
}
