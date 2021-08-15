package leetcode.contest.weekly254;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ArrayWithElementsNotEqualToAverageOfNeighborsTest {

    @Test
    public void length3() {
        Assertions.assertThat(
                new ArrayWithElementsNotEqualToAverageOfNeighbors()
                        .rearrangeArray(new int[]{2, 1, 3})
        ).isEqualTo(new int[]{1, 3, 2});
    }

    @Test
    public void length4() {
        Assertions.assertThat(
                new ArrayWithElementsNotEqualToAverageOfNeighbors()
                        .rearrangeArray(new int[]{1, 2, 3, 4})
        ).isEqualTo(new int[]{1, 4, 2, 3});
    }

    @Test
    public void length5() {
        Assertions.assertThat(
                new ArrayWithElementsNotEqualToAverageOfNeighbors()
                        .rearrangeArray(new int[]{1, 2, 3, 4, 5})
        ).isEqualTo(new int[]{1, 5, 2, 4, 3});
    }


}