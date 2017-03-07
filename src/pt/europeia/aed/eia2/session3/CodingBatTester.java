package pt.europeia.aed.eia2.session3;

import static java.lang.System.out;

/*
 * Solutions for some of the CodingBat (Warmup-1) exercises:
 */
public class CodingBatTester {

    /*
     * Given three int values, a b c, return the largest.
     */
    public static int intMax(final int a, final int b, final int c) {
        // This solution requires exactly two comparisons to do its job. It is
        // also not too hard to read.
        if (a >= b) {
            if (a >= c)
                return a;
            else
                return c;
        } else {
            if (b >= c)
                return b;
            else
                return c;
        }

        // This version reflects more directly the way we humans think about the
        // problem, and thus is arguably more readable than the solution above.
        // However, if a is not the largest value, four comparisons may be
        // necessary, which makes this solution less efficient.
        /*-
        if (a >= b && a >= c)
            return a;
        else if (b >= a && b >= c)
            return b;
        else
            return c;
        */
    }

    /*
     * We have a loud talking parrot. The "hour" parameter is the current hour
     * time in the range 0..23. We are in trouble if the parrot is talking and
     * the hour is before 7 or after 20. Return true if we are in trouble.
     */
    public static boolean parrotTrouble(final boolean isTalking,
            final int hour) {
        // Simple solution using a single return statement. The boolean value of
        // the expression is returned directly. The boolean variable is used
        // directly, not compared with true or false. Notice that parenthesis
        // are required around the or operator, since it has lower precedence
        // than the and operator.
        return isTalking && (hour < 7 || hour > 20);

        // Slightly more verbose solution using an if-else (selection)
        // statement:
        /*-
        if (isTalking && (hour < 7 || hour > 20))
            return true;
        else
            return false;
        */

        // A more verbose solution using an if-else (selection) statement and
        // comparison of the boolean variables with true and false:
        /*-
        if (isTalking == true && (hour < 7 || hour > 20))
            return true;
        else
            return false;
        */
    }

    /*
     * Return true if the given non-negative number is a multiple of 3 or a
     * multiple of 5. Use the % "mod" operator -- see Introduction to Mod
     */
    public static boolean or35(final int n) {
        // n is a multiple of 3 if the remainder of the integer division of n
        // by 3 is 0. The modulo or remainder operator % calculates remainder of
        // the first operand when divided by the second operand. Hence, we may
        // check whether n is a multiple of 3 comparing n % 3 with 0 and
        // similarly for 5. We again use a single return statement. The boolean
        // value of the expression is returned directly.
        return n % 3 == 0 || n % 5 == 0;

        // Slightly more verbose solution using an if-else (selection)
        // statement:
        /*-
        if (n % 3 == 0 || n % 5 == 0)
            return true;
        else
            return false;
        */
    }

    /*
     * Given a string, return true if the string starts with "hi" and false
     * otherwise.
     */
    public static boolean startHi(final String string) {
        // Class String provides an integer method String.startsWith() that
        // allows us to check directly whether the string starts with "hi".
        return string.startsWith("hi");

        // A more complicated version using String.substring(). The substring()
        // method returns a string containing a substring (a part) of the
        // original string. It receives two indices as arguments: the index of
        // the first character of the substring in the original string, and the
        // index of first character *after* the substring. Thus, is both indices
        // are equal, an empty string is returned. Two obtain a string with the
        // first two characters of string, we may thus use string.substring(0,
        // 2). This call throws an exception if string has less than two
        // characters, however, thus we must make sure the string is at least
        // two characters long before calling it. If it is not, we return false.
        // Notice that we do *not* compare the resulting substring with the
        // string "hi" using the == operator: that would compare string
        // identity, not equality. Remember that since String is a class, its
        // variables store references to String instances, not the instances
        // themselves, and thus the == operator would compare string references.
        // Equality for strings must be checked using the equals() method.
        /*-
        return string.length() >= 2 && string.substring(0, 2).equals("hi");
        */

        // Many other solutions would be possible, including solutions with
        // alternative return statements controlled by an if-else statement.
    }

    /*
     * Given 2 positive int values, return the larger value that is in the range
     * 10..20 inclusive, or return 0 if neither is in that range.
     */
    public static int max1020(final int a, final int b) {
        // Again, lots of different solutions are possible. This solution is
        // made simple by the use of a variable. We use this variable to store
        // the largest value seen at each point of the code. Since
        // initially the values of a and b have not yet been considered, the
        // largest value is seen to be 0 (since 0 is the value to return
        // if both a and b are outside of the valid range of values).
        int largest = 0;

        // Now we check value a. If it is in the valid range, then we consider
        // it. Since all possible values in the valid range are larger than 0,
        // we do not have to check whether a is larger than the largest value
        // seen, which at this point is 0: we simply set largest to a.
        if (10 <= a && a <= 20)
            largest = a;

        // Now we check value b. If it is in the valid range, than we consider
        // it. If it is larger than the largest value seen, we set largest to b.
        if (10 <= b && b <= 20 && b > largest)
            largest = b;

        // We return the largest value seen.
        return largest;
    }

    /*
     * Given a non-empty string and an int n, return a new string where the char
     * at index n has been removed. The value of n will be a valid index of a
     * char in the original string (i.e. n will be in the range
     * 0..str.length()-1 inclusive).
     */
    public static String missingChar(final String string, final int n) {
        // Since n is always a valid index, we may use n together with the
        // String.substring() method to obtain the part of the string before the
        // character to remove and the part of the string after the character to
        // remove. The result is the concatenation of both of these parts.
        // Notice that string.substring(0, n) returns a string with all
        // characters from index 0 to index n - 1, and thus does not include the
        // character at index n. If n is 0, the result is an empty string.
        // Notice also that string.substring(n + 1) calls a different,
        // overloaded String.substring() method that returns a string with all
        // characters of the original string from index n + 1 until the end of
        // the string. If n is the index of the last character (i.e.,
        // string.length() - 1), then the result is an empty string.
        return string.substring(0, n) + string.substring(n + 1);
    }

    /*
     * Given a string, take the last char and return a new string with the last
     * char added at the front and back, so "cat" yields "tcatt". The original
     * string will be length 1 or more.
     */
    public static String backAround(final String string) {
        // Since we are assured that the is at least one character in the
        // string, we may use the String.charAt() method to get the last
        // character of the string, which has index string.length() - 1. We then
        // store that character in a variable (or rather, a constant).
        final char lastCharacter = string.charAt(string.length() - 1);

        // The result is the obtained by concatenation of the last character at
        // the beginning and end of the string:
        return lastCharacter + string + lastCharacter;

        // This alternative solution is exactly equal. However, it avoids using
        // a variable by obtaining the last character twice.
        /*-
        return string.charAt(string.length() - 1) + string
                + string.charAt(string.length() - 1);
        */
    }

    /*
     * Given a string, take the first 2 chars and return the string with the 2
     * chars added at both the front and back, so "kitten" yields"kikittenki".
     * If the string length is less than 2, use whatever chars are there.
     */
    public static String front22(final String string) {
        // We are not assured that the string contains at least two characters.
        // Hence, we must make sure the string is at least two characters long
        // before using string.substring(0, 2) to obtain the first two
        // characters of the string. Also, if the string has less than two
        // characters, its start is the string itself. The case of a string with
        // exactly two characters may be treated the same way as shorter
        // strings. This solution makes use of a constant to store the start of
        // the string. Then, it returns the original string with the
        // concatenation of the start of the string at its beginning and end.
        // Notice that we use the ? : ternary operator. This operator
        // has three operands: condition ? expression_1 : expression_2. The
        // result is the value of expression_1 if the condition is true, and it
        // is the value of expression_2 if the condition is false. It often can
        // be used to create short and clear code, but may also lead to quite
        // cryptic code, if the expressions envolved are complicated,
        // particularly if they involve other uses of the ? : operator.
        final String startOfString = string.length() > 2
                ? string.substring(0, 2) : string;

        return startOfString + string + startOfString;

        // This solution is similar, though it uses an if-else statement instead
        // of the ? : and does not use a constant to store the start of the
        // string.
        /*-
        if (string.length() > 2)
            return string.substring(0, 2) + string + string.substring(0, 2);
        else
            return string + string + string;
        */
    }

    /*
     * An utility method for printing results together with expected results.
     */
    private static void showResult(final Object result,
            final Object expectedResult) {
        out.print("\t" + result + " should be " + expectedResult);
        out.println(result.equals(expectedResult) ? ": ✓" : ": ✗");
    }

    public static void main(final String[] arguments) {
        out.println("intMax():");
        showResult(intMax(1, 2, 3), 3);
        showResult(intMax(1, 3, 2), 3);
        showResult(intMax(3, 2, 1), 3);

        out.println("parrotTrouble():");
        showResult(parrotTrouble(true, 6), true);
        showResult(parrotTrouble(true, 7), false);
        showResult(parrotTrouble(false, 6), false);

        out.println("or35():");
        showResult(or35(3), true);
        showResult(or35(10), true);
        showResult(or35(8), false);

        out.println("startHi():");
        showResult(startHi("hi there"), true);
        showResult(startHi("hi"), true);
        showResult(startHi("hello hi"), false);

        out.println("max1020():");
        showResult(max1020(11, 19), 19);
        showResult(max1020(19, 11), 19);
        showResult(max1020(11, 9), 11);

        out.println("missingChar():");
        showResult(missingChar("kitten", 1), "ktten");
        showResult(missingChar("kitten", 0), "itten");
        showResult(missingChar("kitten", 4), "kittn");

        out.println("backAround():");
        showResult(backAround("cat"), "tcatt");
        showResult(backAround("Hello"), "oHelloo");
        showResult(backAround("a"), "aaa");

        out.println("front22():");
        showResult(front22("kitten"), "kikittenki");
        showResult(front22("Ha"), "HaHaHa");
        showResult(front22("abc"), "ababcab");
    }

}
