package interface_adapter.diet_level;

import usecase.diet_level.DietLevelOutputBoundary;
import usecase.diet_level.DietLevelOutputData;

/**
 * The Presneter for Diet Use Case.
 */
public class DietLevelPresenter implements DietLevelOutputBoundary {

    private final DietViewModel dietViewModel;

    public DietLevelPresenter(DietViewModel dietViewModel) {
        this.dietViewModel = dietViewModel;
    }

    @Override
    public void presentRecipesDiet(DietLevelOutputData dietLevelOutputData) {
    }
}
