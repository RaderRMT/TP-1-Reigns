package redder.reigns.utils;

import redder.reigns.IDisplayable;
import redder.reigns.localization.I18n;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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

    /**
     * Print the given list's values with it's associated index
     * and wait for the user to enter a number before returning.
     *
     * <p>The return value will be clamped between 0 and the length
     * of the array minus one
     *
     * @param array The values to print
     * @return      The selected entry index
     */
    public static <T extends IDisplayable> int getUserInputIndexFromArray(T[] array) {
        // we need an atomic integer so we can update it in the stream map
        AtomicInteger index = new AtomicInteger();
        System.out.println(
                Arrays.stream(array)
                        .map(elem -> I18n.format("input.for", index.incrementAndGet(), elem.getDisplayName()))
                        .collect(Collectors.joining(", "))
        );

        return Input.readClampedInt(1, array.length) - 1;
    }

    static {
        scanner = new Scanner(System.in);
    }
}
