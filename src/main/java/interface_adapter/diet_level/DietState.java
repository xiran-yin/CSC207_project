package interface_adapter.diet_level;

import java.util.List;

import entity.Recipe;

/**
 * The State for Diet View Model.
 */
public class DietState {

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
