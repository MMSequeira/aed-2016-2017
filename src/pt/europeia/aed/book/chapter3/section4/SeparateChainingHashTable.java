package pt.europeia.aed.book.chapter3.section4;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import pt.europeia.aed.book.chapter3.section1.SequentialSearchTable;

public class SeparateChainingHashTable<Key, Value> {
    
    private static final int initialNumberOfChains = 4;

    private int size;
    private int numberOfChains;
    private SequentialSearchTable<Key, Value>[] chains;

    public SeparateChainingHashTable() {
        this(initialNumberOfChains);
    }

    @SuppressWarnings("unchecked")
    public SeparateChainingHashTable(final int numberOfChains) {
        this.numberOfChains = numberOfChains;

        chains = (SequentialSearchTable<Key, Value>[]) new SequentialSearchTable[numberOfChains];

        for (int i = 0; i != numberOfChains; i++)
            chains[i] = new SequentialSearchTable<>();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(final Key key) {
        if (key == null)
            throw new IllegalArgumentException(
                    "Key passed to contains() cannot be null");

        return valueFor(key) != null;
    }

    public Value valueFor(final Key key) {
        if (key == null)
            throw new IllegalArgumentException(
                    "Key passed to valueFor() cannot be null");
        
        final int i = hashCodeOf(key);
        
        return chains[i].valueFor(key);
    }

    public void put(final Key key, final Value value) {
        if (key == null)
            throw new IllegalArgumentException(
                    "Key passed to put() cannot be null");

        if (value == null) {
            delete(key);
            return;
        }

        if (size >= 10 * numberOfChains)
            changeNumberOfChainsTo(2 * numberOfChains);

        final int i = hashCodeOf(key);

        if (!chains[i].contains(key))
            size++;

        chains[i].put(key, value);
    }

    public void delete(final Key key) {
        if (key == null)
            throw new IllegalArgumentException(
                    "Key passed to delete() cannot be null");

        final int i = hashCodeOf(key);

        if (chains[i].contains(key))
            size--;

        chains[i].delete(key);

        if (numberOfChains > initialNumberOfChains
                && size <= 2 * numberOfChains)
            changeNumberOfChainsTo(numberOfChains / 2);
    }

    public Iterable<Key> keys() {
        final Queue<Key> queue = new Queue<>();

        for (int i = 0; i != numberOfChains; i++)
            for (final Key key : chains[i].keys())
                queue.enqueue(key);

        return queue;
    }

    private void changeNumberOfChainsTo(final int newNumberOfChains) {
        final SeparateChainingHashTable<Key, Value> temporaryTable = new SeparateChainingHashTable<>(
                newNumberOfChains);

        for (int i = 0; i != numberOfChains; i++)
            for (Key key : chains[i].keys())
                temporaryTable.put(key, chains[i].valueFor(key));

        this.numberOfChains = temporaryTable.numberOfChains;
        this.size = temporaryTable.size;
        this.chains = temporaryTable.chains;
    }

    private int hashCodeOf(final Key key) {
        return (key.hashCode() & 0x7fffffff) % numberOfChains;
    }

    public static void main(final String[] arguments) {
        final SeparateChainingHashTable<String, Integer> table = new SeparateChainingHashTable<>();

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