package usecase.diet_level;

import api.RecipeDataBase;
import entity.Recipe;

import java.util.Collections;
import java.util.List;

public class DietLevelInteractor implements DietLevelInputBoundary{
    private final RecipeDataBase recipeDataBase;
    private final DietLevelOutputBoundary dietPresenter;

    public DietLevelInteractor(RecipeDataBase recipeDataBase, DietLevelOutputBoundary dietLevelOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.dietPresenter = dietLevelOutputBoundary;
    }

    @Override
    public void searchDietLevelRecipe(DietLevelInputData dietLevelInputData) {
        try {
            List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    dietLevelInputData.getKeyword(), dietLevelInputData.getDietLevel(), null, 0, 0
            );
            dietPresenter.presentRecipesDiet(new DietLevelOutputData(recipes));
        } catch (Exception e) {
            e.printStackTrace();
            dietPresenter.presentRecipesDiet(new DietLevelOutputData(Collections.emptyList()));
        }

    }
}
