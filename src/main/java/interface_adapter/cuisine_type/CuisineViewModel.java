package interface_adapter.cuisine_type;

import java.util.ArrayList;
import java.util.List;

import entity.Recipe;
import interface_adapter.ViewModel;

/**
 * The View Model for Cuisine View Model.
 */
public class CuisineViewModel extends ViewModel<CuisineState> {
    private List<Recipe> recipes = new ArrayList<>();
    private boolean isLoading = true;

    public CuisineViewModel(String viewName) {
        super(viewName);
    }

    public List<Recipe> getRecipeNames() {
        return recipes;
    }

    public void setRecipeNames(List<Recipe> recipeNames) {
        this.recipes = recipeNames;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }
}