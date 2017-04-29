package pt.europeia.aed.book.chapter2.section1;

import static pt.europeia.aed.Tools.out;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class InsertionTester {

    public static void main(final String[] arguments) {
        out.println("Testing insertion sort:");

        StdRandom.setSeed(3467812342L);

        final int numberOfRepetions = 10000;

        for (int size = 1; size != 1 << 11; size <<= 1) {
            out.println("\tTesting array size " + size + " with "
                    + numberOfRepetions + " repetitions:");

            for (int repetition = 0; repetition != numberOfRepetions; repetition++) {
                final Double[] originalValues = randomDoubleArrayOf(size);
                final Double[] systemSortedValues = originalValues.clone();
                final Double[] sortedValues = originalValues.clone();

                Arrays.sort(systemSortedValues);

                Insertion.sort(sortedValues);

                if (!Arrays.equals(sortedValues, systemSortedValues)) {
                    out.println("\t\tError (repetition = " + repetition + "):");
                    out.println("\t\t\tWas:       "
                            + Arrays.toString(originalValues));
                    out.println("\t\t\tShould be: "
                            + Arrays.toString(systemSortedValues));
                    out.println("\t\t\tIs:        "
                            + Arrays.toString(sortedValues));
                }
            }

            out.println("\tFinished tests with array size " + size + ".");
        }

        out.println("Finished all tests.");
    }

    private static Double[] randomDoubleArrayOf(final int size) {
        final Double[] values = new Double[size];

        for (int i = 0; i != values.length; i++)
            values[i] = Math.round(StdRandom.uniform() * 100.0) / 100.0;

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