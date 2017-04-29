package pt.europeia.aed.book.chapter2.section1;

public final class InsertionWithMovesAndBinarySearch {

    private InsertionWithMovesAndBinarySearch() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        for (int numberOfSortedItems = 1; numberOfSortedItems < values.length;
             numberOfSortedItems++) {
            final Item valueToInsert = values[numberOfSortedItems];
            final int indexOfInsertion = indexOfInsertion(values, 0,
                    numberOfSortedItems, valueToInsert);
            for (int i = numberOfSortedItems; i != indexOfInsertion; i--)
                values[i] = values[i - 1];
            values[indexOfInsertion] = valueToInsert;
        }

        assert isIncreasing(
                values) : "Array should be increasing after sorting.";
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        return first.compareTo(second) < 0;
    }

    private static <Item extends Comparable<? super Item>> int indexOfInsertion(
            final Item[] values, int first, int end, final Item value) {
        while (first < end) {
            final int middle = first + (end - first) / 2;

            if (isLess(value, values[middle]))
                end = middle;
            else
                first = middle + 1;
        }
        return first;
    }

    private static <Item extends Comparable<? super Item>> boolean isIncreasing(
            final Item[] values) {
        for (int i = 1; i < values.length; i++)
            if (isLess(values[i], values[i - 1]))
                return false;
        return true;
    }

    public static void main(final String[] arguments) {
        final Integer[] values = { 10, 10, 20, 30, 30, 30, 40, 40 };

        assert indexOfInsertion(values, 0, 0, 10) == 0;

        assert indexOfInsertion(values, 0, 1, 9) == 0;
        assert indexOfInsertion(values, 0, 1, 10) == 1;
        assert indexOfInsertion(values, 0, 1, 11) == 1;

        assert indexOfInsertion(values, 0, 2, 9) == 0;
        assert indexOfInsertion(values, 0, 2, 10) == 2;
        assert indexOfInsertion(values, 0, 2, 11) == 2;

        assert indexOfInsertion(values, 0, 3, 9) == 0;
        assert indexOfInsertion(values, 0, 3, 10) == 2;
        assert indexOfInsertion(values, 0, 3, 11) == 2;
        assert indexOfInsertion(values, 0, 3, 20) == 3;
        assert indexOfInsertion(values, 0, 3, 21) == 3;

        assert indexOfInsertion(values, 0, 6, 9) == 0;
        assert indexOfInsertion(values, 0, 6, 10) == 2;
        assert indexOfInsertion(values, 0, 6, 11) == 2;
        assert indexOfInsertion(values, 0, 6, 20) == 3;
        assert indexOfInsertion(values, 0, 6, 21) == 3;
        assert indexOfInsertion(values, 0, 6, 30) == 6;
        assert indexOfInsertion(values, 0, 6, 31) == 6;

        assert indexOfInsertion(values, 3, 8, 9) == 3;
        assert indexOfInsertion(values, 3, 8, 10) == 3;
        assert indexOfInsertion(values, 3, 8, 11) == 3;
        assert indexOfInsertion(values, 3, 8, 20) == 3;
        assert indexOfInsertion(values, 3, 8, 21) == 3;
        assert indexOfInsertion(values, 3, 8, 30) == 6;
        assert indexOfInsertion(values, 3, 8, 31) == 6;
        assert indexOfInsertion(values, 3, 8, 40) == 8;
        assert indexOfInsertion(values, 3, 8, 41) == 8;
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