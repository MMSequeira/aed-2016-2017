package pt.europeia.aed.book.chapter1.section4;

import static pt.europeia.aed.Tools.out;

import edu.princeton.cs.algs4.In;
import pt.europeia.aed.Stopwatch;

public class TwoSum {
    
    public static int numberOfZeroSumPairsIn(final int[] numbers) {
        final int length = numbers.length;
        int numberOfZeroSumPairs = 0;
        for (int i = 0; i != length; i++)
            for (int j = i + 1; j != length; j++)
                if (numbers[i] + numbers[j] == 0)
                    numberOfZeroSumPairs++;
        return numberOfZeroSumPairs;
    }

    public static void mainOriginal(final String[] arguments) {
        final In in = new In(arguments[0]);
        final int[] numbers = in.readAllInts();
        out.println(numberOfZeroSumPairsIn(numbers));
    }

    public static void main(final String[] arguments) {
        final In in = new In(arguments[0]);
        final int[] numbers = in.readAllInts();
        final Stopwatch stopwatch = new Stopwatch();
        final int numberOfPairs = numberOfZeroSumPairsIn(numbers);
        out.println("Elapsed time = " + stopwatch.elapsedTime());
        out.println(numberOfPairs);
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