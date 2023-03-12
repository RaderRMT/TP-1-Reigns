package redder.reigns.localization;

import redder.reigns.ConfigReader;
import redder.reigns.utils.OS;

import java.util.HashMap;
import java.util.Map;

public class I18n {

    private static I18n instance;
    private static String langFile;

    private final Map<String, String> texts;

    private I18n() {
        this.texts = new HashMap<>();
    }

    /**
     * Set the game's language to the given language
     *
     * @param lang  The language to use
     */
    public static void setLang(String lang) {
        langFile = OS.getHomeFolder() + "langs/" + lang + ".json";
    }

    /**
     * Get a translation from the given key
     *
     * @param key   The key
     * @return      The translation
     */
    public static String get(String key) {
        String value = getInstance().texts.get(key);

        return value == null ? key : value;
    }

    /**
     * Format the string at the given key with the given objects
     *
     * @param key       The key to format
     * @param values    The values to use in the format
     * @return          The formatted translated string
     */
    public static String format(String key, Object... values) {
        return String.format(get(key), values);
    }

    /**
     * Print a translation from the given key
     *
     * @param key   The key
     */
    public static void print(String key) {
        System.out.println(get(key));
    }

    /**
     * Print the formatted string at the given key with the given objects
     *
     * @param key       The key to format
     * @param values    The values to use in the format
     */
    public static void printFormat(String key, Object... values) {
        System.out.println(format(key, values));
    }

    private static I18n getInstance() {
        if (instance == null) {
            instance = ConfigReader.read(I18n.class, langFile);
        }

        return instance;
    }
}
