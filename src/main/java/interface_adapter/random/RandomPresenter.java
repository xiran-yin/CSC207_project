package interface_adapter.random;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
import usecase.random.RandomOutputBoundary;
import usecase.random.RandomOutputData;

import java.util.List;

public class RandomPresenter implements RandomOutputBoundary {
    private final RandomViewModel randomViewModel;

    public RandomPresenter(RandomViewModel randomViewModel) {
        this.randomViewModel = randomViewModel;
    }
    @Override
    public void presentRecipes(RandomOutputData randomOutputData) {
        List<Recipe> recipes = randomOutputData.getRecipes();
        randomViewModel.setRecipes(recipes);
        randomViewModel.setLoading(false);
    }
}