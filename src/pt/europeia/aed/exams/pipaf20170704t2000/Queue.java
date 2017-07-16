package pt.europeia.aed.exams.pipaf20170704t2000;

import static java.lang.System.out;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;

public class Queue<Item> {
    private Node<Item> last;
    private int size;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Queue() {
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(final Item item) {
        final Node<Item> oldLast = last;

        last = new Node<Item>();

        last.item = item;

        if (oldLast == null)
            last.next = last;
        else {
            last.next = oldLast.next;
            oldLast.next = last;
        }

        size++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow.");

        final Item item = last.next.item;

        if (last.next == last)
            last = null;
        else
            last.next = last.next.next;

        size--;

        return item;
    }

    public static void main(final String[] arguments) {
        final Queue<String> words = new Queue<String>();
        while (!StdIn.isEmpty()) {
            final String word = StdIn.readString();
            if (word.equals("-"))
                if (words.isEmpty())
                    out.println("(empty)");
                else
                    out.print(words.dequeue() + " ");
            else
                words.enqueue(word);
        }
    }
}

/*
 * Copyright 2015 and 2016, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2015-2017, Manuel Menezes de Sequeira.
 *
 * This file is a derivative work of the code which accompanies the textbook
 *
 * Algorithms, 4th edition by Robert Sedgewick and Kevin Wayne, Addison-Wesley
 * Professional, 2011, ISBN 0-321-57351-X. http://algs4.cs.princeton.edu
 *
 * This code is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this code. If not, see http://www.gnu.org/licenses.
 *
 * Any errors found in this code should be assumed to be the responsibility of
 * the author of the modifications to the original code (viz. Manuel Menezes de
 * Sequeira).
 */
