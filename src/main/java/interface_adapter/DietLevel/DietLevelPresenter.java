package interface_adapter.DietLevel;

import entity.Recipe;
import usecase.DietLevel.DietLevelOutputBoundary;
import usecase.DietLevel.DietLevelOutputData;
import view.RecipeChoiceView;

import java.util.List;

public class DietLevelPresenter implements DietLevelOutputBoundary {

    private final DietViewModel dietViewModel;

    public DietLevelPresenter(DietViewModel dietViewModel) {
        this.dietViewModel = dietViewModel;
    }

    @Override
    public void presentRecipesDiet(DietLevelOutputData dietLevelOutputData){
        List<Recipe> recipe = dietLevelOutputData.getRecipes();
        dietViewModel.setRecipeNames(recipe);
        dietViewModel.setLoading(false);
    }
}
