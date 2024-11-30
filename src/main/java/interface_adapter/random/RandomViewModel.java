package interface_adapter.random;

import entity.Recipe;
import interface_adapter.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class RandomViewModel extends ViewModel<RandomState> {
    private List<Recipe> recipes = new ArrayList<>();
    private boolean isLoading = true;

    public RandomViewModel(String viewName) {
        super(viewName);
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }
}