import java.io.Serializable;
import java.util.HashMap;

public class ImageData implements Serializable {
    public  HashMap<String, HashMap<String, Object>> payload;
    public ImageData() {
        payload = new HashMap<>();
    }


    public void add(String productName, HashMap<String, Object> imageEntry) {
        payload.put(productName, imageEntry);
    }

}
