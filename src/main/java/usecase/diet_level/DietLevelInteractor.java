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
    private final DietLevelOutputBoundary dietPresenter;

    public DietLevelInteractor(RecipeDataBase recipeDataBase, DietLevelOutputBoundary dietLevelOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.dietPresenter = dietLevelOutputBoundary;
    }

    @Override
    public void searchDietLevelRecipe(DietLevelInputData dietLevelInputData) {
        try {
            final List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    dietLevelInputData.getKeyword(),
                    dietLevelInputData.getDietLevel(),
                    null, 0, 0
            );
            dietPresenter.presentRecipesDiet(new DietLevelOutputData(recipes));
        }
        catch (IOException ex) {
            ex.printStackTrace();
            dietPresenter.presentRecipesDiet(new DietLevelOutputData(Collections.emptyList()));
        }

    }
}
