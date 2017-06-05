package pt.europeia.aed.book.chapter2.section3;

import static java.lang.System.out;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class QuickTester {

    public static void main(final String[] arguments) {
        final int numberOfRepetions = 10000;

        for (int size = 1; size != 1 << 11; size <<= 1) {
            final Double[] originalValues = randomDoubleArrayOf(size);
            final Double[] sortedValues = originalValues.clone();
            Arrays.sort(sortedValues);

            for (int repetition = 0; repetition != numberOfRepetions; repetition++) {
                final Double[] values = originalValues.clone();

                Quick.sort(values);

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