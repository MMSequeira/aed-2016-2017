package pt.europeia.aed.book.chapter3.section4;

public class LinearProbingHashTableTester {

    public static void main(final String[] arguments) {
        final LinearProbingHashTable<String, Integer> table = new LinearProbingHashTable<>();

        assert table.size() == 0;
        assert table.isEmpty();

        table.put("Zero", 10);
        table.put("One", 1);
        table.put("Two", 2);
        table.put("Three", 3);
        table.put("Four", 4);
        table.put("Five", 5);
        table.put("Six", 6);
        table.put("Seven", 7);
        table.put("Eight", 8);
        table.put("Nine", 9);
        table.put("Ten", 0);
        table.put("Ten", 10);
        table.delete("Zero");
        table.put("One", null);

        boolean[] occupied = new boolean[11];

        for (final String key : table.keys()) {
            assert !occupied[table.valueFor(key)];
            occupied[table.valueFor(key)] = true;
        }

        assert !occupied[0];
        assert !occupied[1];
        for (int i = 2; i != 11; i++)
            assert occupied[i];

        assert table.contains("Ten");
        assert !table.contains("Zero");
        assert table.size() == 9;
        assert !table.isEmpty();

        table.delete("One");
        table.delete("Ten");
        table.delete("Five");
        table.delete("Two");
        table.delete("Six");
        table.delete("Zero");
        table.delete("Nine");
        table.delete("Ten");
        table.delete("Seven");
        table.delete("Three");
        table.delete("Four");
        table.delete("Eight");

        assert table.size() == 0;
        assert table.isEmpty();
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