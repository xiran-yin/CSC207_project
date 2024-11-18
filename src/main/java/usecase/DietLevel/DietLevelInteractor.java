package usecase.DietLevel;

import api.RecipeDataBase;
import entity.Recipe;

import java.util.Collections;
import java.util.List;

public class DietLevelInteractor implements DietLevelInputBoundary{
    private final RecipeDataBase recipeDataBase;
    private final DietLevelOutputBoundary dietLevelOutputBoundary;

    public DietLevelInteractor(RecipeDataBase recipeDataBase, DietLevelOutputBoundary dietLevelOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.dietLevelOutputBoundary = dietLevelOutputBoundary;
    }

    @Override
    public void searchCuisineRecipe(DietLevelInputData dietLevelInputData) {
        try {
            List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    dietLevelInputData.getKeyword(), null, dietLevelInputData.getDietLevel(), 0, 0
            );
            DietLevelOutputData dietLevelOutputData = new DietLevelOutputData(recipes);
            dietLevelOutputBoundary.presentRecipesDiet(dietLevelOutputData);
        } catch (Exception e) {
            e.printStackTrace();
            dietLevelOutputBoundary.presentRecipesDiet(new DietLevelOutputData(Collections.emptyList()));
        }

    }
}
