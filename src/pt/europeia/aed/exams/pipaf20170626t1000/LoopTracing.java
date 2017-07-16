package pt.europeia.aed.exams.pipaf20170626t1000;

import static java.lang.System.out;

public class LoopTracing {

    private static int lg(int n) {
        if (n <= 0)
            throw new IllegalArgumentException(
                    "Attempt to calculate logarithm of non-positive number.");
        int lg = 0;
        while (n != 1) {
            lg++;
            n /= 2;
        }

        return lg;
    }

    private static int incrementsOfLoop1(int N) {
        int sum = 0;

        int j = 1;
        while (j < N) {
            sum++;
            j *= 2;
        }

        while (j > 1) {
            sum++;
            j /= 2;
        }
        
        return sum;
    }

    private static int incrementsOfLoop2(final int N) {
        int sum = 0;    
        for (int i = N; i != 1; i /= 2)
            sum++;
        
        for (int i = 0; i != N; i++)
            sum++;

        return sum;
    }

    public static void main(final String[] arguments) {
        int N;

        out.println("Loop 1:");
        N = 1;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
                + " increments, should be " + 2 * lg(N) + ".");
        N = 8;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
                + " increments, should be " + 2 * lg(N) + ".");
        N = 32;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
        + " increments, should be " + 2 * lg(N) + ".");

        out.println("Loop 2:");
        N = 1;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + (N + lg(N)) + ".");
        N = 8;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + (N + lg(N)) + ".");
        N = 32;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + (N + lg(N)) + ".");
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