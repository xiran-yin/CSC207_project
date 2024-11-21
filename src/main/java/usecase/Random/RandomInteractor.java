package usecase.Random;

import api.RecipeDataBase;
import entity.Recipe;

import java.util.Collections;
import java.util.List;

public class RandomInteractor implements RandomInputBoundary {
    private final RecipeDataBase recipeDataBase;
    private final RandomOutputBoundary randomOutputBoundary;

    public RandomInteractor(RecipeDataBase recipeDataBase, RandomOutputBoundary randomOutputBoundary) {
        this.recipeDataBase = recipeDataBase;
        this.randomOutputBoundary = randomOutputBoundary;
    }

    @Override
    public void searchRandomRecipe(RandomInputData randomInputData) {
        try {
            List<Recipe> recipes = recipeDataBase.getAllRecipes(
                    randomInputData.getKeyword(), null, null, 0, 0
            );
            RandomOutputData randomOutputData = new RandomOutputData(recipes);
            randomOutputBoundary.presentRecipes(randomOutputData);
        } catch (Exception e) {
            e.printStackTrace();
            randomOutputBoundary.presentRecipes(new RandomOutputData(Collections.emptyList()));
        }

    }
}
