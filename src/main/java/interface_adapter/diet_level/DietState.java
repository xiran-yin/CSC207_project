package interface_adapter.diet_level;

import entity.Recipe;
import interface_adapter.random.RandomState;

import java.util.List;

public class DietState {
    public enum Status {
        LOADING,
        SUCCESS,
        FAILURE
    }

    private RandomState.Status status;
    private List<Recipe> recipeNames;
    private String errorMessage;

    public RandomState.Status getStatus() {
        return status;
    }

    public void setStatus(RandomState.Status status) {
        this.status = status;
    }

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
