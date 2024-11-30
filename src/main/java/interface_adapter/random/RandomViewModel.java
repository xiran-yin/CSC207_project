package interface_adapter.random;

import interface_adapter.ViewModel;

/**
 * The View Model for Random View Model.
 */
public class RandomViewModel extends ViewModel<RandomState> {
    public RandomViewModel() {
        super("Random");
        setState(new RandomState());
    }
}
