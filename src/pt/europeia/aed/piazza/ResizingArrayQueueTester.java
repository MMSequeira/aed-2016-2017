package pt.europeia.aed.piazza;

import static pt.europeia.aed.Tools.out;

import pt.europeia.aed.book.chapter1.section3.iterable.ResizingArrayQueue;

// Don't try this at home! Do not attempt to recover from an OutofMemoryError!
//
// OK. Now that you've been warned, run this with different -Xmx values. Try
// -Xmx16M and -Xmx4G, for instance. 
public class ResizingArrayQueueTester {

    public static void main(final String[] arguments) {
        out.println("Testing enqueues:");
        out.println("\tMaximum memory available: "
                + Runtime.getRuntime().maxMemory());
        out.println("\tMemory used: " + Runtime.getRuntime().totalMemory());
        final String dummy = "Nothing";
        final ResizingArrayQueue<String> queue = new ResizingArrayQueue<>();

        int numberOfEnqueues = 0;
        try {
            while (true) {
                queue.enqueue(dummy);
                numberOfEnqueues++;
            }
        } catch (final OutOfMemoryError error) {
            out.println("\tFailed after " + numberOfEnqueues + " enqueues.");
            out.println("\tError was: " + error);
            out.println("\tMemory used: " + Runtime.getRuntime().totalMemory());
        }
    }

}
