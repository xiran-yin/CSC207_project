package interface_adapter.calories;

import java.util.List;

import entity.Recipe;

/**
 * The State for Calories Search View Model.
 */
public class CaloriesState {

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
