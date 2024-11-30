package usecase.diet_level;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import api.RecipeDataBase;
import entity.Recipe;

/**
 * The Diet Search Interactor.
 */
public class DietLevelInteractor implements DietLevelInputBoundary {
    private final RecipeDataBase recipeDataBase;
    private final DietLevelOutputBoundary dietLevelOutputBoundary;

    public DietLevelInteractor(RecipeDataBase recipeDataBase, DietLevelOutputBoundary dietLevelOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.dietLevelOutputBoundary = dietLevelOutputBoundary;
    }

    @Override
    public void searchDietLevelRecipe(DietLevelInputData dietLevelInputData) {
        try {
            final List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    dietLevelInputData.getKeyword(), dietLevelInputData.getDietLevel(), null, 0, 0
            );
            final DietLevelOutputData dietLevelOutputData = new DietLevelOutputData(recipes);
            dietLevelOutputBoundary.presentRecipesDiet(dietLevelOutputData);
        }
        catch (IOException ex) {
            ex.printStackTrace();
            dietLevelOutputBoundary.presentRecipesDiet(new DietLevelOutputData(Collections.emptyList()));
        }

    }
}
