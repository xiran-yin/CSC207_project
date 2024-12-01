package usecase.keyword;

import api.RecipeDataBase;
import entity.Cuisine;
import entity.Diet;
import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.keyword.KeywordInputData;
import usecase.keyword.KeywordInteractor;
import usecase.keyword.KeywordOutputBoundary;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

class KeywordInteractorTest {

    private RecipeDataBase recipeDataBase;
    private KeywordOutputBoundary keywordOutputBoundary;
    private KeywordInteractor interactor;

    @BeforeEach
    void setUp() {
        recipeDataBase = mock(RecipeDataBase.class);
        keywordOutputBoundary = mock(KeywordOutputBoundary.class);
        interactor = new KeywordInteractor(keywordOutputBoundary, recipeDataBase);
    }

    @Test
    void testSearchKeywordRecipeSuccess() throws IOException {
        // Prepare test data
        KeywordInputData inputData = new KeywordInputData("Pasta");

        // Create a valid Recipe object
        Diet mockDiet = mock(Diet.class);
        Cuisine mockCuisine = mock(Cuisine.class);
        Recipe mockRecipe = new Recipe("Pasta Primavera", 300, mockCuisine, mockDiet, new String[]{"pasta", "tomato", "garlic"});

        List<Recipe> mockRecipes = Collections.singletonList(mockRecipe);

        // Mock RecipeDataBase to return a list of recipes when searching for "Pasta"
        when(recipeDataBase.getAllRecipes("Pasta", null, null, 0, 0)).thenReturn(mockRecipes);

        // Run the use case (interactor)
        interactor.searchKeywordRecipe(inputData);

        // Verify that presentRecipesKeyword was called once with a KeywordOutputData containing mockRecipe
        verify(keywordOutputBoundary, times(1)).presentRecipesKeyword(argThat(output -> {
            return output.getRecipes().contains(mockRecipe);  // Ensure the output contains mockRecipe
        }));
    }

    @Test
    void testSearchKeywordRecipeNoResults() throws IOException {
        // Prepare test data
        KeywordInputData inputData = new KeywordInputData("Pasta");

        // Mock RecipeDataBase to return an empty list when no recipes are found
        when(recipeDataBase.getAllRecipes("Pasta", null, null, 0, 0)).thenReturn(Collections.emptyList());

        // Run the use case (interactor)
        interactor.searchKeywordRecipe(inputData);

        // Verify that presentRecipesKeyword was called once with an empty list
        verify(keywordOutputBoundary, times(1)).presentRecipesKeyword(argThat(output -> {
            return output.getRecipes().isEmpty();  // Ensure the output is empty
        }));
    }

    @Test
    void testSearchKeywordRecipeException() throws IOException {
        // Prepare test data
        KeywordInputData inputData = new KeywordInputData("Pasta");

        // Simulate an IOException in the RecipeDataBase
        when(recipeDataBase.getAllRecipes("Pasta", null, null, 0, 0))
                .thenThrow(new IOException("Simulated IO error"));

        // Run the use case (interactor)
        interactor.searchKeywordRecipe(inputData);

        // Verify that presentRecipesKeyword was called once with an empty list due to the exception
        verify(keywordOutputBoundary, times(1)).presentRecipesKeyword(argThat(output -> {
            return output.getRecipes().isEmpty();  // Ensure the output is empty due to the exception
        }));
    }
}
