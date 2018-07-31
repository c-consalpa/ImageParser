import javax.imageio.stream.FileImageInputStream;
import java.awt.*;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;

public class ImageParser {
    private File imagesDir;
    public ImageParser(String pathToImgDir) {
        this.imagesDir = new File(pathToImgDir);
    }

    public List<File> findImageFiles() {
        File[] imgFilesArr = imagesDir.listFiles((dir, name) -> {
        for (Extensionsions ext : Extensionsions.values()) {
            return name.toUpperCase().endsWith(ext.toString()) ? true : false;
        }
            return false; });
        List<File> images = Arrays.asList(imgFilesArr);
        return images;
    }

    public void parseImageFile(File file) throws IOException {
        FileChannel fOut = new FileOutputStream("test.png").getChannel();
        FileChannel fIn = new RandomAccessFile(file, "rw").getChannel();
        fIn.transferTo(0, fIn.size(), fOut);

        SimpleImageInfo imageInfo = new SimpleImageInfo(file);



    }
}
