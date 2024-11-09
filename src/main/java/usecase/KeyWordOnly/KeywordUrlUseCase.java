package usecase.KeyWordOnly;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KeywordUrlUseCase {
    //define some constent
    private static final String API_URL = "https://api.edamam.com/api/recipes/v2?type=public";
    private static final String STATUS_CODE = "status_code";
    private static final int SUCCESS_CODE = 200;

    //这是我自己account的id 和 key
    private static final String APP_ID = "7e6602a1";
    private static final String APP_KEY = "a6c9d7096dd6346a6aecc6c4bcdc3824";

    public String GetKeywordURL(String keyword) {
        String url = String.format("%s&q=%s&app_id=%s&app_key=%s", API_URL, keyword, APP_ID, APP_KEY);
        return url;
    }

    public static List<String> GetKeywordFoods(String keyword) {
        final OkHttpClient client = new OkHttpClient().newBuilder().build();

        final Request request = new Request.Builder()
                .url(String.format("%s&q=%s&app_id=%s&app_key=%s", API_URL, keyword, APP_ID, APP_KEY))
                .build();

        List<String> labels = new ArrayList<>();

        try {
            final Response response = client.newCall(request).execute();
            String responseBody = response.body().string();
            int statusCode = response.code();
            if (statusCode == SUCCESS_CODE) {
                JSONObject jsonObject = new JSONObject(responseBody);
                JSONArray hits = jsonObject.getJSONArray("hits");

                for (int i = 0; i < hits.length() && labels.size() < 5; i++) {
                    JSONObject recipeObject = hits.getJSONObject(i).getJSONObject("recipe");
                    String label = recipeObject.getString("label");
                    labels.add(label);
                }
            } else {
                System.out.println("Request was not successful. Status code: " + response.code());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return labels;
    }
}

