package interface_adapter.diet_level;

import interface_adapter.ViewModel;
import java.util.ArrayList;
import java.util.List;

import entity.Recipe;

/**
 * The View Model for Diet View Model.
 */
public class DietViewModel extends ViewModel<DietState> {
    private List<Recipe> recipes = new ArrayList<>();
    private boolean isLoading = true;

    public DietViewModel(String viewName) {
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
