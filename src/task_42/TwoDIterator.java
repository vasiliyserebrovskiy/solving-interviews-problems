package task_42;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Vasilii Serebrovskii
 * @version 1.0 (27.02.2026)
 */
public class TwoDIterator implements Iterator<Integer> {
    private final int[][] data;
    private int row;
    private int col;

    public TwoDIterator(int[][] data) {
        this.data = data;
        this.row = 0;
        this.col = 0;
    }

    @Override
    public boolean hasNext() {
        // We are advancing the position until:
        // - did not leave the array
        // - the current subarray is empty
        // - or the column went beyond its limits
        while (row < data.length &&
                (data[row] == null || col >= data[row].length)) {
            row++;
            col = 0;
        }

        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }

        int value = data[row][col];
        col++;
        return value;
    }

    // Usage example
    public static void main(String[] args) {
        int[][] input = {
                {1, 2},
                {3},
                {},
                {4, 5, 6}
        };

        TwoDIterator iterator = new TwoDIterator(input);

        System.out.println("Iterating:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
