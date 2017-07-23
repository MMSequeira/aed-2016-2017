package pt.europeia.aed.exams.er20170720t2000;

import static java.lang.System.out;

import java.util.Arrays;

public final class InstrumentedBubble {

    private static long numberOfComparisons;
    private static long numberOfSwaps;

    public static void sort(final double[] values) {
        resetCounts();

        for (int n = values.length; n > 1; n--)
            for (int i = 0; i < n - 1; i++) {
                numberOfComparisons++;
                
                if (values[i + 1] < values[i])
                    swap(values, i, i + 1);
            }
    }

    private static void swap(final double[] values, final int i, final int j) {
        numberOfSwaps++;
        
        final double temporary = values[i];
        values[i] = values[j];
        values[j] = temporary;
    }

    public static void resetCounts() {
        numberOfComparisons = 0L;
        numberOfSwaps = 0L;
    }

    public static long getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public static long getNumberOfSwaps() {
        return numberOfSwaps;
    }

    private static void experimentWith(final double[] values) {        
        final int N = values.length;

        out.println("\t\tSize (N): " + N);
        out.println("\t\tBefore sorting: " + Arrays.toString(values));

        sort(values);

        out.println("\t\tAfter sorting: " + Arrays.toString(values));

        out.println("\t\tNumber of comparisons is " + getNumberOfComparisons()
                + " should be (N - 1) N/2 = " + (N - 1) * N / 2);
        out.println("\t\tNumber of swaps is " + getNumberOfSwaps()
        + " should be between 0 and (N - 1) N/2 = " + (N - 1) * N / 2);
    }

    public static void main(final String[] arguments) {
        out.println("Bubble sort experiments:");

        out.println("\tBest case: increasing");
        experimentWith(new double[] { 10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0,
            80.0, 90.0, 100.0 });

        out.println("\tWorst case: decreasing");
        experimentWith(new double[] { 100.0, 90.0, 80.0, 70.0, 60.0, 50.0, 40.0,
            30.0, 20.0, 10.0 });
    }
}

/*
 * Copyright 2017, Manuel Menezes de Sequeira.
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