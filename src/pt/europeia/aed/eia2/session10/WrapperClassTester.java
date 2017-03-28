package pt.europeia.aed.eia2.session10;

import static java.lang.System.out;

import java.util.ArrayList;

public class WrapperClassTester {

    public static void main(final String[] arguments) {
        // This code does not compile: generic type arguments must be reference
        // types. Check the compiler error message. It is a bit cryptic, since
        // Java is telling us that a pair of [] added to int would make it a
        // reference type (an array):
        /*-
         *  final ArrayList<int> numbers = new ArrayList<>();
         */

        // We must use wrapper class Integer, instead of int:
        final ArrayList<Integer> numbers = new ArrayList<>();

        // Explicitly create the wrapper type instance:
        numbers.add(new Integer(10)); // 10 is a literal of type int.

        // Implicitly create (or get) the wrapper type instance, i.e.,
        // auto-boxing:
        numbers.add(20); // 20 is a literal of type int.

        // Implicitly call the intValue() getter of the boxed int value, i.e.,
        // auto-unboxing:
        final int first = numbers.get(0);

        // Explicitly call the intValue() getter of the boxed int value:
        final int second = numbers.get(1).intValue();

        out.println(first);
        out.println(second);
    }

}

/*
 * Copyright 2016-2017, Manuel Menezes de Sequeira.
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