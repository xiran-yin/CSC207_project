package usecase;

import static org.mockito.Mockito.*;

import api.RecipeDataBase;
import entity.Cuisine;
import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.CuisineType.CuisineTypeInteractor;
import usecase.CuisineType.CuisineTypeOutputBoundary;
import usecase.CuisineType.CuisineTypeInputData;
import usecase.CuisineType.CuisineTypeOutputData;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

class CuisineTypeInteractorTest {


    private RecipeDataBase recipeDataBase;
    private CuisineTypeOutputBoundary cuisineOutputBoundary;
    private CuisineTypeInteractor interactor;

    @BeforeEach
    void setUp() {
        // Mock the dependencies
        recipeDataBase = mock(RecipeDataBase.class);
        cuisineOutputBoundary = mock(CuisineTypeOutputBoundary.class);

        // Instantiate the interactor with the mocked dependencies
        interactor = new CuisineTypeInteractor(recipeDataBase, cuisineOutputBoundary);
    }

    @Test
    void testSearchCuisineRecipeSuccess() throws IOException {
        // Prepare the test data
        Cuisine cuisine = new Cuisine("Chinese");
        CuisineTypeInputData inputData = new CuisineTypeInputData("Tomato", "Chinese");
        Recipe mockRecipe = new Recipe("Stir-Fried Egg and Tomato", 0, cuisine, null, null);
        List<Recipe> mockRecipes = Collections.singletonList(mockRecipe);

        // Mock the behavior of the recipeDataBase to return a list of recipes
        when(recipeDataBase.getAllRecipes("Tomato", null, "Chinese", 0, 0))
                .thenReturn(mockRecipes);

        // Run the use case (interactor)
        interactor.searchCuisineRecipe(inputData);

        // Verify that the output boundary's presentRecipesCuisine method is called
        verify(cuisineOutputBoundary, times(1)).presentRecipesCuisine(any(CuisineTypeOutputData.class));

        // Further verify that the recipes were correctly passed
        verify(cuisineOutputBoundary).presentRecipesCuisine(argThat(output ->
                output.getRecipes().contains(mockRecipe)
        ));
    }

    @Test
    void testSearchCuisineRecipeFailure() throws IOException {
        // Prepare the test data
        CuisineTypeInputData inputData = new CuisineTypeInputData("Tomato", "Chinese");

        // Mock the behavior of the recipeDataBase to throw an exception
        when(recipeDataBase.getAllRecipes("Spaghetti", null, "Italian", 0, 0))
                .thenThrow(new RuntimeException("Database error"));

        // Run the use case (interactor)
        interactor.searchCuisineRecipe(inputData);

        // Verify that the output boundary's presentRecipesCuisine method is called with an empty list
        verify(cuisineOutputBoundary, times(1)).presentRecipesCuisine(argThat(output ->
                output.getRecipes().isEmpty()
        ));
    }

    @Test
    void testSearchCuisineRecipeEmptyResult() throws IOException {
        // Prepare the test data
        CuisineTypeInputData inputData = new CuisineTypeInputData("sdffwerge", "Italian");

        // Mock the behavior of the recipeDataBase to return an empty list
        when(recipeDataBase.getAllRecipes("Spaghetti", null, "Italian", 0, 0))
                .thenReturn(Collections.emptyList());

        // Run the use case (interactor)
        interactor.searchCuisineRecipe(inputData);

        // Verify that the output boundary's presentRecipesCuisine method is called with an empty list
        verify(cuisineOutputBoundary, times(1)).presentRecipesCuisine(argThat(output ->
                output.getRecipes().isEmpty()
        ));
    }

}
