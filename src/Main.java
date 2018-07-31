import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ImageParser imageParser = new ImageParser("imgs");
        List<File> files = imageParser.findImageFiles();
        try {
            imageParser.parseImageFile(files.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
