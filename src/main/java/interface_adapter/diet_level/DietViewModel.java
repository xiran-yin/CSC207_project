package interface_adapter.diet_level;

import interface_adapter.ViewModel;

/**
 * The View Model for Diet View Model.
 */
public class DietViewModel extends ViewModel<DietState> {
    public DietViewModel() {
        super("Diet");
        setState(new DietState());

    }
}
