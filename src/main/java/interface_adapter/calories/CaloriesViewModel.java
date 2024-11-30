package interface_adapter.calories;

import entity.Recipe;
import interface_adapter.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class CaloriesViewModel extends ViewModel<CaloriesState> {
    public CaloriesViewModel() {
        super("Calories");
        setState(new CaloriesState());
    }
//    private List<Recipe> recipes = new ArrayList<>();
//    private boolean isLoading = true;
//
//    public List<Recipe> getRecipeNames() {
//        return recipes;
//    }
//
//    public void setRecipeNames(List<Recipe> recipeNames) {
//        this.recipes = recipeNames;
//    }
//
//    public boolean isLoading() {
//        return isLoading;
//    }
//
//    public void setLoading(boolean loading) {
//        isLoading = loading;
//    }
}
