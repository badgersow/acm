package interview.google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MineMatrixTest {
    @Test
    void printField() {
        final var matrix = new MineMatrix(10, 1, 1).matrix;
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}