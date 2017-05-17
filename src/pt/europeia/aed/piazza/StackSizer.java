package pt.europeia.aed.piazza;

import static java.lang.System.out;

// Don't do this at home! You are not supposed to recover from a
// StackOverflowError, which is an Error, that is, a serious problem "that a
// reasonable application should not try to catch" (see
// https://docs.oracle.com/javase/8/docs/api/java/lang/Error.html). 
//
// Run this code with different values of option -Xss passed to the JVM. For
// instance:
// -Xss1m
// -Xss16m
// -Xss256m
// -Xss1g
// -Xss2g
// -Xss3g
// -Xss4g
//
// Apparently, there is a bug in the implementation of option -Xss which is
// noticeable for large values of the stack size.

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
