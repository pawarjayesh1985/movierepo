package ksubaka.util;

import com.google.gson.Gson;

/**
 * Created by jpawar on 11/8/2020.
 */
public class JsonUtils {
    private Gson json;

    private JsonUtils() {
        this.json = this.createJson();
    }

    public Gson createJson() {
        Gson gson = new Gson();
        return gson;
    }

    public static JsonUtils getInstance() {
        return JsonUtils.JsonUtilHolder.INSTANCE;
    }
    public <T> String writeValueAsString(T instance) {
        String json = this.json.toJson(instance);
        return json;
    }

    private static class JsonUtilHolder {
        static final JsonUtils INSTANCE = new JsonUtils();

        private JsonUtilHolder() {
        }
    }

    public <T> T getObjectFromResponse(String response, Class<T> clazz) throws Exception {
        return this.json.fromJson(response, clazz);
    }

}
