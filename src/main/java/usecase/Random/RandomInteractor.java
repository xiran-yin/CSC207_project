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
            List<Recipe> recipes;
            if ("Diet".equals(randomInputData.getFilter())) {
                recipes = recipeDataBase.getAllRecipes(
                    randomInputData.getKeyword(), randomInputData.getDietLevel().toString(),
                        null, 0, 0);}

            else if ("CuisineType".equals(randomInputData.getFilter())) {
                recipes = recipeDataBase.getAllRecipes(
                        randomInputData.getKeyword(), null,
                        randomInputData.getCuisineType().toString(), 0, 0);}

            else if ("Calories".equals(randomInputData.getFilter())) {
                recipes = recipeDataBase.getAllRecipes(
                        randomInputData.getKeyword(), null,
                        null, randomInputData.getCaloriesRange().getMinCalories()
                        , randomInputData.getCaloriesRange().getMaxCalories());}

            else {recipes = recipeDataBase.getAllRecipes(
                    randomInputData.getKeyword(), null,
                    null, 0, 0);}

            RandomOutputData randomOutputData = new RandomOutputData(recipes);
            randomOutputBoundary.presentRecipes(randomOutputData);
        } catch (Exception e) {
            e.printStackTrace();
            randomOutputBoundary.presentRecipes(new RandomOutputData(Collections.emptyList()));
        }
    }
}
