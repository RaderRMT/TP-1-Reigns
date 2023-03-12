package redder.reigns;

import com.google.gson.Gson;
import redder.reigns.utils.OS;

import java.io.*;

public class ConfigReader {

    private static final char[] BUFFER = new char[4096];

    /**
     * Read a JSON file and deserialize to an instance with the given class
     *
     * @param clazz The class to instantiate
     * @param path  The path to the JSON file
     * @return      An instance of the given class
     * @param <T>   The class type
     */
    public static <T> T read(Class<T> clazz, String path) {
        File configFile = new File(path);
        // extract the file if it hasn't been extracted
        if (!configFile.exists()) {
            extractFile(configFile);
        }

        Object instance = null;
        // create a new instance of the given class
        try (FileReader reader = new FileReader(configFile)) {
            instance = new Gson().fromJson(reader, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clazz.cast(instance);
    }

    /**
     * Extract the given file from the resources folder to the path denoted by the given file
     *
     * @param file  The file to extract
     */
    private static void extractFile(File file) {
        // create the parent directory for the file
        file.getParentFile().mkdirs();

        // we get the resource path from the file path
        String resourceFile = file.getAbsolutePath().substring(OS.getHomeFolder().length());

        // we get the actual resource from the jar file
        InputStream resourceStream = ConfigReader.class.getResourceAsStream('/' + resourceFile);
        if (resourceStream == null) {
            throw new IllegalStateException("The following resource does not exist: " + resourceFile);
        }

        try (
                InputStreamReader reader = new InputStreamReader(resourceStream);
                FileWriter writer = new FileWriter(file)
        ) {
            // we copy the bytes from the resource file to the destination file
            int bytesRead;
            while ((bytesRead = reader.read(BUFFER)) != -1) {
                writer.write(BUFFER, 0, bytesRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
