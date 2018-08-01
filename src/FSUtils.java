import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FSUtils {
    static String ABS_PATH = "";
    static String OUTPUT_FILE_NAME = "test.js";

    public static Map<String, File> getProducts(String absPath) {
        Map<String, File> products = new HashMap();
        String FlareRelPath = "\\Content\\Resources\\Images";

        File imagesDir =  new File(absPath, FlareRelPath);
        if (!imagesDir.exists()) {
            try {
                throw new FileNotFoundException("Can't find dir: " + imagesDir);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        imagesDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.equals("LogoEdifecs.png")) return false;

                Pattern p = Pattern.compile("LOGO([A-Z]+)\\.PNG");
                Matcher matcher = p.matcher(name.toUpperCase());
                if (matcher.matches()) {
                    products.put(matcher.group(1), new File(dir, name));
                    return true;
                }
                return false;
            }
        });
        return products;
    }

    public static void writeFile(String json) {
        try {
            FileChannel fc = new FileOutputStream(OUTPUT_FILE_NAME).getChannel();
            ByteBuffer bf = ByteBuffer.wrap(json.getBytes());
            fc.write(bf);
            fc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
