package usecase.KeyWord;

import api.RecipeDataBase;
import entity.Recipe;

import java.io.IOException;
import org.json.JSONException;
import java.util.Collections;
import java.util.List;

public class KeywordUseCase {

    private final RecipeDataBase recipeDataBase;

    public KeywordUseCase(RecipeDataBase recipeDataBase) {
        this.recipeDataBase = recipeDataBase;
    }

    public List<Recipe> getRecipes(String keyword) {
        try {
            return recipeDataBase.getAllRecipes(keyword, null, null, 0, 0);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}


