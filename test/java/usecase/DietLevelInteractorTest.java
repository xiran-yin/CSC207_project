package usecase;

import static org.mockito.Mockito.*;

import api.RecipeDataBase;
import entity.Diet;
import entity.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.diet_level.DietLevelInteractor;
import usecase.diet_level.DietLevelOutputBoundary;
import usecase.diet_level.DietLevelInputData;
import usecase.diet_level.DietLevelOutputData;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

class DietLevelInteractorTest {


    private RecipeDataBase recipeDataBase;
    private DietLevelOutputBoundary dietLevelOutputBoundary;
    private DietLevelInteractor interactor;

    @BeforeEach
    void setUp() {
        // Mock the dependencies
        recipeDataBase = mock(RecipeDataBase.class);
        dietLevelOutputBoundary = mock(DietLevelOutputBoundary.class);

        // Instantiate the interactor with the mocked dependencies
        interactor = new DietLevelInteractor(recipeDataBase, dietLevelOutputBoundary);
    }

    @Test
    void testSearchDietLevelRecipeSuccess() throws IOException {
        // Prepare the test data
        Diet diet = new Diet(new String[]{"low-fat"});
        DietLevelInputData inputData = new DietLevelInputData("Tomato", "low-fat");
        Recipe mockRecipe = new Recipe("Tomato Essnce", 0, null, diet, null);
        List<Recipe> mockRecipes = Collections.singletonList(mockRecipe);

        // Mock the behavior of the recipeDataBase to return a list of recipes
        when(recipeDataBase.getAllRecipes("Tomato", "low-fat", null, 0, 0))
                .thenReturn(mockRecipes);

        // Run the use case (interactor)
        interactor.searchDietLevelRecipe(inputData);

        // Verify that the output boundary's presentRecipesCuisine method is called
        verify(dietLevelOutputBoundary, times(1)).presentRecipesDiet(any(DietLevelOutputData.class));

        // Further verify that the recipes were correctly passed
        verify(dietLevelOutputBoundary).presentRecipesDiet(argThat(output ->
                output.getRecipes().contains(mockRecipe)
        ));
    }

    @Test
    void testSearchDietLevelRecipeFailure() throws IOException {
        // Prepare the test data
        DietLevelInputData inputData = new DietLevelInputData("Tomato", "low-fat");

        // Mock the behavior of the recipeDataBase to throw an exception
        when(recipeDataBase.getAllRecipes("Tomato passata", "balanced", null, 0, 0))
                .thenThrow(new RuntimeException("Database error"));

        // Run the use case (interactor)
        interactor.searchDietLevelRecipe(inputData);

        // Verify that the output boundary's presentRecipesCuisine method is called with an empty list
        verify(dietLevelOutputBoundary, times(1)).presentRecipesDiet(argThat(output ->
                output.getRecipes().isEmpty()
        ));
    }

    @Test
    void testSearchDietLevelRecipeEmptyResult() throws IOException {
        // Prepare the test data
        DietLevelInputData inputData = new DietLevelInputData("sdffwerge", "low-fat");

        // Mock the behavior of the recipeDataBase to return an empty list
        when(recipeDataBase.getAllRecipes("Spaghetti", "low-fat", null, 0, 0))
                .thenReturn(Collections.emptyList());

        // Run the use case (interactor)
        interactor.searchDietLevelRecipe(inputData);

        // Verify that the output boundary's presentRecipesCuisine method is called with an empty list
        verify(dietLevelOutputBoundary, times(1)).presentRecipesDiet(argThat(output ->
                output.getRecipes().isEmpty()
        ));
    }

}
