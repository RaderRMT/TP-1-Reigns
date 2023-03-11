package redder.reigns.localization;

import com.google.gson.Gson;
import redder.reigns.utils.OS;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class I18n {

    private static I18n instance;
    private static File langFile;

    private final Map<String, String> texts;

    private I18n() {
        this.texts = new HashMap<>();
    }

    public static void setLang(String lang) {
        langFile = new File(OS.getHomeFolder() + "langs/" + lang + ".json");
    }

    public static String get(String key) {
        String value = getInstance().texts.get(key);

        return value == null ? key : value;
    }

    public static String format(String key, Object... values) {
        return String.format(get(key), values);
    }

    public static void print(String key) {
        System.out.println(get(key));
    }

    public static void printFormat(String key, Object... values) {
        System.out.println(format(key, values));
    }

    private static I18n getInstance() {
        if (instance == null) {
            try (FileReader reader = new FileReader(langFile)) {
                instance = new Gson().fromJson(reader, I18n.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return instance;
    }
}
