package interface_adapter.keyword;

import java.util.ArrayList;
import java.util.List;

import entity.Recipe;

/**
 * The View Model for Keyword View Model.
 */
public class KeywordViewModel {

    private List<Recipe> recipes = new ArrayList<>();
    private boolean isLoading = true;

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
