package pt.europeia.aed.piazza;

import static java.lang.System.out;

import java.util.Arrays;

public final class InstrumentedInsertion {

    private static long numberOfComparisons = 0;
    private static long numberOfSwaps = 0;
    private static long numberOfArrayReads = 0;
    private static long numberOfArrayWrites = 0;

    private InstrumentedInsertion() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static <Item extends Comparable<? super Item>> void sort(
            final Item[] values) {
        resetCounts();
        
        for (int numberOfSortedItems = 1; numberOfSortedItems < values.length;
             numberOfSortedItems++)
            for (int i = numberOfSortedItems;
                 i != 0 && isLess(values[i], values[i - 1]); i--)
                swap(values, i - 1, i);
    }

    private static <Value extends Comparable<? super Value>> boolean isLess(
            final Value first, final Value second) {
        numberOfComparisons++;
        // We know isLess() is always called with array item values, so it is OK
        // to count the reads here:
        numberOfArrayReads += 2;
        return first.compareTo(second) < 0;
    }

    private static void swap(final Object[] values, final int firstPosition,
            final int secondPosition) {
        numberOfSwaps++;
        numberOfArrayReads += 2;
        numberOfArrayWrites += 2;
        final Object temporary = values[firstPosition];
        values[firstPosition] = values[secondPosition];
        values[secondPosition] = temporary;
    }

    public static long getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public static long getNumberOfSwaps() {
        return numberOfSwaps;
    }

    public static long getNumberOfArrayReads() {
        return numberOfArrayReads;
    }

    public static long getNumberOfArrayWrites() {
        return numberOfArrayWrites;
    }
    
    private static void resetCounts() {
        numberOfComparisons = 0;
        numberOfSwaps = 0;
        numberOfArrayReads = 0;
        numberOfArrayWrites = 0;
    }

    public static void main(final String[] arguments) {
        final Integer[] numbers = { 2, 4, 3, 1 };

        out.println("Insertion sorting " + Arrays.toString(numbers) + ".");

        sort(numbers);
        
        out.println("Number of comparisons: " + getNumberOfComparisons());
        out.println("Number of swaps: " + getNumberOfSwaps());
        out.println("Number of array reads: " + getNumberOfArrayReads());
        out.println("Number of array writes: " + getNumberOfArrayWrites());
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