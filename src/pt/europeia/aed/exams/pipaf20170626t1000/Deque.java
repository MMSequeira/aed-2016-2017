package pt.europeia.aed.exams.pipaf20170626t1000;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> {
    private Item[] items;
    private int size;
    private int first; // index of first item (inclusive)
    private int last; // index of last item (inclusive)

    @SuppressWarnings("unchecked")
    public Deque() {
        items = (Item[]) new Object[1];
        first = 0;
        last = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Item first() {
        if (isEmpty())
            throw new NoSuchElementException(
                    "Attempt to get first item of empty dequeue.");

        return items[first];
    }

    public Item last() {
        if (isEmpty())
            throw new NoSuchElementException(
                    "Attempt to get last item of empty dequeue.");

        return items[last];
    }

    public void enqueueAsLast(final Item newItem) {
        if (size == items.length)
            changeCapacityTo(2 * items.length);

        last++;
        if (last == items.length)
            last = 0;

        items[last] = newItem;

        size++;
    }

    public void enqueueAsFirst(final Item newItem) {
        if (size == items.length)
            changeCapacityTo(2 * items.length);

        first--;
        if (first == -1)
            first = items.length - 1;

        items[first] = newItem;

        size++;
    }

    public Item dequeueFirst() {
        if (isEmpty())
            throw new NoSuchElementException("Dequeue underflow");

        final Item item = items[first];

        items[first] = null;

        first++;
        if (first == items.length)
            first = 0;

        size--;

        if (size > 0 && size == items.length / 4)
            changeCapacityTo(items.length / 2);

        return item;
    }

    public Item dequeueLast() {
        if (isEmpty())
            throw new NoSuchElementException("Dequeue underflow");

        final Item item = items[last];

        items[last] = null;

        last--;
        if (last == -1)
            last = items.length - 1;

        size--;

        if (size > 0 && size == items.length / 4)
            changeCapacityTo(items.length / 2);

        return item;
    }

    private void changeCapacityTo(final int newCapacity) {
        @SuppressWarnings("unchecked")
        final Item[] copyOfItems = (Item[]) new Object[newCapacity];

        for (int i = 0; i != size; i++)
            copyOfItems[i] = items[(first + i) % items.length];

        items = copyOfItems;
        first = 0;
        last = (size - 1 + items.length) % items.length;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        for (int i = 0; i != size; i++) {
            s.append(items[(first + i) % items.length]);
            if (i != size - 1)
                s.append(", ");
        }
        s.append(")");
        return s.toString();
    }

    public String reverseToString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        for (int i = size - 1; i != -1; i--) {
            s.append(items[(first + i) % items.length]);
            if (i != 0)
                s.append(", ");
        }
        s.append(")");
        return s.toString();
    }

    public static void main(final String[] arguments) {
        final Deque<String> words = new Deque<String>();
        while (!StdIn.isEmpty()) {
            final String word = StdIn.readString();
            if (word.equals("-") || word.equals("+") || word.equals("t")
                    || word.equals("T")) {
                if (words.isEmpty())
                    StdOut.println("Empty!");
                else if (word.equals("t"))
                    StdOut.println(words.toString());
                else if (word.equals("T"))
                    StdOut.println(words.reverseToString());
                else if (word.equals("-"))
                    StdOut.println(words.dequeueFirst());
                else
                    StdOut.println(words.dequeueLast());
            } else if (Character.isLowerCase(word.charAt(0)))
                words.enqueueAsLast(word);
            else
                words.enqueueAsFirst(word);
        }
        StdOut.println(words.size() + " words left on dequeue: " + words);
    }
}

/*
 * Copyright 2017, Manuel Menezes de Sequeira.
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
 */