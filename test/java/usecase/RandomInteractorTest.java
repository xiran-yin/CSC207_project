package usecase;

import api.RecipeDataBase;
import entity.CaloriesRange;
import entity.Cuisine;
import entity.Diet;
import entity.Recipe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usecase.random.RandomInputData;
import usecase.random.RandomInteractor;
import usecase.random.RandomOutputBoundary;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class RandomInteractorTest {

    private RecipeDataBase recipeDataBase;
    private RandomOutputBoundary randomOutputBoundary;
    private RandomInteractor interactor;

    @BeforeEach
    void setUp() {
        recipeDataBase = mock(RecipeDataBase.class);
        randomOutputBoundary = mock(RandomOutputBoundary.class);
        interactor = new RandomInteractor(randomOutputBoundary, recipeDataBase);
    }

    @Test
    void testSearchRandomRecipeWithValidFilter() throws IOException {
        // Arrange
        RandomInputData inputData = mock(RandomInputData.class);
        when(inputData.getFilter()).thenReturn("Diet");
        when(inputData.getKeyword()).thenReturn("Tomato");
        when(inputData.getDietLevel()).thenReturn(new Diet(new String[]{"low-carb"}));
        Recipe mockRecipe = new Recipe("Tomato Essence", 100, null, new Diet(new String[]{"low-carb"}), new String[]{"Tomato"});
        when(recipeDataBase.getAllRecipes("Tomato", "low-carb", null, 0, 0))
                .thenReturn(Collections.singletonList(mockRecipe));

        // Act
        interactor.searchRandomRecipe(inputData);

        // Assert
        verify(randomOutputBoundary, times(1)).presentRecipes(argThat(output ->
                output.getRecipes().contains(mockRecipe)
        ));
    }

    @Test
    void testSearchRandomRecipeWithDatabaseError() throws IOException {
        // Arrange
        RandomInputData inputData = mock(RandomInputData.class);
        when(inputData.getFilter()).thenReturn(null);
        when(inputData.getKeyword()).thenReturn("Tomato");
        when(recipeDataBase.getAllRecipes(any(), any(), any(), anyInt(), anyInt()))
                .thenThrow(new IOException("Database connection error"));

        // Act
        interactor.searchRandomRecipe(inputData);

        // Assert
        verify(randomOutputBoundary, times(1)).presentRecipes(argThat(output ->
                output.getRecipes().isEmpty()
        ));
    }

    @Test
    void testRandomInputDataInitialization() {
        RandomInputData inputData = new RandomInputData();

        Assertions.assertNotNull("Keyword should not be null", inputData.getKeyword());

        String filter = inputData.getFilter();
        assertTrue(Objects.equals(filter, "keywordFilter") || filter.equals("Diet") || filter.equals("CuisineType") || filter.equals("Calories"),
                "Filter should be one of 'Diet', 'CuisineType', 'Calories', or null");

        // Check the correctness of the filter-specific attributes
        switch (filter) {
            case "Diet":
                Assertions.assertNotNull("Diet level should not be null when filter is 'Diet'", inputData.getDietLevel().toString());
                assertNull(inputData.getCuisineType(), "Cuisine type should be null when filter is 'Diet'");
                assertNull(inputData.getCaloriesRange(), "Calories range should be null when filter is 'Diet'");
                break;
            case "CuisineType":
                Assertions.assertNotNull("Cuisine type should not be null when filter is 'CuisineType'", inputData.getCuisineType().toString());
                assertNull(inputData.getDietLevel(), "Diet level should be null when filter is 'CuisineType'");
                assertNull(inputData.getCaloriesRange(), "Calories range should be null when filter is 'CuisineType'");
                break;
            case "Calories":
                Assertions.assertNotNull("Calories range should not be null when filter is 'Calories'", inputData.getCaloriesRange().toString());
                assertNull(inputData.getDietLevel(), "Diet level should be null when filter is 'Calories'");
                assertNull(inputData.getCuisineType(), "Cuisine type should be null when filter is 'Calories'");
                // Verify that calories range values are reasonable
                CaloriesRange range = inputData.getCaloriesRange();
                assertTrue(range.getMinCalories() >= 0, "Minimum calories should be non-negative");
                assertTrue(range.getMaxCalories() >= range.getMinCalories(), "Maximum calories should be greater than or equal to minimum calories");
                break;
            default:
                // When filter is null, all specific fields should also be null
                assertNull(inputData.getDietLevel(), "Diet level should be null when filter is null");
                assertNull(inputData.getCuisineType(), "Cuisine type should be null when filter is null");
                assertNull(inputData.getCaloriesRange(), "Calories range should be null when filter is null");
                break;
        }
    }

    @Test
    void testRandomKeywordSelection() {
        // Instantiate RandomInputData multiple times to ensure randomness in keyword selection
        RandomInputData inputData1 = new RandomInputData();
        RandomInputData inputData2 = new RandomInputData();

        // Verify that the keywords are not null
        Assertions.assertNotNull("Keyword of first instance should not be null", inputData1.getKeyword());
        Assertions.assertNotNull("Keyword of second instance should not be null", inputData2.getKeyword());

        // Verify that the keywords can be different (not guaranteed, but possible)
        // This ensures randomness is at least functional
        System.out.println("Keyword 1: " + inputData1.getKeyword());
        System.out.println("Keyword 2: " + inputData2.getKeyword());
    }

    @Test
    void testSearchRandomRecipeWithCuisineTypeFilter() throws IOException {
        // Arrange
        RandomInputData inputData = mock(RandomInputData.class);
        when(inputData.getFilter()).thenReturn("CuisineType");
        when(inputData.getKeyword()).thenReturn("Tomato");
        when(inputData.getCuisineType()).thenReturn(new Cuisine("Italian"));
        Recipe mockRecipe = new Recipe("Tomato Pasta", 500, new Cuisine("Italian"), null, new String[]{"Tomato"});
        when(recipeDataBase.getAllRecipes("Tomato", null, "Italian", 0, 0))
                .thenReturn(Collections.singletonList(mockRecipe));

        // Act
        interactor.searchRandomRecipe(inputData);

        // Assert
        verify(randomOutputBoundary, times(1)).presentRecipes(argThat(output ->
                output.getRecipes().contains(mockRecipe)
        ));
    }

    @Test
    void testSearchRandomRecipeWithCaloriesFilter() throws IOException {
        // Arrange
        RandomInputData inputData = mock(RandomInputData.class);
        when(inputData.getFilter()).thenReturn("Calories");
        when(inputData.getKeyword()).thenReturn("Tomato");
        when(inputData.getCaloriesRange()).thenReturn(new CaloriesRange(100, 300));
        Recipe mockRecipe = new Recipe("Tomato Soup", 200, null, null, new String[]{"Tomato"});
        when(recipeDataBase.getAllRecipes("Tomato", null, null, 100, 300))
                .thenReturn(Collections.singletonList(mockRecipe));

        // Act
        interactor.searchRandomRecipe(inputData);

        // Assert
        verify(randomOutputBoundary, times(1)).presentRecipes(argThat(output ->
                output.getRecipes().contains(mockRecipe)
        ));
    }

    @Test
    void testSearchRandomRecipeWithDietFilter() throws IOException {
        // Arrange
        RandomInputData inputData = mock(RandomInputData.class);
        when(inputData.getFilter()).thenReturn("Diet");
        when(inputData.getKeyword()).thenReturn("Tomato");
        when(inputData.getDietLevel()).thenReturn(new Diet(new String[]{"low-carb"}));
        Recipe mockRecipe = new Recipe("Tomato Soup", 0, null, null, new String[]{"Tomato"});
        when(recipeDataBase.getAllRecipes("Tomato", "low-carb", null, 0, 0))
                .thenReturn(Collections.singletonList(mockRecipe));

        // Act
        interactor.searchRandomRecipe(inputData);

        // Assert
        verify(randomOutputBoundary, times(1)).presentRecipes(argThat(output ->
                output.getRecipes().contains(mockRecipe)
        ));
    }

    @Test
    void testFilterLoop() {
        List<String> filters = new ArrayList<>();
        filters.add("Diet");
        filters.add("CuisineType");
        filters.add("Calories");
        filters.add("Keyword");
        List<String> resultList = new ArrayList<>();
        int maxAttempts = 100000;
        int attempts = 0;

        // While not all filters are added to resultList, and max attempts are not reached
        while (resultList.size() < filters.size() && attempts < maxAttempts) {
            RandomInputData randomInputData = new RandomInputData();
            String filter = randomInputData.getFilter();

            // Add filter only if it's in the filters list and hasn't been added yet
            if (filters.contains(filter) && !resultList.contains(filter)) {
                resultList.add(filter);
            }
            attempts++;
        }
        assertEquals(filters.size(), resultList.size(), "All filters should be included.");
        assertTrue(resultList.containsAll(filters), "Result should contain all filters.");
    }
}