package pt.europeia.aed.eia1.session4;

import static java.lang.System.out;

/*
 * Solutions for some of the CodingBat (Warmup-2) exercises:
 */
public class CodingBatTester {

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
     * Given an array of ints, return the number of times that two 6's are next
     * to each other in the array. Also count instances where the second "6" is
     * actually a 7.
     */
    public static int array667(final int[] numbers) {
        // Again, we use a counter which is incremented whenever a 66 or 67 pair
        // is found. Since we check the array items at i and i + 1, we must make
        // sure i + 1 stays within the array, that is, i + 1 < numbers.length,
        // which is the same as i < numbers.length - 1. Notice the use of
        // parenthesis around the or operator. This is required, since the and
        // operator has more precedence than the or operator.
        int numberOfPairs = 0;

        for (int i = 0; i < numbers.length - 1; i++)
            if (numbers[i] == 6 && (numbers[i + 1] == 6 || numbers[i + 1] == 7))
                numberOfPairs++;

        return numberOfPairs;
    }

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
     * Given an array of ints, return true if one of the first 4 elements in the
     * array is a 9. The array length may be less than 4.
     */
    public static boolean arrayFront9(final int[] numbers) {
        // The number of array items to check is 4 is the array lenght if at
        // least 4. If the array length is smaller than 4, the number of items
        // to check is given by the array length. Hence, the number of items to
        // check is given by the smaller of two values: 4 and the array length.
        for (int i = 0; i != Math.min(4, numbers.length); i++)
            if (numbers[i] == 9)
                return true;

        return false;
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
        out.println("stringMatch():");
        showResult(stringMatch("xxcaazz", "xxbaaz"), 3);
        showResult(stringMatch("abc", "abc"), 2);
        showResult(stringMatch("abc", "axc"), 0);

        out.println("arrayCount9():");
        showResult(arrayCount9(new int[] { 1, 2, 9 }), 1);
        showResult(arrayCount9(new int[] { 1, 9, 9 }), 2);
        showResult(arrayCount9(new int[] { 1, 9, 9, 3, 9 }), 3);

        out.println("array667():");
        showResult(array667(new int[] { 6, 6, 2 }), 1);
        showResult(array667(new int[] { 6, 6, 2, 6 }), 1);
        showResult(array667(new int[] { 6, 7, 2, 6 }), 1);

        out.println("has271():");
        showResult(has271(new int[] { 1, 2, 7, 1 }), true);
        showResult(has271(new int[] { 1, 2, 8, 1 }), false);
        showResult(has271(new int[] { 2, 7, 1 }), true);

        out.println("arrayFront9():");
        showResult(arrayFront9(new int[] { 1, 2, 9, 3, 4 }), true);
        showResult(arrayFront9(new int[] { 1, 2, 3, 4, 9 }), false);
        showResult(arrayFront9(new int[] { 1, 2, 3, 4, 5 }), false);
    }

}
