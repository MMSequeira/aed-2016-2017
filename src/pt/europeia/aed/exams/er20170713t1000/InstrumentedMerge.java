package pt.europeia.aed.exams.er20170713t1000;

import static java.lang.System.out;

import java.util.Arrays;

public final class InstrumentedMerge {

    private static long numberOfSortCalls;
    private static long maximumNumberOfInProgressSortCalls;
    private static long numberOfMergeCalls;
    private static long numberOfArrayItemCopies;
    private static long numberOfValueComparisons;

    private InstrumentedMerge() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static void sort(final double[] values) {
        resetCounts();
        
        final double[] auxiliary = new double[values.length];

        sort(values, auxiliary, 0, values.length - 1, 1);
    }

    private static void sort(final double[] values, final double[] auxiliary,
            final int first, final int last,
            final int numberOfInProgressSortCalls) {
        numberOfSortCalls++;

        if (numberOfInProgressSortCalls > maximumNumberOfInProgressSortCalls)
            maximumNumberOfInProgressSortCalls = numberOfInProgressSortCalls;

        if (last <= first)
            return;

        final int middle = first + (last - first) / 2;

        sort(values, auxiliary, first, middle, numberOfInProgressSortCalls + 1);
        sort(values, auxiliary, middle + 1, last,
                numberOfInProgressSortCalls + 1);

        numberOfValueComparisons++;
        if (values[middle + 1] < values[middle])
            merge(values, auxiliary, first, middle, last);
    }

    private static void merge(final double[] values, final double[] auxiliary,
            final int first, final int middle, final int last) {
        numberOfMergeCalls++;

        for (int i = first; i <= last; i++) {
            numberOfArrayItemCopies++;
            auxiliary[i] = values[i];
        }

        int i = first;
        int j = middle + 1;

        for (int k = first; k <= last; k++)
            if (i > middle) {
                numberOfArrayItemCopies++;
                values[k] = auxiliary[j];
                j++;
            } else if (j > last) {
                numberOfArrayItemCopies++;
                values[k] = auxiliary[i];
                i++;
            } else {
                numberOfValueComparisons++;
                if (auxiliary[j] < auxiliary[i]) {
                    numberOfArrayItemCopies++;
                    values[k] = auxiliary[j];
                    j++;
                } else {
                    numberOfArrayItemCopies++;
                    values[k] = auxiliary[i];
                    i++;
                }
            }
    }

    public static void resetCounts() {
        numberOfSortCalls = 0L;
        maximumNumberOfInProgressSortCalls = 0L;
        numberOfMergeCalls = 0L;
        numberOfArrayItemCopies = 0L;
        numberOfValueComparisons = 0L;
    }

    public static long getNumberOfSortCalls() {
        return numberOfSortCalls;
    }

    public static long getMaximumNumberOfInProgressSortCalls() {
        return maximumNumberOfInProgressSortCalls;
    }

    public static long getNumberOfMergeCalls() {
        return numberOfMergeCalls;
    }

    public static long getNumberOfArrayItemCopies() {
        return numberOfArrayItemCopies;
    }

    public static long getNumberOfValueComparisons() {
        return numberOfValueComparisons;
    }

    public static void main(final String[] arguments) {
        final double[] values = { 50.0, 60.0, 70.0,
            80.0 };

        out.println("Before: " + Arrays.toString(values));

        sort(values);

        out.println("After: " + Arrays.toString(values));

        out.println("Counts:");
        out.println(
                "\tNumber of private sort calls: " + getNumberOfSortCalls());
        out.println("\tMaximum number of in progress private sort calls: "
                + getMaximumNumberOfInProgressSortCalls());
        out.println("\tNumber of merge calls: " + getNumberOfMergeCalls());
        out.println("\tNumber of array item copies: "
                + getNumberOfArrayItemCopies());
        out.println("\tComparisons: " + getNumberOfValueComparisons());
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