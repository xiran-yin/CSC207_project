package usecase;

import api.RecipeDataBase;
import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.random.RandomInputData;
import usecase.random.RandomInteractor;
import usecase.random.RandomOutputBoundary;
import usecase.random.RandomOutputData;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

public class RandomInteractorTest {

    private RecipeDataBase recipeDataBase;
    private RandomOutputBoundary randomOutputBoundary;
    private RandomInteractor interactor;

    @BeforeEach
    void setUp() {
        // Mock the dependencies
        recipeDataBase = mock(RecipeDataBase.class);
        randomOutputBoundary = mock(RandomOutputBoundary.class);

        // Instantiate the interactor with the mocked dependencies
        interactor = new RandomInteractor(randomOutputBoundary, recipeDataBase);
    }

    @Test
    void testSearchRandomRecipeSuccess() throws IOException {
        // Prepare the test data
        RandomInputData inputData = new RandomInputData();
        Recipe mockRecipe = new Recipe("Tomato Essnce", inputData.getCaloriesRange().getMinCalories(),
                inputData.getCuisineType(), inputData.getDietLevel(), new String[]{inputData.getKeyword()});
        List<Recipe> mockRecipes = Collections.singletonList(mockRecipe);

        // Mock the behavior of the recipeDataBase to return a list of recipes
        when(recipeDataBase.getAllRecipes(inputData.getKeyword(), inputData.getDietLevel().toString(),
                inputData.getCuisineType().toString(), inputData.getCaloriesRange().getMinCalories(),
                inputData.getCaloriesRange().getMaxCalories()))
                .thenReturn(mockRecipes);

        // Run the use case (interactor)
        interactor.searchRandomRecipe(inputData);

        // Verify that the output boundary's presentRecipesCuisine method is called
        verify(randomOutputBoundary, times(1)).presentRecipes(any(RandomOutputData.class));

        // Further verify that the recipes were correctly passed
        verify(randomOutputBoundary).presentRecipes(argThat(output ->
                output.getRecipes().contains(mockRecipe)
        ));
    }

    @Test
    void testSearchRandomRecipeFailure() throws IOException {
        // Prepare the test data
        RandomInputData inputData = new RandomInputData();

        // Mock the behavior of the recipeDataBase to throw an exception
        when(recipeDataBase.getAllRecipes(inputData.getKeyword(), null, null, 0, 0))
                .thenThrow(new RuntimeException("Database error"));

        // Run the use case (interactor)
        interactor.searchRandomRecipe(inputData);

        // Verify that the output boundary's presentRecipesCuisine method is called with an empty list
        verify(randomOutputBoundary, times(1)).presentRecipes(argThat(output ->
                output.getRecipes().isEmpty()
        ));
    }

}
