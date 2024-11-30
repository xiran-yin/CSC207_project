package usecase.diet_level;

import api.RecipeDataBase;
import entity.Recipe;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * The Diet Search Interactor.
 */
public class DietLevelInteractor implements DietLevelInputBoundary{
    private final RecipeDataBase recipeDataBase;
    private final DietLevelOutputBoundary dietLevelOutputBoundary;

    public DietLevelInteractor(RecipeDataBase recipeDataBase, DietLevelOutputBoundary dietLevelOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.dietLevelOutputBoundary = dietLevelOutputBoundary;
    }

    @Override
    public void searchDietLevelRecipe(DietLevelInputData dietLevelInputData) {
        try {
            List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    dietLevelInputData.getKeyword(), dietLevelInputData.getDietLevel(), null, 0, 0
            );
            DietLevelOutputData dietLevelOutputData = new DietLevelOutputData(recipes);
            dietLevelOutputBoundary.presentRecipesDiet(dietLevelOutputData);
        } catch (IOException ex) {
            ex.printStackTrace();
            dietLevelOutputBoundary.presentRecipesDiet(new DietLevelOutputData(Collections.emptyList()));
        }

    }
}
