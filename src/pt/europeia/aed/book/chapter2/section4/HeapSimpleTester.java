package pt.europeia.aed.book.chapter2.section4;

import static pt.europeia.aed.Tools.out;

import edu.princeton.cs.algs4.StdRandom;

public class HeapSimpleTester {

    public static void main(final String[] arguments) {
        final Double[] values = randomDoubleArrayOf(11);
        Heap.sort(values);
        show(values);
    }

    private static void show(final Object[] values) {
        for (Object value : values) {
            out.println(value);
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