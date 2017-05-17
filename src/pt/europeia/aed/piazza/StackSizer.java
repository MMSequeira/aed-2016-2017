package pt.europeia.aed.piazza;

import static java.lang.System.out;

public class StackSizer {

    private static long numberOfCalls = 0;

    public static void recurse() {
        numberOfCalls++;
        recurse();
    }

    public static void main(final String[] arguments) {
        numberOfCalls++;

        try {
            recurse();
        } catch (final StackOverflowError error) {
            out.println("Number of calls: " + numberOfCalls);
        }
    }

}
