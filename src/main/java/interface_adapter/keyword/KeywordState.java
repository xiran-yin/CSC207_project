package interface_adapter.keyword;

import java.util.List;

import entity.Recipe;
import interface_adapter.random.RandomState;

/**
 * The State for Keyword View Model.
 */
public class KeywordState {
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
