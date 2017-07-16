package pt.europeia.aed.exams.pipaf20170704t2000;

public final class BottomUpMerge {
    public static void sort(final double[] values) {
        final double[] auxiliary = new double[values.length];

        for (int size = 1; size < values.length; size *= 2)
            for (int first = 0; first < values.length - size;
                 first += 2 * size) {
                final int middle = first + size - 1;
                final int last = Math.min(first + size + size - 1,
                        values.length - 1);
                merge(values, auxiliary, first, middle, last);
            }
    }

    private static void merge(final double[] values, final double[] auxiliary,
            final int first, final int middle, final int last) {

        for (int i = first; i <= last; i++)
            auxiliary[i] = values[i];

        int i = first;
        int j = middle + 1;

        for (int k = first; k <= last; k++)
            if (i > middle) {
                values[k] = auxiliary[j];
                j++;
            } else if (j > last) {
                values[k] = auxiliary[i];
                i++;
            } else if (auxiliary[j] < auxiliary[i]) {
                values[k] = auxiliary[j];
                j++;
            } else {
                values[k] = auxiliary[i];
                i++;
            }
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