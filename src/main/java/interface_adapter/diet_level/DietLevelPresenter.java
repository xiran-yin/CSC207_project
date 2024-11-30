package interface_adapter.diet_level;

import entity.Recipe;
import usecase.diet_level.DietLevelOutputBoundary;
import usecase.diet_level.DietLevelOutputData;

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
