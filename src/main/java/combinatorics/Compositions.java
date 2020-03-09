package combinatorics;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Iterates over all compositions of set with given length
 */
public class Compositions implements Iterator<int[]> {

    private final int[] elements;

    private final int n;

    private int[] indices;

    private int[] result;

    public Compositions(int[] elements, int n) {
        this.elements = elements;
        this.n = n;

        indices = new int[n];
        result = Array.newInstance(T, );

        Arrays.fill(indices, 0);
        Arrays.fill(result, elements.get(0));
    }

    @Override
    public boolean hasNext() {
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] < n - 1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[] next() {
        return null;
    }
}
