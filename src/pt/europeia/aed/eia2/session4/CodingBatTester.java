package pt.europeia.aed.eia2.session4;

import static java.lang.System.out;

/*
 * Solutions for some of the CodingBat (Warmup-2) exercises:
 */
public class CodingBatTester {

    /*
     * Given an array of ints, return the number of 9's in the array.
     */
    public static int arrayCount9(final int[] numbers) {
        // We simply go through all of the values in the array and increment the
        // counter of 9s whenever the value is 9. Here, we use the for-each
        // statement, since it makes the code clearer and shorter.
        int numberOf9s = 0;

        for (int number : numbers)
            if (number == 9)
                numberOf9s++;

        // We might also have used a regular for loop, with an explicit index.
        /*-
        for (int i = 0; i != numbers.length; i++)
            if (numbers[i] == 9)
                numberOf9s++;
        */

        return numberOf9s;
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

        for (int i = 0; i != string.length(); i++)
            if (i == 0 || i == string.length() - 1 || string.charAt(i) != 'x')
                result += string.charAt(i);

        return result;
    }

    /*
     * Given 2 strings, a and b, return the number of the positions where they
     * contain the same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3,
     * since the "xx", "aa", and "az" substrings appear in the same place in
     * both strings.
     */
    public static int stringMatch(final String a, final String b) {
        // The algorithm used to solve the problem is straightforward: scan both
        // strings simultaneously, from left to right, observing successive
        // pairs of characters from both. If equal pairs of characters occur,
        // the number of matches, which is initialized with 0, is incremented.
        // The most interesting part of the algorithm is how to guarantee that
        // we don't scan past the end of any of the strings. Since the strings
        // may have different lengths, the scan must be performed up to the end
        // of the shortest of them. Thus, we start by storing the shortest
        // length in a constant, shortestLength. The loop that goes through all
        // possible pairs must also make sure only valid pairs are scanned.
        // Since index i is used as the index of the first character in the
        // current pair, we must make sure the second character in the pair, at
        // i + 1, is within the shortest of the strings. Thus, loop continues
        // while i + 1 < shortestLength, i.e., i < shortestLength - 1. Checking
        // for a match of pairs is done comparing the substrings of strings a
        // and b starting at i and ending at i + 1. Since the second argument of
        // String.substring() is the index of the last character *exclusive*, we
        // must pass i + 2 in order to make sure characters at i and i + 1 are
        // included. The match might also have been done using String.charAt()
        // and comparing the two pairs of characters from a and b at i and i + 1
        // separately.
        int numberOfMatches = 0;

        // We use Math.min() to compute the shortest of the string lengths.
        final int shortestLength = Math.min(a.length(), b.length());

        // We might also have used the ? : operator.
        /*-
        final int shortestLength = a.length() < b.length() ? a.length()
                : b.length();
        */

        for (int i = 0; i < shortestLength - 1; i++)
            if (a.substring(i, i + 2).equals(b.substring(i, i + 2)))
                numberOfMatches++;

        return numberOfMatches;
    }

    /*
     * Given a string, return true if the first instance of "x" in the string is
     * immediately followed by another "x".
     */
    public static boolean doubleX(final String string) {
        // We first use String.indexOf() to find the index of the first
        // occurrence of 'x' in the string. We then return true if three
        // conditions hold at the same time: string.indexOf("x") did not return
        // -1 (which would mean no 'x' was found), the index of the first 'x' is
        // smaller than the index of the last character in the string (which
        // would mean there could not be any other 'x' in the string), and the
        // character to the right of the first 'x' is also an 'x'.
        final int position = string.indexOf("x");

        return position != -1 && position < string.length() - 1
                && string.charAt(position + 1) == 'x';

        // We might also have used a loop. In this loop, we go through all
        // characters up to, but not including, the last (since we must also
        // check the character to the right of the current one). If an 'x' is
        // found at i, we must return. We return true if the character at i + 1
        // is also an 'x', and we return false otherwise. If no 'x' is found in
        // the loop, we return false.
        /*-
        for (int i = 0; i < string.length() - 1; i++)
            if (string.charAt(i) == 'x')
                return string.charAt(i + 1) == 'x';
        return false;
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
        out.println("arrayCount9():");
        showResult(arrayCount9(new int[] { 1, 2, 9 }), 1);
        showResult(arrayCount9(new int[] { 1, 9, 9 }), 2);
        showResult(arrayCount9(new int[] { 1, 9, 9, 3, 9 }), 3);

        out.println("stringX():");
        showResult(stringX("xxHxix"), "xHix");
        showResult(stringX("abxxxcd"), "abcd");
        showResult(stringX("xabxxxcdx"), "xabcdx");
        showResult(stringX("xabx xcdx"), "xab cdx");

        out.println("stringMatch():");
        showResult(stringMatch("xxcaazz", "xxbaaz"), 3);
        showResult(stringMatch("abc", "abc"), 2);
        showResult(stringMatch("abc", "axc"), 0);

        out.println("doubleX():");
        showResult(doubleX("axxbb"), true);
        showResult(doubleX("axaxax"), false);
        showResult(doubleX("xxxxx"), true);
    }

}
