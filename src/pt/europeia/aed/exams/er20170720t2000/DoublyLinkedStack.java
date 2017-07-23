package pt.europeia.aed.exams.er20170720t2000;

import static pt.europeia.aed.Tools.in;
import static pt.europeia.aed.Tools.out;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedStack<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    private class Node {
        private Item item;
        private Node previous;
        private Node next;
    }

    public DoublyLinkedStack() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void push(final Item item) {
        final Node oldFirst = first;

        first = new Node();

        first.item = item;
        first.previous = null;
        first.next = oldFirst;

        if (last == null)
            last = first;
        else
            oldFirst.previous = first;

        size++;
    }

    public Item pop() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow.");

        final Item item = first.item;

        first = first.next;

        if (first == null)
            last = null;
        else
            first.previous = null;

        size--;

        return item;
    }

    public Iterator<Item> iterator() {
        return new ForwardListIterator();
    }

    public Iterator<Item> reverseIterator() {
        return new ReverseListIterator();
    }

    private class ForwardListIterator implements Iterator<Item> {

        private Node nextNode = first;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more items in iteration.");

            final Item item = nextNode.item;

            nextNode = nextNode.next;

            return item;
        }

    }

    private class ReverseListIterator implements Iterator<Item> {

        private Node nextNode = last;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException("No more items in iteration.");

            final Item item = nextNode.item;

            nextNode = nextNode.previous;

            return item;
        }

    }

    public static void main(final String[] arguments) {
        final DoublyLinkedStack<String> words = new DoublyLinkedStack<String>();

        while (in.hasNext()) {
            final String word = in.next();
            if (word.equals("-")) {
                if (words.isEmpty())
                    out.println("[empty!]");
                else
                    out.println(words.pop() + " ");
            } else if (word.equals("*")) {
                out.print("S: ");
                for (final String w : words)
                    out.print(w + " ");
                out.println();
            } else if (word.equals("+")) {
                out.print("S [reverse]: ");
                final Iterator<String> iterator = words.reverseIterator();
                while (iterator.hasNext())
                    out.print(iterator.next() + " ");

                out.println();
            } else
                words.push(word);
        }
        out.println();

        out.println();

        out.println("Remaining words (reverse):");
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
