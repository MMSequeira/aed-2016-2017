package pt.europeia.aed.exams.pipaf20170626t1000;

import static java.lang.System.err;
import static java.lang.System.in;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.Set;

/* For simplicity, words are considered as sequences on non-blank characters.
 * 
 * Try with arguments:
 * src/pt/europeia/aed/exams/pipaf20170626t1000/Merge.java src/pt/europeia/aed/exams/pipaf20170626t1000/BottomUpMerge.java
 * 
 * Search for 'int':
 * 'int':
 *     File 'src/pt/europeia/aed/exams/pipaf20170626t1000/BottomUpMerge.java': [10, 11, 18, 23, 24]
 *     File 'src/pt/europeia/aed/exams/pipaf20170626t1000/Merge.java': [11, 15, 24, 28, 29]
 *     
 * Search for 'middle':
 * 'middle':
 *     File 'src/pt/europeia/aed/exams/pipaf20170626t1000/BottomUpMerge.java': [10, 24]
 *     File 'src/pt/europeia/aed/exams/pipaf20170626t1000/Merge.java': [15, 18, 29]
 *     
 * Search for 'BottomUpMerge':
 * 'BottomUpMerge':
 *     File 'src/pt/europeia/aed/exams/pipaf20170626t1000/BottomUpMerge.java': [3]
 */
public class Indexer {

    public static BinarySearchOrderedTable<String, BinarySearchOrderedTable<String, Set<Integer>>> index(
            final String[] filenames) throws FileNotFoundException {
        BinarySearchOrderedTable<String, BinarySearchOrderedTable<String, Set<Integer>>> index = new BinarySearchOrderedTable<>();

        for (String filename : filenames) {
            final Scanner fileScanner = new Scanner(new File(filename));

            int lineNumber = 1;

            while (fileScanner.hasNextLine()) {
                final String line = fileScanner.nextLine();

                final Scanner lineScanner = new Scanner(line);

                while (lineScanner.hasNext()) {
                    final String word = lineScanner.next();

                    if (!index.contains(word))
                        index.put(word, new BinarySearchOrderedTable<>());

                    if (!index.valueFor(word).contains(filename))
                        index.valueFor(word).put(filename, new TreeSet<>());

                    index.valueFor(word).valueFor(filename).add(lineNumber);
                }

                lineScanner.close();

                lineNumber++;
            }

            fileScanner.close();
        }

        return index;
    }

    public static void main(final String[] arguments) {
        try {
            final BinarySearchOrderedTable<String, BinarySearchOrderedTable<String, Set<Integer>>> index = index(
                    arguments);

            final Scanner input = new Scanner(in);

            while (input.hasNext()) {
                final String word = input.next();

                if (!index.contains(word))
                    out.println("'" + word + "' does not exist.");
                else {
                    out.println("'" + word + "':");
                    for (String filename : index.valueFor(word).keys())
                        out.println("\tFile '" + filename + "': "
                                + index.valueFor(word).valueFor(filename));
                }
            }

            input.close();
        } catch (FileNotFoundException exception) {
            err.println("Problem opening file: " + exception);
        }
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