package interface_adapter.cuisine_type;

import entity.Recipe;
import usecase.cuisine_type.CuisineTypeOutputBoundary;
import usecase.cuisine_type.CuisineTypeOutputData;

import java.util.List;

public class CuisineTypePresenter implements CuisineTypeOutputBoundary {
    private final CuisineViewModel cuisineViewModel;

    public CuisineTypePresenter(CuisineViewModel cuisineViewModel) {
        this.cuisineViewModel = cuisineViewModel;
    }

    @Override
    public void presentRecipesCuisine(CuisineTypeOutputData cuisineTypeOutputData) {
        List<Recipe> recipes = cuisineTypeOutputData.getRecipes();
        cuisineViewModel.setRecipeNames(recipes);
        cuisineViewModel.setLoading(false);
    }
}
