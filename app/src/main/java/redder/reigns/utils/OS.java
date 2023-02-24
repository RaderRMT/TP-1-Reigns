package redder.reigns.utils;

public class OS {

    public static String getHomeFolder() {
        return System.getProperty("user.home") + "/.reigns/";
    }
}
