import java.util.HashMap;
import java.util.Map;

public class ImageDataObject {
    private HashMap<String, HashMap<String, String>> mData;
    public ImageDataObject() {

    }
    public void addImageData(String imageFileName, HashMap<String, String> imageEntry) {
        mData.put(imageFileName, imageEntry);
    }

}
