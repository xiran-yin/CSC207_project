package interface_adapter.cuisine_type;

import java.util.List;

import entity.Recipe;
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
        final List<Recipe> recipes = cuisineTypeOutputData.getRecipes();
        cuisineViewModel.setRecipeNames(recipes);
        cuisineViewModel.setLoading(false);
    }
}
