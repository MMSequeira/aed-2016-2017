package pt.europeia.aed.igb.session9;

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
        numbers.add(new Integer(11)); // 11 is a literal of type int.

        // Implicitly create (or get) the wrapper type instance, i.e.,
        // auto-boxing:
        numbers.add(22); // 22 is a literal of type int.

        // Implicitly call the intValue() getter of the boxed int value, i.e.,
        // auto-unboxing:
        final int first = numbers.get(0);
        
        // Explicitly call the intValue() getter of the boxed int value:
        final int second = numbers.get(1).intValue();

        out.println(first);
        out.println(second);
    }

}
