package interface_adapter.diet_level;

import usecase.diet_level.DietLevelInputBoundary;
import usecase.diet_level.DietLevelInputData;

public class DietLevelController {
    private final DietLevelInputBoundary dietLevelInputBoundary;

    public DietLevelController(DietLevelInputBoundary dietLevelInputBoundary) {
        this.dietLevelInputBoundary = dietLevelInputBoundary;
    }

    public void searchDietLevelRecipe(String keyword, String dietlevel){
        final DietLevelInputData dietLevelInputData = new DietLevelInputData(keyword, dietlevel);
        dietLevelInputBoundary.searchDietLevelRecipe(dietLevelInputData);
    }
}
