import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Map<String, File> products;
        ImageData mData = new ImageData();


        setupConfigs();

        products = FSUtils.getProducts(FSUtils.ABS_PATH);
        for (String productName : products.keySet()) {
                mData.add(productName, getProductEntry(productName, products));
        }

        Gsonizer gsonizer = new Gsonizer(mData.payload);
        String json = gsonizer.getJson();

        FSUtils.writeFile(json);
}

    private static void setupConfigs() {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("");
        System.out.println("Enter the absolute to the Flare project folder.\r\n(E.g: \"D:\\eam-xe-xes-help-center\") :");
        String tmp = null;
        while(sc.hasNext()) {
            tmp = sc.nextLine();
            if (!tmp.isEmpty()) {
                FSUtils.ABS_PATH = tmp;
                break;
            } else {
                System.out.println("The path to the Flare project should be specified!");
            }
        }

    }

    private static HashMap<String, Object> getProductEntry(String productName, Map<String, File> products) {
        HashMap<String, Object> imageDataEntry = new HashMap<>();
        String logoImageFileName = products.get(productName).getName();
        int logoWidth;
        int logoHeight;
        String backgroundImageFileName;

        File imageFile = products.get(productName);
        SimpleImageInfo simpleImageInfo = null;
        try {
            simpleImageInfo = new SimpleImageInfo(imageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logoWidth = simpleImageInfo.getWidth();
        logoHeight = simpleImageInfo.getHeight();
        backgroundImageFileName = productName + "BCK.png";

        imageDataEntry.put("logoImageFileName", logoImageFileName);
        imageDataEntry.put("logoWidth", new Integer(logoWidth));
        imageDataEntry.put("logoHeight", new Integer(logoHeight));
        imageDataEntry.put("backgroundImageFileName", backgroundImageFileName);

        return imageDataEntry;
    }
}
