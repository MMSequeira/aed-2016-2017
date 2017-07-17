package pt.europeia.aed.exams.er20170713t1000;

public final class TernarySearch {

    private TernarySearch() {
        throw new RuntimeException("Attempt to instantiate package-class");
    }

    public static int positionOf(final double[] values, final double key) {
        int first = 0;
        int last = values.length - 1;
        while (first <= last) {
            final int middleLeft = first + (last - first) / 3;
            final int middleRight = last - (last - first) / 3;

            if (key < values[middleLeft])
                last = middleLeft - 1;
            else {
                if (key > values[middleLeft])
                    if (key < values[middleRight]) {
                        first = middleLeft + 1;
                        last = middleRight - 1;
                    } else {
                        if (key > values[middleRight])
                            first = middleRight + 1;
                        else
                            return middleRight;
                    }
                else
                    return middleLeft;
            }
        }
        return -1;
    }

    public static void main(final String[] arguments) {
        for (int length = 1; length <= 1 << 20; length *= 2) {
            final double[] numbers = new double[length];

            for (int i = 0; i != length; i++)
                numbers[i] = (double) i;

            for (int i = 0; i != length; i++) {
                final int position = positionOf(numbers, (double) i);
                assert position == i : (double) i + " should be in index " + i
                        + " but was found in " + position;
            }

            assert positionOf(numbers,
                    -1.0) == -1 : "-1.0 should not be in have been found";
            assert positionOf(numbers, (double) length) == -1 : (double) length
                    + " should not be in have been found";
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