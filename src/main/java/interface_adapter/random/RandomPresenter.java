package interface_adapter.random;

import entity.Recipe;
import usecase.random.RandomOutputBoundary;
import usecase.random.RandomOutputData;

import java.util.List;

public class RandomPresenter implements RandomOutputBoundary {
    private final RandomViewModel randomViewModel;

    public RandomPresenter(RandomViewModel randomViewModel) {
        this.randomViewModel = randomViewModel;
    }

    @Override
    public void presentRecipes(RandomOutputData outputData) {
        List<Recipe> recipes = outputData.getRecipes();
        randomViewModel.setRecipeNames(recipes);
        randomViewModel.setLoading(false);
    }
}