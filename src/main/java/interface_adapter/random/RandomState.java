package interface_adapter.random;

import entity.Recipe;

import java.util.List;

public class RandomState {
    public enum Status {
        LOADING,
        SUCCESS,
        FAILURE
    }

    private Status status;
    private List<Recipe> recipeNames;
    private String errorMessage;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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
