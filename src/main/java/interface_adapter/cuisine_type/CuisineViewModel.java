package interface_adapter.cuisine_type;

import interface_adapter.ViewModel;

/**
 * The View Model for Cuisine View Model.
 */
public class CuisineViewModel extends ViewModel<CuisineState> {
    public CuisineViewModel() {
        super("Cuisine");
        setState(new CuisineState());
    }
}
