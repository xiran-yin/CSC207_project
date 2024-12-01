package api;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import entity.Cuisine;
import entity.Diet;
import entity.Recipe;

/**
 * Interface to Connect API.
 */
public interface RecipeDataBase {

    /**
     * Connect with API, Fetches all recipes based on criteria.
     * @param keyword the keyword
     * @param diet the diet label
     * @param cuisine the cuisine
     * @param mincalories the minimum calories
     * @param maxcalories the maximum calories
     * @return all recipes
     * @throws IOException the exception
     * @throws JSONException the exception
     */
    List<Recipe> getAllRecipes(String keyword, String diet, String cuisine,
                               int mincalories, int maxcalories) throws IOException, JSONException;

    /**
     * Retrieves the calories of a recipe based on a JSON object.
     * @param recipeObject the json file from api
     * @return calories
     * @throws JSONException the exception
     */
    double getCalories(JSONObject recipeObject) throws JSONException;

    /**
     * Retrieves the diet labels of a recipe based on a JSON object.
     * @param recipeObject the json file from api
     * @return diet labels
     * @throws JSONException the exception
     */
    Diet getDietLabels(JSONObject recipeObject) throws JSONException;

    /**
     * Retrieves the ingredients of a recipe based on a JSON object.
     * @param recipeObject the json file from api
     * @return calories
     * @throws JSONException the exception
     */
    String[] getIngredients(JSONObject recipeObject) throws JSONException;

    /**
     * Retrieves the cuisine type of a recipe based on a JSON object.
     * @param recipeObject the json file from api
     * @return calories
     * @throws JSONException the exception
     */
    Cuisine getCuisineType(JSONObject recipeObject) throws JSONException;
}
