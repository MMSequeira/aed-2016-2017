package pt.europeia.aed.exams.er20170720t2000;

import static java.lang.System.out;

import java.util.Arrays;

public final class InstrumentedTernarySearch {

    private static long numberOfIterations;
    private static long numberOfComparisons;

    private InstrumentedTernarySearch() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static int positionOf(final double[] values, final double key) {
        resetCounts();

        int first = 0;
        int last = values.length - 1;

        while (first <= last) {
            numberOfIterations++;

            final int middleLeft = first + (last - first) / 3;
            final int middleRight = last - (last - first) / 3;

            final int middleLeftComparison = compare(key, values[middleLeft]);
            final int middleRightComparison = compare(key, values[middleRight]);

            if (middleLeftComparison < 0)
                // Next search in the left third of the current segment:
                last = middleLeft - 1;
            else {
                if (middleLeftComparison > 0)
                    if (middleRightComparison < 0) {
                        // Next search in the middle third of the current
                        // segment:
                        first = middleLeft + 1;
                        last = middleRight - 1;
                    } else {
                        if (middleRightComparison > 0)
                            // Next search in right third of the current
                            // segment:
                            first = middleRight + 1;
                        else
                            // Found in middle right:
                            return middleRight;
                    }
                else
                    // Found in middle right:
                    return middleLeft;
            }
        }

        return -1;
    }

    private static int compare(final double first, final double second) {
        numberOfComparisons++;

        if (first < second)
            return -1;
        if (first > second)
            return 1;
        return 0;
    }

    public static void resetCounts() {
        numberOfIterations = 0L;
        numberOfComparisons = 0L;
    }

    public static long getNumberOfIterations() {
        return numberOfIterations;
    }

    public static long getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public static void main(final String[] arguments) {
        final double[] values = { 10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0,
            80.0, 90.0 };
        final double key = 55.0;

        out.println("Searching for " + key + " in " + Arrays.toString(values)
                + ".");

        final int position = positionOf(values, key);

        out.println("Found in position: " + position);

        out.println("Counts:");
        out.println("\tNumber of iterations: " + getNumberOfIterations());
        out.println("\tNumber of comparisons: " + getNumberOfComparisons());
    }

}

/*
 * Copyright 2015 and 2016, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2015-2017, Manuel Menezes de Sequeira.
 *
 * This file is a derivative work of the code which accompanies the textbook
 *
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
 *
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this code. If not, see http://www.gnu.org/licenses.
 *
 * Any errors found in this code should be assumed to be the responsibility of
 * the author of the modifications to the original code (viz. Manuel Menezes de
 * Sequeira).
 */