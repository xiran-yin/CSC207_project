package interface_adapter.diet_level;

import usecase.diet_level.DietLevelInputBoundary;
import usecase.diet_level.DietLevelInputData;

/**
 * The Controller for Diet Use Case.
 */
public class DietLevelController {
    private final DietLevelInputBoundary dietLevelInputBoundary;

    public DietLevelController(DietLevelInputBoundary dietLevelInputBoundary) {
        this.dietLevelInputBoundary = dietLevelInputBoundary;
    }

    /**
     * Executes the Diet use case.
     * @param keyword the keyword entered for recipe search
     * @param dietlevel the Diet eneter for recipe search
     */
    public void searchDietLevelRecipe(String keyword, String dietlevel) {
        final DietLevelInputData dietLevelInputData = new DietLevelInputData(keyword, dietlevel);
        dietLevelInputBoundary.searchDietLevelRecipe(dietLevelInputData);
    }
}
