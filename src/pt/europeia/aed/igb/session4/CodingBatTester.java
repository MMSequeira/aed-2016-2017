package pt.europeia.aed.igb.session4;

import static java.lang.System.out;

/*
 * Solutions for some of the CodingBat (Warmup-2) exercises:
 */
public class CodingBatTester {

    /*
     * Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a
     * value, followed by the value plus 5, followed by the value minus 1.
     * Additionally the 271 counts even if the "1" differs by 2 or less from the
     * correct value.
     */
    public static boolean has271(final int[] numbers) {
        // In this case we must analyze three array items at a time, at
        // positions i, i + 1, and i + 2. We do it from left to right. Since we
        // must make sure we stay within the limits of the array, i + 2 <
        // numbers.length, which is the same as i < numbers.length - 2. The is a
        // match if the value at i + 1 is equal to the value at i plus 5, and if
        // the distance between the value at i + 2 and the value at i minus one
        // is at most 2.
        for (int i = 0; i < numbers.length - 2; i++)
            if (numbers[i + 1] == numbers[i] + 5
                    && Math.abs(numbers[i + 2] - (numbers[i] - 1)) <= 2)
                return true;

        return false;
    }

    /*
     * Suppose the string "yak" is unlucky. Given a string, return a version
     * where all the "yak" are removed, but the "a" can be any char. The "yak"
     * strings will not overlap.
     */
    public static String stringYak(final String string) {
        // We start with an empty string and add character from string one by
        // one. We go through the original string using index i. Instead of a
        // for loop, we use a while loop. This makes it clearer that the
        // progress of i is different according to whether a "y*k" pattern is
        // found starting at i. If it is found, we do *not* add the current
        // character to the result string and we increment i by 3, so that the
        // three characters of the "y*k" pattern are ignored. If it is not
        // found, we add the current character to the return string and
        // increment i by one, since no characters are to be ignored in this
        // case. A "y*k" pattern is found if i is smaller than string.length() -
        // 2 (i.e., there are at least two characters in the string to the right
        // of i), the character at i is 'y', and the character at i + 2 is 'k'.
        String result = "";

        int i = 0;
        while (i < string.length())
            if (i < string.length() - 2 && string.charAt(i) == 'y'
                    && string.charAt(i + 2) == 'k')
                i += 3;
            else {
                result += string.charAt(i);
                i++;
            }

        return result;
    }

    /*
     * Given a string, return a version where all the "x" have been removed.
     * Except an "x" at the very start or end should not be removed.
     */
    public static String stringX(final String string) {
        // The solution in this case if simple. We go though all the string
        // characters, from left to right, and add them to the result string
        // successively (actually, we build a new string each time we
        // concatenate a new character, which is not efficient: we should have
        // used StringBuilder). However, we only add the current character if
        // one of three conditions holds: it is the first character (i is 0), it
        // is the last character (i is string.length() - 1) or the current
        // character is not an 'x'.
        String result = "";

        for (int i = 0; i < string.length(); i++)
            if (i == 0 || i == string.length() - 1 || string.charAt(i) != 'x')
                result += string.charAt(i);

        return result;

        // This alternative solution does not use an explicit loop. Instead, it
        // relies in methods from the String class. The idea is simple. If the
        // string length is at the most 2, no characters are to be removed
        // (since any characters in the string would either be the first of the
        // last). If there are more than two characters in the string, the
        // result is the substring of the original string excluding the first
        // and last characters, with all the 'x' characters removed, with the
        // first character and last characters added at their appropriate
        // positions.
        /*-
        if (string.length() <= 2)
            return string;
        
        return string.charAt(0)
                + string.substring(1, string.length() - 1).replace("x", "")
                + string.charAt(string.length() - 1);
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
        out.println("has271():");
        showResult(has271(new int[] { 1, 2, 7, 1 }), true);
        showResult(has271(new int[] { 1, 2, 8, 1 }), false);
        showResult(has271(new int[] { 2, 7, 1 }), true);

        out.println("stringYak():");
        showResult(stringYak("yakpak"), "pak");
        showResult(stringYak("pakyak"), "pak");
        showResult(stringYak("yak123ya"), "123ya");

        out.println("stringX():");
        showResult(stringX("xxHxix"), "xHix");
        showResult(stringX("abxxxcd"), "abcd");
        showResult(stringX("xabxxxcdx"), "xabcdx");
    }

}
