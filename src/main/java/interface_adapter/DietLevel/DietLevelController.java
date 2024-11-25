package interface_adapter.DietLevel;

import usecase.DietLevel.DietLevelInputBoundary;
import usecase.DietLevel.DietLevelInputData;

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
