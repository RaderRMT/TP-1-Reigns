package redder.reigns.utils;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner;

    /**
     * Read the string the user wrote
     *
     * @return  A string written by the user
     */
    public static String readString() {
        return scanner.nextLine();
    }

    /**
     * Read an integer number from the user, clamp it between
     * a provided min and max, and return it
     *
     * @param min   The clamp's min value
     * @param max   The clamp's max value
     * @return      The clamped value
     * @see MathUtils#clamp(int, int, int)
     */
    public static int readClampedInt(int min, int max) {
        return MathUtils.clamp(readInt(), min, max);
    }

    /**
     * Read the integer number the user wrote
     *
     * @return  An int written by the user
     */
    public static int readInt() {
        return scanner.nextInt();
    }

    static {
        scanner = new Scanner(System.in);
    }
}
