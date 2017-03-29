package pt.europeia.aed.book.chapter1.section3.iterable;

import static pt.europeia.aed.Tools.in;
import static pt.europeia.aed.Tools.out;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;
    private int head;
    private int tail;
    private int numberOfChanges;

    @SuppressWarnings("unchecked")
    public ResizingArrayQueue() {
        items = (Item[]) new Object[1];
        size = 0;
        head = 0;
        tail = 0;
        numberOfChanges++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(final Item item) {
        if (size == items.length)
            changeCapacityTo(2 * items.length);

        items[tail] = item;

        tail++;

        if (tail == items.length)
            tail = 0;

        size++;
        
        numberOfChanges++;
    }

    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");

        final Item item = items[head];

        items[head] = null;

        head++;
        if (head == items.length)
            head = 0;

        size--;

        if (size > 0 && size == items.length / 4)
            changeCapacityTo(items.length / 2);

        numberOfChanges++;
        
        return item;
    }

    private void changeCapacityTo(final int newCapacity) {
        @SuppressWarnings("unchecked")
        final Item[] copyOfItems = (Item[]) new Object[newCapacity];

        for (int i = 0; i != size; i++)
            copyOfItems[i] = items[(head + i) % items.length];

        items = copyOfItems;
        head = 0;
        tail = size % items.length;
    }

    public Iterator<Item> iterator() {
        return new ArraySegmentIterator();
    }

    private class ArraySegmentIterator implements Iterator<Item> {

        private int current = 0;
        private int initialNumberOfChanges = numberOfChanges;

        public boolean hasNext() {
            if (numberOfChanges != initialNumberOfChanges)
                throw new ConcurrentModificationException(
                        "Queue changed while iterating.");

            return current < size;
        }

        public Item next() {
            if (numberOfChanges != initialNumberOfChanges)
                throw new ConcurrentModificationException(
                        "Queue changed while iterating.");

            if (!hasNext())
                throw new NoSuchElementException("No more items in iteration.");

            final Item item = items[(head + current) % items.length];
            
            current++;

            return item;
        }

    }

    public static void main(final String[] arguments) {
        final ResizingArrayQueue<String> words = new ResizingArrayQueue<>();

        while (in.hasNext()) {
            final String word = in.next();
            if (!word.equals("-"))
                words.enqueue(word);
            else if (!words.isEmpty())
                out.print(words.dequeue() + " ");
        }
    }

}

/*
 * Copyright 2015-2017, Robert Sedgewick and Kevin Wayne.
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
