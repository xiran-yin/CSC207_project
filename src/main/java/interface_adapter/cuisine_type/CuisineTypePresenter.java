package interface_adapter.cuisine_type;

import interface_adapter.ViewManagerModel;
import usecase.cuisine_type.CuisineTypeOutputBoundary;
import usecase.cuisine_type.CuisineTypeOutputData;

/**
 * The Presenter for Cuisine Use Case.
 */
public class CuisineTypePresenter implements CuisineTypeOutputBoundary {
    private final CuisineViewModel cuisineViewModel;
    private final ViewManagerModel viewManagerModel;

    public CuisineTypePresenter(CuisineViewModel cuisineViewModel, ViewManagerModel viewManagerModel) {
        this.cuisineViewModel = cuisineViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void presentRecipesCuisine(CuisineTypeOutputData cuisineTypeOutputData) {
        viewManagerModel.firePropertyChanged();
    }
}
