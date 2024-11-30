package api;
import java.io.IOException;
import java.util.List;
import entity.Cuisine;
import entity.Diet;
import entity.Recipe;
import org.json.JSONException;
import org.json.JSONObject;

public interface RecipeDataBase {

    // Fetches all recipes based on criteria
    List<Recipe> getAllRecipes(String keyword, String diet, String cuisine, int mincalories, int maxcalories) throws IOException, JSONException;

    // Fetches a single recipe (first from the list)
    Recipe getRecipe(String keyword, String diet, String cuisine, int mincalories, int maxcalories) throws JSONException;

    // Retrieves the calories of a recipe based on a JSON object
    double getCalories(JSONObject recipeObject) throws JSONException;

    // Retrieves the diet labels of a recipe based on a JSON object
    Diet getDietLabels(JSONObject recipeObject) throws JSONException;

    // Retrieves the ingredients of a recipe based on a JSON object
    String[] getIngredients(JSONObject recipeObject) throws JSONException;

    // Retrieves the cuisine type of a recipe based on a JSON object
    Cuisine getCuisineType(JSONObject recipeObject) throws JSONException;
}
