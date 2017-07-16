package pt.europeia.aed.exams.er20170713t1000;

import edu.princeton.cs.algs4.StdRandom;

import static java.lang.System.out;

import java.util.Arrays;

public class InsertionWithMovesTester {

    public static void main(final String[] arguments) {
        out.println("Testing insertion sort with moves:");

        StdRandom.setSeed(3467812342L);

        final int numberOfRepetions = 10000;

        out.println("\tTesting with random arrays:");

        for (int size = 1; size != 1 << 11; size <<= 1) {
            out.println("\t\tTesting array size " + size + " with "
                    + numberOfRepetions + " repetitions:");

            for (int repetition = 0; repetition != numberOfRepetions; repetition++) {
                final double[] originalValues = randomDoubleArrayOf(size);
                final double[] systemSortedValues = originalValues.clone();
                final double[] sortedValues = originalValues.clone();

                Arrays.sort(systemSortedValues);

                InsertionWithMoves.sort(sortedValues);

                if (!Arrays.equals(sortedValues, systemSortedValues)) {
                    out.println("\t\t\tError (repetition = " + repetition + "):");
                    out.println("\t\t\t\tWas:       "
                            + Arrays.toString(originalValues));
                    out.println("\t\t\t\tShould be: "
                            + Arrays.toString(systemSortedValues));
                    out.println("\t\t\t\tIs:        "
                            + Arrays.toString(sortedValues));
                }
            }

            out.println("\t\tFinished tests with array size " + size + ".");
        }

        out.println("\tTesting with increasing arrays:");

        for (int size = 1; size != 1 << 11; size <<= 1) {
            out.println("\t\tTesting array size " + size + " with "
                    + numberOfRepetions + " repetitions:");

            for (int repetition = 0; repetition != numberOfRepetions; repetition++) {
                final double[] originalValues = increasingDoubleArrayOf(size);
                final double[] systemSortedValues = originalValues.clone();
                final double[] sortedValues = originalValues.clone();

                Arrays.sort(systemSortedValues);

                InsertionWithMoves.sort(sortedValues);

                if (!Arrays.equals(sortedValues, systemSortedValues)) {
                    out.println("\t\t\tError (repetition = " + repetition + "):");
                    out.println("\t\t\t\tWas:       "
                            + Arrays.toString(originalValues));
                    out.println("\t\t\t\tShould be: "
                            + Arrays.toString(systemSortedValues));
                    out.println("\t\t\t\tIs:        "
                            + Arrays.toString(sortedValues));
                }
            }

            out.println("\t\tFinished tests with array size " + size + ".");
        }

        out.println("Finished all tests.");
    }

    private static double[] randomDoubleArrayOf(final int size) {
        final double[] values = new double[size];

        for (int i = 0; i != values.length; i++)
            values[i] = Math.round(StdRandom.uniform() * 100.0) / 100.0;

        return values;
    }

    private static double[] increasingDoubleArrayOf(final int size) {
        final double[] values = new double[size];

        for (int i = 0; i != values.length; i++)
            values[i] = (double)i;

        return values;
    }

}

/*
 * Copyright 2017, Manuel Menezes de Sequeira.
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
 */