package pt.europeia.aed.eia1.session3;

/*
 * Solutions for some of the CodingBat (Warmup-1) exercises:
 */
public class CodingBatTester {

    /*
     * The parameter isWeekday is true if it is a weekday, and the parameter
     * isVacation is true if we are on vacation. We sleep in if it is not a
     * weekday or we're on vacation. Return true if we sleep in.
     */
    public static boolean sleepIn(final boolean isWeekday,
            final boolean isVacation) {
        // Simple solution using a single return statement. The boolean value of
        // the expression is returned directly. The variables are use directly,
        // not compared with true or false. The negation operator ! is used to
        // check is it is *not* a weekday.
        return !isWeekday || isVacation;

        // Slightly more verbose solution using an if-else (selection)
        // statement:
        /*-
        if (!isWeekday || isVacation)
            return true;
        else
            return false;
        */

        // A more verbose solution using an if-else (selection) statement and
        // comparison of the boolean variables with true and false:
        /*-
        if (isWeekday == false || isVacation == true)
            return true;
        else
            return false;
        */
    }

    /*
     * We have two monkeys, a and b, and the parameters aSmile and bSmile
     * indicate if each is smiling. We are in trouble if they are both smiling
     * or if neither of them is smiling. Return true if we are in trouble.
     */
    public static boolean monkeyTrouble(final boolean monkeyAIsSmiling,
            final boolean monkeyBIsSmiling) {
        // The simplest solution returns the result of the comparison between
        // the truth values of both variables. Is the truth value is equal, the
        // function returns true. If it is not, it returns false. The truth
        // values are equal either is they are both true or if they are both
        // false.
        return monkeyAIsSmiling == monkeyBIsSmiling;

        // This solution is a bit more verbose, but it perhaps expresses more
        // clearly the what is required from this function:
        /*-
        return monkeyAIsSmiling && monkeyBIsSmiling
                || !monkeyAIsSmiling && !monkeyBIsSmiling;
        */

        // Slightly more verbose solution using an if-else (selection)
        // statement:
        /*-
        if (monkeyAIsSmiling && monkeyBIsSmiling
                || !monkeyAIsSmiling && !monkeyBIsSmiling)
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
     * Given an int n, return the absolute difference between n and 21, except
     * return double the absolute difference if n is over 21.
     */
    public static int diff21(final int n) {
        // Just as the solutions for the sumDouble() problem, we may either use
        // the ? : operator or the if-else statement. In both cases, there is no
        // need to use Math.abs() to calculate the absolute value of the
        // difference: since we know whether or not n > 21, we may calculate the
        // difference as either n - 21 or 21 - n, thus assuring we get a
        // non-negative result.
        return n > 21 ? 2 * (n - 21) : 21 - n;

        /*-
        if (n > 21)
            return 2 * (n - 21);
        else
            return 21 - n;
        */
    }

    /*
     * We have a loud talking parrot. The "hour" parameter is the current hour
     * time in the range 0..23. We are in trouble if the parrot is talking and
     * the hour is before 7 or after 20. Return true if we are in trouble.
     */
    public boolean parrotTrouble(final boolean isTalking, final int hour) {
        // Two solutions again, using a simple return or an if-else statement.
        // Notice that parenthesis are required around the or operator, since it
        // has lower precedence than the and operator.
        return (hour < 7 || hour > 20) && isTalking;

        /*-
        if ((hour < 7 || hour > 20) && isTalking)
            return true;
        else
            return false;
        */
    }

    /*
     * Given 2 ints, a and b, return true if one if them is 10 or if their sum
     * is 10.
     */
    public static boolean makes10(final int a, final int b) {
        // No comments necessary. :-)
        return a == 10 || b == 10 || a + b == 10;
    }

    /*
     * Given an int n, return true if it is within 10 of 100 or 200. Note:
     * Math.abs(num) computes the absolute value of a number.
     */
    public static boolean nearHundred(final int n) {
        // This is the most straightforward solution, since it reflects directly
        // what is required from the function:
        return Math.abs(n - 100) <= 10 || Math.abs(n - 200) <= 10;

        // This alternative is shorter, but since it does not directly reflect
        // the intent of the function, it is harder to change. If the distance
        // from 100 or 200 must be changed, say, from 10 to 15, four "magic"
        // numbers must be changed, in this case. Notice that no parenthesis are
        // necessary, since the and operator has higher precedence than the or
        // operator.
        /*-
        return n >= 90 && n <= 110 || n >= 190 && n <= 210;
        */
    }

    /*
     * Given 2 int values, return true if one is negative and one is positive.
     * Except if the parameter "negative" is true, then return true only if both
     * are negative.
     */
    public static boolean posNeg(final int a, final int b,
            final boolean negative) {
        // In this case, it is clearer to separate the two different conditions
        // into two return statements, according to the value of "negative". The
        // expressions in each return statement directly reflect the text of the
        // problem. Notice that no parenthesis are necessary, since the and
        // operator has higher precedence than the or operator.
        if (negative)
            return a < 0 && b < 0;
        else
            return a > 0 && b < 0 || a < 0 && b > 0;
    }

    public static void main(final String[] arguments) {
        // Tests should be added here. You may use CodingBat's tests, though, so
        // they are not repeated here.
    }

}
