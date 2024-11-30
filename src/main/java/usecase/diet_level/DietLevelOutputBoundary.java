package usecase.diet_level;

/**
 * The Output Boundary of the Diet Search Use Case.
 */
public interface DietLevelOutputBoundary {
    /**
     * Prepare the view for final Recipe.
     * @param dietLevelOutputData the output data.
     */
    void presentRecipesDiet(DietLevelOutputData dietLevelOutputData);
}
