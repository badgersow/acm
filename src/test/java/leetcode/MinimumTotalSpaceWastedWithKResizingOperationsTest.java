package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumTotalSpaceWastedWithKResizingOperationsTest {

    @Test
    public void trivial1() {
        Assertions.assertThat(
                new MinimumTotalSpaceWastedWithKResizingOperations()
                        .minSpaceWastedKResizing(
                                new int[]{1, 2, 3},
                                0
                        )).isEqualTo(
                3
        );
    }

    @Test
    public void sample1() {
        Assertions.assertThat(
                new MinimumTotalSpaceWastedWithKResizingOperations()
                        .minSpaceWastedKResizing(
                                new int[]{10, 20},
                                0
                        )).isEqualTo(
                10
        );
    }

    @Test
    public void sample2() {
        Assertions.assertThat(
                new MinimumTotalSpaceWastedWithKResizingOperations()
                        .minSpaceWastedKResizing(
                                new int[]{10, 20, 30},
                                1
                        )).isEqualTo(
                10
        );
    }

    @Test
    public void sample3() {
        Assertions.assertThat(
                new MinimumTotalSpaceWastedWithKResizingOperations()
                        .minSpaceWastedKResizing(
                                new int[]{10, 20, 15, 30, 20},
                                2
                        )).isEqualTo(
                15
        );
    }

    @Test
    public void sample4() {
        Assertions.assertThat(
                new MinimumTotalSpaceWastedWithKResizingOperations()
                        .minSpaceWastedKResizing(
                                new int[]{38, 28, 3, 2, 6, 14, 15, 33, 39},
                                1
                        )).isEqualTo(
                165
        );
    }

}