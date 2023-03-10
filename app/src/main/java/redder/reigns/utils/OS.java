package redder.reigns.utils;

public class OS {

    /**
     * Return the app's home folder, this will always be at the same location:<br>
     * - Windows: {@code %userprofile%\.reigns\ }<br>
     * - *nix: {@code ~/.reigns/ }<br>
     *
     * @return  The app's home folder
     */
    public static String getHomeFolder() {
        return System.getProperty("user.home") + "/.reigns/";
    }
}
