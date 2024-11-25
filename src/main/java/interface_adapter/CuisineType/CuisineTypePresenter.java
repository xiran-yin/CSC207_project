package interface_adapter.CuisineType;

import entity.Recipe;
import usecase.CuisineType.CuisineTypeOutputBoundary;
import usecase.CuisineType.CuisineTypeOutputData;
import view.RecipeChoiceView;

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
