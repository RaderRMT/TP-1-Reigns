package redder.reigns.utils;

import java.util.Scanner;

public class Input {

    private static final Scanner scanner;

    public static String readString() {
        return scanner.nextLine();
    }

    public static int readClampedInt(int min, int max) {
        return MathUtils.clamp(readInt(), min, max);
    }

    public static int readInt() {
        return scanner.nextInt();
    }

    static {
        scanner = new Scanner(System.in);
    }
}
