package pt.europeia.aed.piazza.experiments;

public class ExperimenterSimplified {

    public static void main(final String[] arguments) {
        final int size = 1 << 4;
        final SortExperiment[] sortExperiments = {
            new SortExperiment(Quicksort::sort, size, "Quicksort"),
            new SortExperiment(MergeSort::sort, size, "Merge sort"),
            new SortExperiment(InsertionSort::sort, size, "Insertion sort") };

        for (SortExperiment sortExperiment : sortExperiments) {
            sortExperiment.run();
        }
    }

}

/*
 * Copyright 2016, Manuel Menezes de Sequeira.
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