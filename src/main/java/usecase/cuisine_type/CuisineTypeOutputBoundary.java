package usecase.cuisine_type;

/**
 * The Output Boundary of the Cuisine Search Use Case.
 */
public interface CuisineTypeOutputBoundary {
    /**
     * Prepare the view for Final Recipe.
     * @param cuisineTypeOutputData the output data
     */
    void presentRecipesCuisine(CuisineTypeOutputData cuisineTypeOutputData);
}
