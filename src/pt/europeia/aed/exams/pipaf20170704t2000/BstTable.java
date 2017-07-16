package pt.europeia.aed.exams.pipaf20170704t2000;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BstTable<Key extends Comparable<? super Key>, Value> {

    private Node<Key, Value> root;

    private static class Node<Key, Value> {

        private final Key key;
        private Value value;
        private Node<Key, Value> left = null;
        private Node<Key, Value> right = null;
        private int size = 1;

        public Node(final Key key, final Value value) {
            this.key = key;
            this.value = value;
        }

    }

    public BstTable() {
        root = null;

        checkInvariant();
    }

    public int size() {
        checkInvariant();

        return sizeOf(root);
    }

    public boolean isEmpty() {
        checkInvariant();

        return size() == 0;
    }

    public boolean contains(final Key key) {
        checkInvariant();

        return valueFor(key) != null;
    }

    public Value valueFor(final Key key) {
        checkInvariant();

        return valueFor(key, root);
    }

    public Iterable<Key> keys() {
        checkInvariant();

        final Queue<Key> keys = new Queue<Key>();

        enqueueKeysIn(keys, root);

        return keys;
    }

    public void put(final Key key, final Value value) {
        checkInvariant();

        if (value == null) {
            delete(key);
            return;
        }

        root = putIn(key, value, root);

        checkInvariant();
    }

    public void delete(final Key key) {
        checkInvariant();

        root = deleteFrom(key, root);

        checkInvariant();
    }

    private int sizeOf(final Node<Key, Value> tree) {
        if (tree == null)
            return 0;

        return tree.size;
    }

    private Value valueFor(final Key key, final Node<Key, Value> tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);

        if (comparison < 0)
            return valueFor(key, tree.left);
        if (comparison > 0)
            return valueFor(key, tree.right);

        return tree.value;
    }

    private Node<Key, Value> putIn(final Key key, final Value value,
            final Node<Key, Value> tree) {
        if (tree == null)
            return new Node<Key, Value>(key, value);

        final int comparison = key.compareTo(tree.key);

        if (comparison < 0)
            tree.left = putIn(key, value, tree.left);
        else if (comparison > 0)
            tree.right = putIn(key, value, tree.right);
        else
            tree.value = value;

        tree.size = 1 + sizeOf(tree.left) + sizeOf(tree.right);

        return tree;
    }

    private Node<Key, Value> deleteFrom(final Key key, Node<Key, Value> tree) {
        if (tree == null)
            return null;

        final int comparison = key.compareTo(tree.key);

        if (comparison < 0)
            tree.left = deleteFrom(key, tree.left);
        else if (comparison > 0)
            tree.right = deleteFrom(key, tree.right);
        else {
            if (tree.right == null)
                return tree.left;
            if (tree.left == null)
                return tree.right;

            final Node<Key, Value> originalTree = tree;

            tree = minimumNodeOf(originalTree.right);
            tree.right = deleteMinimumOf(originalTree.right);
            tree.left = originalTree.left;
        }

        tree.size = 1 + sizeOf(tree.left) + sizeOf(tree.right);

        return tree;
    }

    private Node<Key, Value> minimumNodeOf(final Node<Key, Value> tree) {
        if (tree.left == null)
            return tree;

        return minimumNodeOf(tree.left);
    }

    private void enqueueKeysIn(final Queue<Key> keys,
            final Node<Key, Value> tree) {
        if (tree == null)
            return;

        enqueueKeysIn(keys, tree.left);
        
        keys.enqueue(tree.key);
        
        enqueueKeysIn(keys, tree.right);
    }

    private Node<Key, Value> deleteMinimumOf(final Node<Key, Value> tree) {
        if (tree.left == null)
            return tree.right;

        tree.left = deleteMinimumOf(tree.left);

        tree.size = 1 + sizeOf(tree.left) + sizeOf(tree.right);

        return tree;
    }

    private void checkInvariant() {
        assert isBst() : "Binary tree not in symmetric order.";
        assert isSizeConsistent() : "Subtree sizes of binary tree are not consistent.";
    }

    private boolean isBst() {
        return isBstBetween(root, null, null);
    }

    private boolean isBstBetween(final Node<Key, Value> tree, final Key minimum,
            final Key maximum) {
        if (tree == null)
            return true;

        if (minimum != null && tree.key.compareTo(minimum) <= 0)
            return false;

        if (maximum != null && tree.key.compareTo(maximum) >= 0)
            return false;

        return isBstBetween(tree.left, minimum, tree.key)
                && isBstBetween(tree.right, tree.key, maximum);
    }

    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }

    private boolean isSizeConsistent(final Node<Key, Value> tree) {
        if (tree == null)
            return true;

        if (tree.size != 1 + sizeOf(tree.left) + sizeOf(tree.right))
            return false;

        return isSizeConsistent(tree.left) && isSizeConsistent(tree.right);
    }

    public static void main(String[] args) {
        final BstTable<String, Integer> table = new BstTable<String, Integer>();

        for (int i = 0; !StdIn.isEmpty(); i++) {
            final String key = StdIn.readString();
            table.put(key, i);
        }

        StdOut.println("Key order:");
        for (String key : table.keys())
            StdOut.println(key + " " + table.valueFor(key));
    }

}

/*
 * Copyright 2015 and 2016, Robert Sedgewick and Kevin Wayne.
 * 
 * Copyright 2015 and 2016, Manuel Menezes de Sequeira.
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