package api;

import entity.Cuisine;
import entity.Diet;
import entity.Recipe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class getRecipeDataBase implements RecipeDataBase {
    private static final String API_URL = "https://api.edamam.com/api/recipes/v2?type=public";
    private static final String APP_ID = "7e6602a1";
    private static final String APP_KEY = "a6c9d7096dd6346a6aecc6c4bcdc3824";
    private static final int SUCCESS_CODE = 200;


    // Helper to call API
    private JSONObject callAPI(String keyword, String diet, String cuisine, int minCalories, int maxCalories) throws IOException, JSONException {
        StringBuilder url = new StringBuilder(
                String.format("%s&q=%s&app_id=%s&app_key=%s", API_URL, keyword != null ? keyword : "", APP_ID, APP_KEY)
        );

        if (diet != null && !diet.isEmpty()) {
            url.append("&diet=").append(diet);
        }
        if (cuisine != null && !cuisine.isEmpty()) {
            url.append("&cuisineType=").append(cuisine);
        }
        if (minCalories >= 0 && maxCalories > 0 && minCalories < maxCalories) {
            url.append("&calories=").append(minCalories).append("-").append(maxCalories);
        }

        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url.toString())
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() == SUCCESS_CODE) {
                String responseBody = response.body().string();
                return new JSONObject(responseBody); // Convert response to JSONObject
            } else {
                System.out.println("Request failed. Status code: " + response.code());
            }
        }
        return null;
    }


    @Override
    public List<Recipe> getAllRecipes(String keyword, String diet, String cuisine, int minCalories, int maxCalories) throws IOException, JSONException {
        JSONObject apiResponse = callAPI(keyword, diet, cuisine, minCalories, maxCalories);
        JSONArray hits = apiResponse.optJSONArray("hits");
        if (hits == null || hits.length() == 0) {
            return null;
        }
        List<Recipe> recipes = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            JSONObject recipeObject = hits. getJSONObject(i).getJSONObject( "recipe");
            String label = recipeObject.getString( "label");
            double calories = getCalories(recipeObject);
            Cuisine cuisineType = getCuisineType(recipeObject);
            Diet dietLabels = getDietLabels(recipeObject);
            String[] ingredients = getIngredients(recipeObject);
// Add the recipe to the list
        recipes.add (new Recipe(label, calories, cuisineType, dietLabels, ingredients));
    }
        return recipes;
    }

    @Override
    public Recipe getRecipe(String keyword, String diet, String cuisine, int mincalories, int maxcalories) throws JSONException {
        return null;
    }

    @Override
    public double getCalories(JSONObject recipeObject) throws JSONException {
        return recipeObject.getDouble("calories");
    }

    @Override
    public Diet getDietLabels(JSONObject recipeObject) throws JSONException {
        JSONArray dietLabelsArray = recipeObject.optJSONArray("dietLabels");
        String[] dietLabels = new String[dietLabelsArray.length()];
        for (int i = 0; i < dietLabelsArray.length(); i++) {
            dietLabels[i] = dietLabelsArray.getString(i);
        }
        return new Diet(dietLabels);    }

    @Override
    public String[] getIngredients(JSONObject recipeObject) throws JSONException {
        JSONArray ingredientLines = recipeObject.getJSONArray("ingredientLines");
        String[] ingredients = new String[ingredientLines.length()];
        for (int i = 0; i < ingredientLines.length(); i++) {
            ingredients[i] = ingredientLines.getString(i);
        }
        return ingredients;    }

    @Override
    public Cuisine getCuisineType(JSONObject recipeObject) throws JSONException {
        String cuisineTypeString = recipeObject.getJSONArray("cuisineType").getString(0);
        return new Cuisine(cuisineTypeString);    }
}
