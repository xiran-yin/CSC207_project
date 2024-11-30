package interface_adapter.random;

import entity.Recipe;
import interface_adapter.ViewModel;

import java.util.List;

public class RandomState {
    public enum Status {
        LOADING,
        SUCCESS,
        FAILURE
    }

    private Status status;
    private List<Recipe> recipes;
    private String errorMessage;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
