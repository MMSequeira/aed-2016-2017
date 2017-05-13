package pt.europeia.aed.piazza.experiments;

public interface Sorter<Item extends Comparable<? super Item>> {
    void sort(final Item[] values);
}
