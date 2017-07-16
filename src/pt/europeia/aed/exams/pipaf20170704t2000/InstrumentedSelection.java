package pt.europeia.aed.exams.pipaf20170704t2000;

import static java.lang.System.out;

import java.util.Arrays;

public final class InstrumentedSelection {
    
    private static long numberOfPasses;
    private static long numberOfSwaps;
    private static long numberOfComparisons;

    public static void sort(final double[] values) {
        resetCounts();
        
        for (int n = 0; n < values.length - 1; n++) {
            numberOfPasses++;
            for (int i = n + 1; i != values.length; i++) {
                numberOfComparisons++;
                if (values[i] < values[n])
                    swap(values, n, i);
            }
        }
    }

    private static void swap(final double[] values, final int firstPosition,
            final int secondPosition) {
        numberOfSwaps++;
        final double temporary = values[firstPosition];
        values[firstPosition] = values[secondPosition];
        values[secondPosition] = temporary;
    }
    
    public static void resetCounts() {
        numberOfPasses = 0L;
        numberOfSwaps = 0L;
        numberOfComparisons = 0L;
    }

    public static long getNumberOfPasses() {
        return numberOfPasses;
    }

    public static long getNumberOfSwaps() {
        return numberOfSwaps;
    }

    public static long getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public static void main(final String[] arguments) {
        final double[] values = {60.0, 50.0, 40.0, 30.0, 20.0, 10.0};
        
        out.println("Before: " + Arrays.toString(values));
        
        sort(values);
        
        out.println("After: " + Arrays.toString(values));
        
        out.println("Counts:");
        out.println("\tPasses: " + getNumberOfPasses());
        out.println("\tSwaps: " + getNumberOfSwaps());
        out.println("\tComparisons: " + getNumberOfComparisons());
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