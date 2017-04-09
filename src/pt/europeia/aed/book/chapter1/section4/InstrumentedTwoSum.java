package pt.europeia.aed.book.chapter1.section4;

import static pt.europeia.aed.Tools.out;

import java.util.Arrays;

public class InstrumentedTwoSum {

    // Instrumentation code:
    private static int numberOfDeclarations = 0;
    private static int numberOfAssignments = 0;
    private static int numberOfComparisonsWithDifferent = 0;
    private static int numberOfComparisonsWithEquals = 0;
    private static int numberOfArrayAccesses = 0;
    private static int numberOfIncrements = 0;

    public static int numberOfZeroSumPairsIn(final int[] numbers) {
        numberOfDeclarations++;
        numberOfAssignments++;
        int numberOfZeroSumPairs = 0;

        numberOfDeclarations++;
        numberOfAssignments++;
        for (int i = 0; i != numbers.length; i++, numberOfIncrements++) {
            numberOfComparisonsWithDifferent++;

            numberOfDeclarations++;
            numberOfAssignments++;
            for (int j = i
                    + 1; j != numbers.length; j++, numberOfIncrements++) {
                numberOfComparisonsWithDifferent++;
                numberOfComparisonsWithEquals++;
                numberOfArrayAccesses += 2;
                if (numbers[i] + numbers[j] == 0) {
                    numberOfIncrements++;
                    numberOfZeroSumPairs++;
                }
            }
            numberOfComparisonsWithDifferent++;
        }
        numberOfComparisonsWithDifferent++;

        return numberOfZeroSumPairs;
    }

    private static void show(final String valueText, final int value,
            final int correctValue) {
        out.println("\t" + valueText + " = " + value + " should be "
                + correctValue);
    }

    private static void show(final String valueText, final int value,
            final int minimumValue, final int maximumValue) {
        out.println("\t" + valueText + " = " + value + " should be between "
                + minimumValue + " and " + maximumValue);
    }

    private static void experimentWith(final int[] numbers) {
        out.println("Experimenting with " + Arrays.toString(numbers) + " :");

        resetCounts();

        final int N = numbers.length;

        out.println("\tN = " + numbers.length);

        final int numberOfPairs = numberOfZeroSumPairsIn(numbers);

        out.println("\tZero sum pairs = " + numberOfPairs);

        show("Declarations", numberOfDeclarations, N + 2);
        show("Assignments", numberOfAssignments, N + 2);
        show("Comparisons with ≠", numberOfComparisonsWithDifferent,
                (N + 1) * (N + 2) / 2);
        show("Comparisons with =", numberOfComparisonsWithEquals,
                N * (N - 1) / 2);
        show("Arrays accesses", numberOfArrayAccesses, N * (N - 1));
        show("Increments", numberOfIncrements, N * (N + 1) / 2, N * N);
    }

    public static void main(final String[] arguments) {
        experimentWith(new int[] { 1, 1, 1, 1, 1, 1, 1 });
        experimentWith(new int[] { 0, 0, 0, 0, 0, 0, 0 });
    }

    // Instrumentation code:
    public static void resetCounts() {
        numberOfDeclarations = 0;
        numberOfAssignments = 0;
        numberOfComparisonsWithDifferent = 0;
        numberOfComparisonsWithEquals = 0;
        numberOfArrayAccesses = 0;
        numberOfIncrements = 0;
    }

    public static int getNumberOfDeclarations() {
        return numberOfDeclarations;
    }

    public static int getNumberOfAssignments() {
        return numberOfAssignments;
    }

    public static int getNumberOfComparisonsWithDifferent() {
        return numberOfComparisonsWithDifferent;
    }

    public static int getNumberOfComparisonsWithEquals() {
        return numberOfComparisonsWithEquals;
    }

    public static int getNumberOfArrayAccesses() {
        return numberOfArrayAccesses;
    }

    public static int getNumberOfIncrements() {
        return numberOfIncrements;
    }

}

/*
 * Copyright 2015 and 2016, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2015 and 2016, Manuel Menezes de Sequeira.
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