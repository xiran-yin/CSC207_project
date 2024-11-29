package usecase;

import api.RecipeDataBase;
import entity.Cuisine;
import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.keyword.KeywordInputData;
import usecase.keyword.KeywordInteractor;
import usecase.keyword.KeywordOutputBoundary;
import usecase.keyword.KeywordOutputData;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class KeywordInteractorTest {

    private RecipeDataBase recipeDataBase;
    private KeywordOutputBoundary keywordOutputBoundary;
    private KeywordInteractor interactor;

    @BeforeEach
    void setUp() {
        // Mock dependencies
        recipeDataBase = mock(RecipeDataBase.class);
        keywordOutputBoundary = mock(KeywordOutputBoundary.class);

        // Initialize the interactor with mocked dependencies
        interactor = new KeywordInteractor(recipeDataBase, keywordOutputBoundary);
    }

    @Test
    void testSearchKeywordRecipeSuccess() throws IOException {
        // Prepare test data
        KeywordInputData inputData = new KeywordInputData("Tomato");
        Recipe mockRecipe = new Recipe("Tomato Gravy", 1015.44, new Cuisine("British"), null, null);
        List<Recipe> mockRecipes = Collections.singletonList(mockRecipe);

        // Mock RecipeDataBase to return a list of recipes when the keyword is "Tomato"
        when(recipeDataBase.getAllRecipes("Tomato", null, null, 0, 0))
                .thenReturn(mockRecipes);

        // Run the use case (interactor)
        interactor.searchKeywordRecipe(inputData);

        // Verify the output boundary's presentRecipesKeyword method is called once with the correct data
        verify(keywordOutputBoundary, times(1)).presentRecipesKeyword(any(KeywordOutputData.class));

//        // Verify that the correct recipe is passed to the output boundary
//        verify(keywordOutputBoundary).presentRecipesKeyword(argThat(output ->
//                output.getRecipes().contains(mockRecipe)
//        ));
    }

    @Test
    void testSearchKeywordRecipeEmptyResult() throws IOException {
        // Prepare test data
        KeywordInputData inputData = new KeywordInputData("Pasta");

        // Mock RecipeDataBase to return an empty list when the keyword is "Pasta"
        when(recipeDataBase.getAllRecipes("Pasta", null, null, 0, 0))
                .thenReturn(Collections.emptyList());

        // Run the use case (interactor)
        interactor.searchKeywordRecipe(inputData);

        // Verify the output boundary's presentRecipesKeyword method is called once with an empty list
        verify(keywordOutputBoundary, times(1)).presentRecipesKeyword(argThat(output ->
                output.getRecipes().isEmpty()
        ));
    }

    @Test
    void testSearchKeywordRecipeFailure() throws IOException {
        // Prepare test data
        KeywordInputData inputData = new KeywordInputData("Pasta");

        // Mock RecipeDataBase to throw an exception
        when(recipeDataBase.getAllRecipes("Pasta", null, null, 0, 0))
                .thenThrow(new RuntimeException("Database error"));

        // Run the use case (interactor)
        interactor.searchKeywordRecipe(inputData);

        // Verify the output boundary's presentRecipesKeyword method is called once with an empty list due to the failure
        verify(keywordOutputBoundary, times(1)).presentRecipesKeyword(argThat(output ->
                output.getRecipes().isEmpty()
        ));
    }
}
