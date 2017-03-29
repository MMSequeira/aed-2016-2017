package pt.europeia.aed.book.chapter1.section3.iterable;

import static pt.europeia.aed.Tools.out;

import java.util.ConcurrentModificationException;

// A few tests for the ResizingArrayQueue class: 
public class ResizingArrayQueueTester {

    public static void main(final String[] arguments) {
        out.println("Testing ResizingArrayQueue…");

        final ResizingArrayQueue<Integer> numbers = new ResizingArrayQueue<>();

        assert numbers.size() == 0 : "Size should be 0.";
        assert numbers.isEmpty() : "Queue should be empty.";

        final int repetitions = 1000;
        final int smallSequence = 7;
        final int largeSequence = 11;

        int numberToEnqueue = 0;
        int numberToDequeue = 0;

        for (int repetition = 0; repetition != repetitions; repetition++) {
            for (int i = 0; i != largeSequence; i++) {
                numbers.enqueue(numberToEnqueue);
                numberToEnqueue++;
            }
            for (int i = 0; i != smallSequence; i++) {
                final int dequeuedNumber = numbers.dequeue();
                assert dequeuedNumber == numberToDequeue : "Dequeued number should be "
                        + numberToDequeue + ".";
                numberToDequeue++;
            }
        }

        assert numbers.size() == repetitions
                * (largeSequence - smallSequence) : "Queue size should be "
                        + repetitions * (largeSequence - smallSequence) + ".";
        assert !numbers.isEmpty() : "Queue should not be empty.";

        int numberToIterate = repetitions * smallSequence;

        for (int iteratedNumber : numbers) {
            assert iteratedNumber == numberToIterate : "Iterated number should be "
                    + numberToIterate + ".";
            numberToIterate++;
        }

        for (int repetition = 0; repetition != repetitions; repetition++) {
            for (int i = 0; i != smallSequence; i++) {
                numbers.enqueue(numberToEnqueue);
                numberToEnqueue++;
            }
            for (int i = 0; i != largeSequence; i++) {
                final int dequeuedNumber = numbers.dequeue();
                assert dequeuedNumber == numberToDequeue : "Dequeued number should be "
                        + numberToDequeue + ".";
                numberToDequeue++;
            }
        }

        assert numbers.size() == 0 : "Size should be 0.";
        assert numbers.isEmpty() : "Queue should be empty.";

        numbers.enqueue(0);
        
        try {
            for (int number : numbers)
                numbers.enqueue(number);
            assert false : "Exception should have been thrown.";
        } catch (ConcurrentModificationException exception) {
            // Don't do this at home! ConcurrentModificationException is a
            // RuntimeExceptions, and RuntimeExceptions should *not* be ignored!
            // This, however, is test intended to check that the exception is
            // indeed thrown when appropriate, so in this case the failure to
            // throw is the error!
            out.println("\tExpected exception thrown: " + exception);
        }

        try {
            for (@SuppressWarnings("unused") int number : numbers)
                numbers.dequeue();
            assert false : "Exception should have been thrown.";
        } catch (ConcurrentModificationException exception) {
            // Don't do this at home!
            out.println("\tExpected exception thrown: " + exception);
        }

        out.println("Tests passed.");
    }

}
