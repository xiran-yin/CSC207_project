package interface_adapter.calories;

import java.util.ArrayList;
import java.util.List;

import entity.Recipe;
import interface_adapter.ViewModel;

/**
 * The View Model for Calories View Model.
 */
public class CaloriesViewModel extends ViewModel<CaloriesState> {

    public CaloriesViewModel() {
        super("Calories");
        setState(new CaloriesState());
    }
}
