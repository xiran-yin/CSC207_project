package usecase;

import api.RecipeDataBase;
import entity.CaloriesRange;
import entity.Cuisine;
import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.Calories.CaloriesInputData;
import usecase.Calories.CaloriesInteractor;
import usecase.Calories.CaloriesOutputBoundary;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

class CaloriesInteractorTest {

    private RecipeDataBase recipeDataBase;
    private CaloriesOutputBoundary caloriesOutputBoundary;
    private CaloriesInteractor interactor;

    @BeforeEach
    void setUp() {
        recipeDataBase = mock(RecipeDataBase.class);
        caloriesOutputBoundary = mock(CaloriesOutputBoundary.class);
        interactor = new CaloriesInteractor(recipeDataBase, caloriesOutputBoundary);
    }

    @Test
    void testSearchCaloriesRecipesSuccess() throws IOException {
        // Prepare test data
        CaloriesInputData inputData = new CaloriesInputData("Pasta", new CaloriesRange(200, 500));

        // Create a valid Recipe object
        Cuisine italianCuisine = new Cuisine("Italian");
        Recipe mockRecipe = new Recipe("Pasta Primavera", 300, italianCuisine, null, new String[]{"pasta", "tomato", "garlic"});

        List<Recipe> mockRecipes = Collections.singletonList(mockRecipe);

        // Mock RecipeDataBase to return a list of recipes when the calorie range is between 200 and 500
        when(recipeDataBase.getAllRecipes("Pasta", null, null, 200, 500)).thenReturn(mockRecipes);

        // Run the use case (interactor)
        interactor.searchCaloriesRecipes(inputData);

        // Verify that presentRecipesCalories was called once with a CaloriesOutputData containing mockRecipe
        verify(caloriesOutputBoundary, times(1)).presentRecipesCalories(argThat(output -> {
            return output.getRecipes().contains(mockRecipe);  // Make sure the output contains mockRecipe
        }));
    }

    @Test
    void testSearchCaloriesRecipesNoResults() throws IOException {
        // Prepare test data
        CaloriesInputData inputData = new CaloriesInputData("Pasta", new CaloriesRange(1000, 1500));

        // Mock RecipeDataBase to return an empty list when the calorie range is too restrictive
        when(recipeDataBase.getAllRecipes("Pasta", null, null, 1000, 1500)).thenReturn(Collections.emptyList());

        // Run the use case (interactor)
        interactor.searchCaloriesRecipes(inputData);

        // Verify that presentRecipesCalories was called once with an empty list
        verify(caloriesOutputBoundary, times(1)).presentRecipesCalories(argThat(output -> {
            return output.getRecipes().isEmpty();  // Ensure the output is empty
        }));
    }

    @Test
    void testSearchCaloriesRecipesException() throws IOException {
        // Prepare test data
        CaloriesInputData inputData = new CaloriesInputData("Pasta", new CaloriesRange(200, 500));

        // Simulate an exception in the RecipeDataBase
        when(recipeDataBase.getAllRecipes("Pasta", null, null, 200, 500)).thenThrow(new RuntimeException("Database error"));

        // Run the use case (interactor)
        interactor.searchCaloriesRecipes(inputData);

        // Verify that presentRecipesCalories was called once with an empty list due to the exception
        verify(caloriesOutputBoundary, times(1)).presentRecipesCalories(argThat(output -> {
            return output.getRecipes().isEmpty();  // Ensure the output is empty due to exception
        }));
    }
}
