package interface_adapter.random;

import java.util.List;

import entity.Recipe;

/**
 * The State for Random View Model.
 */
public class RandomState {

    private List<Recipe> recipeNames;
    private String errorMessage;

    public List<Recipe> getRecipeNames() {
        return recipeNames;
    }

    public void setRecipeNames(List<Recipe> recipeNames) {
        this.recipeNames = recipeNames;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
