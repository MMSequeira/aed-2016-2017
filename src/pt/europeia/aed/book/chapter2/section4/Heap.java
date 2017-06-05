package pt.europeia.aed.book.chapter2.section4;

import static pt.europeia.aed.Tools.out;

public final class Heap {

    private Heap() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        int length = values.length;

        for (int k = length / 2; k >= 1; k--)
            sink(values, k, length);

        while (length > 1) {
            swap(values, 1, length--);
            sink(values, 1, length);
        }
        
        assert isIncreasing(
                values) : "Array should be increasing after sorting.";
    }

    private static <Item extends Comparable<? super Item>> void sink(
            final Item[] values, int k, final int length) {
        while (2 * k <= length) {
            int j = 2 * k;
            if (j < length && isLess(values, j, j + 1))
                j++;
            if (!isLess(values, k, j))
                break;
            swap(values, k, j);
            k = j;
        }
    }

    private static <Item extends Comparable<? super Item>> boolean isLess(
            final Item[] values, final int i, final int j) {
        return values[i - 1].compareTo(values[j - 1]) < 0;
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
    }

    private static void swap(final Object[] values, final int i, final int j) {
        final Object temporary = values[i - 1];
        values[i - 1] = values[j - 1];
        values[j - 1] = temporary;
    }

    private static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values) {
        for (int i = 1; i < values.length; i++)
            if (isLess(values[i], values[i - 1]))
                return false;
        return true;
    }

}

/*
 * Copyright 2002-2016, Robert Sedgewick and Kevin Wayne.
 * 
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