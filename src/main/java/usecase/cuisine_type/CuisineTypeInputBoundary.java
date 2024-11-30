package usecase.cuisine_type;

/**
 * The Input Boundary of the Cuisine Search Use Case.
 */
public interface CuisineTypeInputBoundary {
    /**
     * Execute the Cuisine Use Case.
     * @param cuisineTypeInputData the input data
     */
    void searchCuisineRecipe(CuisineTypeInputData cuisineTypeInputData);
}
