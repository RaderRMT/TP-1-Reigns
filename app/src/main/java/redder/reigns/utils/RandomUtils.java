package redder.reigns.utils;

import java.util.List;

public class RandomUtils {

    /**
     * Generate a random number between the given minimum and maximum value
     *
     * @param min   The minimum value
     * @param max   The maximum value
     * @return      A random number between {@code min} and {@code max}
     * @see         Math#random()
     */
    public static int between(int min, int max) {
        Checks.greaterThan(max, min, "Minimum must be smaller than maximum");

        return (int) (min + Math.random() * (max - min));
    }

    /**
     * Returns a random object in the given list
     *
     * @param list  The list to get a random object from
     * @param <T>   The type of the object in the list
     * @return      A random object in the given list
     */
    public static <T> T randomObject(List<T> list) {
        Checks.notNull(list, "List cannot be null");

        return list.get(between(0, list.size()));
    }
}
