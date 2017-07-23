package pt.europeia.aed.exams.er20170720t2000;

import static java.lang.System.out;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class SortTester {

    public static void main(final String[] arguments) {
        test(Bubble::sort);
        test(InstrumentedBubble::sort);
        test(Merge::sort);
        test(Selection::sort);
    }

    private static void test(final Sorter sorter) {
        final int numberOfRepetions = 1000;

        for (int size = 1; size != 1 << 11; size <<= 1) {
            final double[] originalValues = randomDoubleArrayOf(size);
            final double[] sortedValues = originalValues.clone();
            
            Arrays.sort(sortedValues);

            for (int repetition = 0; repetition != numberOfRepetions;
                 repetition++) {
                final double[] values = originalValues.clone();

                sorter.sort(values);

                if (!Arrays.equals(values, sortedValues)) {
                    out.println("Error (size = " + size + ", repetition = "
                            + repetition + "):");
                    out.println(
                            "\tWas:       " + Arrays.toString(originalValues));
                    out.println(
                            "\tShould be: " + Arrays.toString(sortedValues));
                    out.println("\tIs:        " + Arrays.toString(values));
                }
            }
        }
    }

    private static double[] randomDoubleArrayOf(final int size) {
        final double[] values = new double[size];

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