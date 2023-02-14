package redder.reigns.utils;

public class Checks {

    /**
     * Throw an {@link AssertionError} if the object instance is null
     *
     * @param object    The object to check
     * @param error     The error message
     */
    public static void notNull(Object object, String error) {
        if (object == null) {
            throw new AssertionError(error);
        }
    }

    /**
     * Throws an {@link AssertionError} if {@code a} is smaller than {@code b}
     *
     * Examples:
     * <table border="1">
     *     <tr>
     *         <td>A</td>
     *         <td>B</td>
     *         <td>Throw Error?</td>
     *         <td>Reason</td>
     *     </tr>
     *     <tr>
     *         <td>5</td>
     *         <td>10</td>
     *         <td>Yes</td>
     *         <td>A is smaller than B</td>
     *     </tr>
     *     <tr>
     *         <td>10</td>
     *         <td>10</td>
     *         <td>No</td>
     *         <td></td>
     *     </tr>
     *     <tr>
     *         <td>10</td>
     *         <td>5</td>
     *         <td>No</td>
     *         <td></td>
     *     </tr>
     *     <caption>Truth table for A >= B</caption>
     * </table>
     *
     * @param a     The value that should be greater
     * @param b     The value that {@code a} should be checked against
     * @param error The error message
     */
    public static void greaterThan(int a, int b, String error) {
        if (a < b) {
            throw new AssertionError(error);
        }
    }
}
