package pt.europeia.aed.exams.er20170720t2000;

import static java.lang.System.out;

public class LoopTracing {

    private static int incrementsOfLoop1(int N) {
        int sum = 0;
        while (N != 0) {
            N--;
            for (int i = 0; i != N; i++)
                sum++;
        }

        return sum;
    }

    private static int incrementsOfLoop2(final int N) {
        int sum = 0;
        for (int k = N; k != 0; k /= 2)
            for (int i = k; i != 0; i--)
                sum++;

        return sum;
    }

    public static void main(final String[] arguments) {
        int N;

        out.println("Loop 1:");
        N = 3;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
                + " increments, should be " + (N - 1) * N / 2 + ".");
        N = 5;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
                + " increments, should be " + (N - 1) * N / 2 + ".");
        N = 7;
        out.println("\tN = " + N + ": " + incrementsOfLoop1(N)
                + " increments, should be " + (N - 1) * N / 2 + ".");

        out.println("Loop 2:");
        N = 1;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + (2 * N - 1) + ".");
        N = 4;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + (2 * N - 1) + ".");
        N = 8;
        out.println("\tN = " + N + ": " + incrementsOfLoop2(N)
                + " increments, should be " + (2 * N - 1) + ".");
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