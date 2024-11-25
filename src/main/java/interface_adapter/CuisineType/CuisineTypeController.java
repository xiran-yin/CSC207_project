package interface_adapter.CuisineType;

import usecase.CuisineType.CuisineTypeInputBoundary;
import usecase.CuisineType.CuisineTypeInputData;

public class CuisineTypeController {
    private final CuisineTypeInputBoundary cuisineUseCaseInteractor;

    public CuisineTypeController(CuisineTypeInputBoundary cuisineUseCaseInteractor) {
        this.cuisineUseCaseInteractor = cuisineUseCaseInteractor;
    }

    public void cuisineRecipes(String keyword, String cuisine) {
        // Create input data for the use case
        CuisineTypeInputData inputData = new CuisineTypeInputData(keyword, cuisine);

        // Delegate the search to the interactor
        cuisineUseCaseInteractor.searchCuisineRecipe(inputData);
    }
}
