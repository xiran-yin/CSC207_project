package interface_adapter.cuisine_type;

import usecase.cuisine_type.CuisineTypeOutputBoundary;
import usecase.cuisine_type.CuisineTypeOutputData;

/**
 * The Presenter for Cuisine Use Case.
 */
public class CuisineTypePresenter implements CuisineTypeOutputBoundary {
    private final CuisineViewModel cuisineViewModel;

    public CuisineTypePresenter(CuisineViewModel cuisineViewModel) {
        this.cuisineViewModel = cuisineViewModel;
    }

    @Override
    public void presentRecipesCuisine(CuisineTypeOutputData cuisineTypeOutputData) {
    }
}
