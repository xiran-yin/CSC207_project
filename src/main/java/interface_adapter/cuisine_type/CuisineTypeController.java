package interface_adapter.cuisine_type;

import usecase.cuisine_type.CuisineTypeInputBoundary;
import usecase.cuisine_type.CuisineTypeInputData;

/**
 * The Controller for Cuisine Use Case.
 */
public class CuisineTypeController {
    private final CuisineTypeInputBoundary cuisineUseCaseInteractor;

    public CuisineTypeController(CuisineTypeInputBoundary cuisineUseCaseInteractor) {
        this.cuisineUseCaseInteractor = cuisineUseCaseInteractor;
    }

    /**
     * Execute the Cuisine Use Case.
     * @param keyword the keyword of the search
     * @param cuisine the cuisine of the search
     */
    public void cuisineRecipes(String keyword, String cuisine) {
        // Create input data for the use case
        final CuisineTypeInputData inputData = new CuisineTypeInputData(keyword, cuisine);
        // Delegate the search to the interactor
        cuisineUseCaseInteractor.searchCuisineRecipe(inputData);
    }
}
