package interface_adapter.DietLevel;

import entity.Recipe;
import usecase.DietLevel.DietLevelOutputBoundary;
import usecase.DietLevel.DietLevelOutputData;
import view.RecipeChoiceView;

import java.util.List;

public class DietLevelPresenter implements DietLevelOutputBoundary {

    private final RecipeChoiceView recipeChoiceView;

    public DietLevelPresenter(RecipeChoiceView recipeChoiceView) {
        this.recipeChoiceView = recipeChoiceView;
    }

    @Override
    public void presentRecipesDiet(DietLevelOutputData dietLevelOutputData){
        List<Recipe> recipe = dietLevelOutputData.getRecipes();
        recipeChoiceView.setDietRecipes(recipe);
        recipeChoiceView.displayRecipes();
    }
}
