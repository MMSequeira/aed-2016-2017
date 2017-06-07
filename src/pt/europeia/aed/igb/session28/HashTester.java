package pt.europeia.aed.igb.session28;

import static java.lang.System.out;

public class HashTester {

    public static void main(final String[] arguments) {
        final HashTester tester = new HashTester();

        // By default, toString() returns the full class name of the object
        // followed by "@" and by the hexadecimal representation of the hash
        // code of the object.
        out.println(tester);

        // The default hash code of an object is usually its internal address.
        // This is not required by the language, though. Here's what the
        // documentation of the Object class says about it: "As much as is
        // reasonably practical, the hashCode method defined by class Object
        // does return distinct integers for distinct objects. (This is
        // typically implemented by converting the internal address of the
        // object into an integer, but this implementation technique is not
        // required by the Java™ programming language.)"
        out.println(tester.hashCode());

        // Shows that toString() indeed returns a string including the
        // hexadecimal representation of the object:
        out.println(Integer.toHexString(tester.hashCode()));
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