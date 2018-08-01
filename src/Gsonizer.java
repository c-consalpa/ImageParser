import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;

public class Gsonizer<PRODUCT_KEY, SETTING_NAME, SETTING_VALUE> {
    private HashMap<PRODUCT_KEY, HashMap<SETTING_NAME, SETTING_VALUE>> data;
    private Gson gson;
    public Gsonizer(HashMap<PRODUCT_KEY, HashMap<SETTING_NAME, SETTING_VALUE>> data) {
        this.data = data;
        gson = new Gson();
    }

    public String getJson() {
        String jsonData = gson.toJson(data);
        return jsonData;
    }







}
