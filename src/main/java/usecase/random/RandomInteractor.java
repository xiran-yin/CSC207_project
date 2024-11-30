package usecase.random;

import api.RecipeDataBase;
import entity.Recipe;
import interface_adapter.random.RandomViewModel;
import interface_adapter.random.RandomPresenter;

import java.util.Collections;
import java.util.List;

public class RandomInteractor implements RandomInputBoundary {
    private RandomOutputBoundary randomPresenter;
    private final RecipeDataBase recipeDataBase;

    public RandomInteractor(RandomOutputBoundary randomOutputBoundary, RecipeDataBase recipeDataBase) {
        this.randomPresenter = randomOutputBoundary;
        this.recipeDataBase = recipeDataBase;
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

            randomPresenter.presentRecipes(new RandomOutputData(recipes));
        } catch (Exception e) {
            e.printStackTrace();
            randomPresenter.presentRecipes(new RandomOutputData(Collections.emptyList()));
        }
    }
}


//    private final RecipeDataBase recipeDataBase;
//    private final RandomOutputBoundary randomOutputBoundary;
//
//    public RandomInteractor(RecipeDataBase recipeDataBase, RandomOutputBoundary randomOutputBoundary) {
//        this.recipeDataBase = recipeDataBase;
//        this.randomOutputBoundary = randomOutputBoundary;
//    }
//
//    @Override
//    public void searchRandomRecipe(RandomInputData randomInputData) {
//        try {
//            List<Recipe> recipes;
//            if ("Diet".equals(randomInputData.getFilter())) {
//                recipes = recipeDataBase.getAllRecipes(
//                    randomInputData.getKeyword(), randomInputData.getDietLevel().toString(),
//                        null, 0, 0);}
//
//            else if ("CuisineType".equals(randomInputData.getFilter())) {
//                recipes = recipeDataBase.getAllRecipes(
//                        randomInputData.getKeyword(), null,
//                        randomInputData.getCuisineType().toString(), 0, 0);}
//
//            else if ("Calories".equals(randomInputData.getFilter())) {
//                recipes = recipeDataBase.getAllRecipes(
//                        randomInputData.getKeyword(), null,
//                        null, randomInputData.getCaloriesRange().getMinCalories()
//                        , randomInputData.getCaloriesRange().getMaxCalories());}
//
//            else {recipes = recipeDataBase.getAllRecipes(
//                    randomInputData.getKeyword(), null,
//                    null, 0, 0);}
//
//            RandomViewModel randomViewModel = new RandomViewModel("randomSearchView");
//            randomPresenter.presentRecipes();
//        } catch (Exception e) {
//            e.printStackTrace();
//            randomOutputBoundary.presentRecipes(new RandomOutputData(Collections.emptyList()));
//        }
//    }
//}
