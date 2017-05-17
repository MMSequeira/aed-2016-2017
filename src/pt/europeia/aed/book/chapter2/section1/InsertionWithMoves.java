package pt.europeia.aed.book.chapter2.section1;

public final class InsertionWithMoves {

    private InsertionWithMoves() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    /**
     * Sorts an array using a variant of insertion sort (stable) that performs
     * moves instead of swaps. That is, the value being inserted is not swap
     * successively to the left until it fits into its place. Instead, a copy of
     * that value is stored in a temporary variable, the values of the items are
     * moved right (overlapping the value which is being inserted), and the
     * value to insert is copied from the temporary variable into the item made
     * available by the moves. When moving a value M items to the left, this
     * variant of the algorithm performs 2 array accesses (copies into and out
     * of the temporary variable) plus 2M array accesses for the moves, for a
     * total of 2M+2 ~ 2M array accesses. The variant of the algorithm using
     * swaps performs M swaps in the same case, that is, a total of 4M ~ 4M
     * array accesses. Hence, the move-based variant of insertion sort performs
     * about ½ the number of array accesses performed by the swap-based version.
     * 
     * @param values
     *            The array to sort.
     */
    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        for (int numberOfSortedItems = 1; numberOfSortedItems < values.length;
             numberOfSortedItems++) {
            final Item valueToInsert = values[numberOfSortedItems];
            int i = numberOfSortedItems;
            while (i != 0 && isLess(valueToInsert, values[i - 1])) {
                values[i] = values[i - 1];
                i--;
            }
            values[i] = valueToInsert;
        }

        assert isIncreasing(
                values) : "Array should be increasing after sorting.";
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
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
 * Copyright 2015-2017, Robert Sedgewick and Kevin Wayne.
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