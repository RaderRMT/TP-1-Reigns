package redder.reigns.utils;

public class MathUtils {

    /**
     * Clamp an integer value between a provided min and max value.
     * If value is less than min, min will be returned,
     * if value is greater than max, max will be returned,
     * otherwise value will be returned
     *
     * @param value The value to clamp
     * @param min   The min value
     * @param max   The max value
     * @return      The clamped value
     */
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        }

        return Math.min(value, max);
    }
}
