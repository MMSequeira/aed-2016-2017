package pt.europeia.aed.book.chapter3.section4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LinearProbingHashTable<Key, Value> {

    private static final int initialCapacity = 4;

    private int size;
    private int capacity;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashTable() {
        this(initialCapacity);
    }

    @SuppressWarnings("unchecked")
    public LinearProbingHashTable(final int capacity) {
        this.capacity = capacity;
        size = 0;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        
        checkInvariant();
    }

    public int size() {
        checkInvariant();
        
        return size;
    }

    public boolean isEmpty() {
        checkInvariant();

        return size() == 0;
    }

    public boolean contains(final Key key) {
        checkInvariant();

        if (key == null)
            throw new IllegalArgumentException(
                    "Key passed to contains() cannot be null");

        return valueFor(key) != null;
    }

    public void put(final Key key, final Value value) {
        checkInvariant();

        if (key == null)
            throw new IllegalArgumentException(
                    "Key passed to put() cannot be null");

        if (value == null) {
            delete(key);
            return;
        }

        if (size >= capacity / 2)
            changeCapacityTo(2 * capacity);

        int i;
        for (i = hashCodeOf(key); keys[i] != null; i = (i + 1) % capacity)
            if (keys[i].equals(key)) {
                values[i] = value;

                checkInvariant();
                return;
            }

        keys[i] = key;
        values[i] = value;

        size++;
        
        checkInvariant();
    }

    public Value valueFor(Key key) {
        checkInvariant();

        if (key == null)
            throw new IllegalArgumentException(
                    "Key passed to valueFor() cannot be null");

        for (int i = hashCodeOf(key); keys[i] != null; i = (i + 1) % capacity)
            if (keys[i].equals(key))
                return values[i];

        return null;
    }

    public void delete(Key key) {
        checkInvariant();

        if (key == null)
            throw new IllegalArgumentException(
                    "Key passed to delete() cannot be null");

        if (!contains(key))
            return;

        int i = hashCodeOf(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % capacity;
        }

        keys[i] = null;
        values[i] = null;

        i = (i + 1) % capacity;
        while (keys[i] != null) {
            final Key keyToRehash = keys[i];
            final Value valueToRehash = values[i];

            keys[i] = null;
            values[i] = null;

            size--;

            put(keyToRehash, valueToRehash);

            i = (i + 1) % capacity;
        }

        size--;

        if (size > 0 && size <= capacity / 8)
            changeCapacityTo(capacity / 2);

        checkInvariant();
    }

    public Iterable<Key> keys() {
        checkInvariant();

        final Queue<Key> queue = new Queue<Key>();

        for (int i = 0; i != capacity; i++)
            if (keys[i] != null)
                queue.enqueue(keys[i]);

        return queue;
    }

    private int hashCodeOf(final Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private void changeCapacityTo(final int newCapacity) {
        LinearProbingHashTable<Key, Value> temporaryTable = new LinearProbingHashTable<Key, Value>(
                newCapacity);

        for (int i = 0; i != capacity; i++)
            if (keys[i] != null)
                temporaryTable.put(keys[i], values[i]);

        keys = temporaryTable.keys;
        values = temporaryTable.values;
        capacity = temporaryTable.capacity;
    }

    private void checkInvariant() {
        assert capacity >= 2 * size : "Hash table capacity " + capacity
                + " smaller than 2 x size, i.e., than " + 2 * size;
        assert allKeysCanBeFound() : "Some existing keys cannot be found.";
    }

    private boolean allKeysCanBeFound() {
        for (int i = 0; i != capacity; i++)
            if (keys[i] != null) {
                for (int j = hashCodeOf(keys[i]); keys[j] != null; j = (j + 1) % capacity)
                    if (keys[j].equals(keys[i]))
                        return values[j] == values[i];
                
                return false;
            }

        return true;
    }

    public static void main(final String[] arguments) {
        final LinearProbingHashTable<String, Integer> table = new LinearProbingHashTable<>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            final String key = StdIn.readString();
            table.put(key, i);
        }

        for (final String key : table.keys())
            StdOut.println(key + " " + table.valueFor(key));
    }

}

/*
 * Copyright 2002-2017, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2017, Manuel Menezes de Sequeira.
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