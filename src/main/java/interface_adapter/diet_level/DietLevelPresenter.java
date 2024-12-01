package interface_adapter.diet_level;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
import usecase.diet_level.DietLevelOutputBoundary;
import usecase.diet_level.DietLevelOutputData;

import java.util.ArrayList;
import java.util.List;

/**
 * The Presneter for Diet Use Case.
 */
public class DietLevelPresenter implements DietLevelOutputBoundary {

    private final DietViewModel dietViewModel;
    private final ViewManagerModel viewManagerModel;

    public DietLevelPresenter(DietViewModel dietViewModel, ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
        this.dietViewModel = dietViewModel;
    }

    @Override
    public void presentRecipesDiet(DietLevelOutputData dietLevelOutputData) {
        final List<Recipe> recipes = dietLevelOutputData.getRecipes();

//        final List<String> recipeNames = new ArrayList<>();
//        for (Recipe recipe : recipes) {
//            recipeNames.add(recipe.()); // 假设 Recipe 有 getName() 方法
//        }
//
//        // 3. 更新 ViewModel
//        dietViewModel.setRecipeNames(recipeNames);
        viewManagerModel.firePropertyChanged();
    }
}
