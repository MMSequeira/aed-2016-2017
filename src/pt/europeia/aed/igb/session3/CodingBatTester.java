package pt.europeia.aed.igb.session3;

import static java.lang.System.out;

/*
 * Solutions for some of the CodingBat (Warmup-1) exercises:
 */
public class CodingBatTester {

    /*
     * Given 2 positive int values, return the larger value that is in the range
     * 10..20 inclusive, or return 0 if neither is in that range.
     */
    public static int max1020(final int a, final int b) {
        // Lots of different solutions are possible. This solution is made
        // simple by the use of a variable. We use this variable to store
        // the largest value seen at each point of the code. Since initially the
        // values of a and b have not yet been considered, the largest value is
        // seen to be 0 (since 0 is the value to return if both a and b are
        // outside of the valid range of values).
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
     * Given 2 int values, return whichever value is nearest to the value 10, or
     * return 0 in the event of a tie. Note that Math.abs(n) returns the
     * absolute value of a number.
     */
    public static int close10(final int a, final int b) {
        // The solution is made simpler if we pre-calculate the distances of
        // both numbers to 10. The distances are calculated as |a - 10| and |b -
        // 10|. Since Java does not have an absolute value operator, we use the
        // Math.abs() method.
        final int distanceOfATo10 = Math.abs(a - 10);
        final int distanceOfBTo10 = Math.abs(b - 10);

        // There are three cases here. If a's distance to 10 is smaller than
        // b's, we must return a. If it is not, then it may be either larger or
        // equal. If it is larger, that is, if b's distance to 10 is smaller
        // than a's, we must return b. If it is not, then a's distance to 10 is
        // neither smaller nor larger than b's, which means it must be equal and
        // we must return 0.
        if (distanceOfATo10 < distanceOfBTo10)
            return a;
        else if (distanceOfBTo10 < distanceOfATo10)
            return b;
        else
            return 0;
    }

    /*
     * Given 2 int values, return true if either of them is in the range 10..20
     * inclusive.
     */
    public static boolean in1020(final int a, final int b) {
        // Simple solution using a single return statement. The boolean value of
        // the expression is returned directly. Notice that parenthesis are not
        // required around the and operator, since it has higher precedence
        // than the or operator.
        return 10 <= a && a <= 20 || 10 <= b && b <= 20;

        // Slightly more verbose solution using an if-else (selection)
        // statement:
        /*-
        if (10 <= a && a <= 20 || 10 <= b && b <= 20)
            return true;
        else
            return false;
        */
    }

    /*
     * Given two int values, return their sum. Unless the two values are the
     * same, then return double their sum.
     */
    public static int sumDouble(final int a, final int b) {
        // This solution makes use of the ? : ternary operator. This operator
        // has three operands: condition ? expression_1 : expression_2. The
        // result is the value of expression_1 if the condition is true, and it
        // is the value of expression_2 if the condition is false. It often can
        // be used to create short and clear code, but may also lead to quite
        // cryptic code, if the expressions envolved are complicated,
        // particularly if they involve other uses of the ? : operator.
        return a == b ? 2 * (a + b) : a + b;

        // The same solution, though using an if-else statement:
        /*-
        if (a == b)
            return 2 * (a + b);
        else
            return a + b;
        */
    }

    /*
     * Given a string, we'll say that the front is the first 3 chars of the
     * string. If the string length is less than 3, the front is whatever is
     * there. Return a new string which is 3 copies of the front.
     */
    public static String front3(final String string) {
        // A simple way to solve the problem is to break it into two parts: (a)
        // obtain the front of the string and (b) return the concatenation of
        // the front with itself twice. Obtaining the front requires
        // distinguishing to cases. Is the string is shorter than 3 characters,
        // the front is the string itself. If the string has at least 3
        // characters, the front is the substring with the first three
        // characters.
        final String front = string.length() < 3 ? string
                : string.substring(0, 3);

        // This alternative uses and if-else statement instead of the ? :
        // operator.
        /*-
        final String front;
        if (string.length() < 3)
            front = string;
        else
            front = string.substring(0, 3);
        */

        // Now that we have the front characters (if any), return the result.
        return front + front + front;
    }

    /*
     * Given a string, if the string "del" appears starting at index 1, return a
     * string where that "del" has been deleted. Otherwise, return the string
     * unchanged.
     */
    public static String delDel(final String string) {
        // For "del" to appear in the string in position 1 (the second
        // character), the string must have least four characters. If it has
        // less than 4 characters, then the result must be the string itself.
        // This is also true is the string length is sufficient, but characters
        // 1 to 3 do not correspond do "del". Notice that String.substring()
        // receives two arguments: the first is the index of the start of the
        // substring, the second is the index of the end of the substring *plus
        // 1*, that is, the range of characters to get from the string are
        // specified by the index of the beginning and ending characters, where
        // the former is given inclusive and the latter is given exclusive.
        // Notice also the use of equals(). Since strings are instances of class
        // String, a reference type, using the == operator would compare the
        // references to the substring to the reference to the string literal
        // "del", i.e., it would compare the two strings for identity (being the
        // same object or instance), rather than compare the two strings for
        // equality, which is our purpose. We must, therefore, use the
        // String.equals() method for checking string equality.
        //
        // If the string length is at least 4 and "del" is found at position 1,
        // then we must return a string with that "del" removed. For that, we
        // simply concatenate the first character (before "del") with the
        // substring starting at index 4 (fifth character) and going to the end
        // of the string.
        if (string.length() < 4 || !string.substring(1, 4).equals("del"))
            return string;
        else
            return string.charAt(0) + string.substring(4);
    }

    /*
     * Given three int values, a b c, return the largest.
     */
    public static int intMax(final int a, final int b, final int c) {
        // This solution uses a variable to store the maximum value seen at each
        // point. This variable is initialized to a, since a is the first
        // observed value and thus the also maximum before observing the rest of
        // the values. Then b is compared to the maximum. If it is larger, then
        // the current maximum is b's value, and thus the value of maximum is
        // updated. Then, the same process goes on for c. In the end, the value
        // of maximum is the maximum of a, b, and c, and thus it can be
        // returned.
        int maximum = a;

        if (b > maximum)
            maximum = b;

        if (c > maximum)
            maximum = c;

        return maximum;

        // This solution requires exactly two comparisons to do its job. It is
        // also not too hard to read.
        /*-
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
        */

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
     * An utility method for printing results together with expected results.
     */
    private static void showResult(final Object result,
            final Object expectedResult) {
        out.print("\t" + result + " should be " + expectedResult);
        out.println(result.equals(expectedResult) ? ": ✓" : ": ✗");
    }

    public static void main(final String[] arguments) {
        out.println("max1020():");
        showResult(max1020(11, 19), 19);
        showResult(max1020(19, 11), 19);
        showResult(max1020(11, 9), 11);

        out.println("close10():");
        showResult(close10(8, 13), 8);
        showResult(close10(13, 8), 8);
        showResult(close10(13, 7), 0);

        out.println("in1020():");
        showResult(in1020(12, 99), true);
        showResult(in1020(21, 12), true);
        showResult(in1020(8, 99), false);

        out.println("sumDouble():");
        showResult(sumDouble(1, 2), 3);
        showResult(sumDouble(3, 2), 5);
        showResult(sumDouble(2, 2), 8);

        out.println("front3():");
        showResult(front3("Java"), "JavJavJav");
        showResult(front3("Chocolate"), "ChoChoCho");
        showResult(front3("abc"), "abcabcabc");

        out.println("delDel():");
        showResult(delDel("adelbc"), "abc");
        showResult(delDel("adelHello"), "aHello");
        showResult(delDel("adedbc"), "adedbc");

        out.println("intMax():");
        showResult(intMax(1, 2, 3), 3);
        showResult(intMax(1, 3, 2), 3);
        showResult(intMax(3, 2, 1), 3);
    }

}
