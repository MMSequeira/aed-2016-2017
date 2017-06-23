package pt.europeia.aed.extra.session1;

import static java.lang.System.out;

import java.util.Arrays;

public class DateTester {

    public static void main(final String[] arguments) {
        final Date[] dates = { new Date(2017, 06, 10), new Date(2017, 06, 1),
            new Date(2017, 06, 30) };
        
        out.println(Arrays.toString(dates));
        
        Arrays.sort(dates);

        out.println(Arrays.toString(dates));
        
        Arrays.sort(dates, Date.reverseComparator);
        
        out.println(Arrays.toString(dates));
    }

}
