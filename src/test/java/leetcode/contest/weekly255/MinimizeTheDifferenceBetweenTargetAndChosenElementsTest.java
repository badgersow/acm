package leetcode.contest.weekly255;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class MinimizeTheDifferenceBetweenTargetAndChosenElementsTest {

    @Test
    public void sample1() {
        Assertions.assertThat(new MinimizeTheDifferenceBetweenTargetAndChosenElements()
                .minimizeTheDifference(new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        13
                )).isEqualTo(0);
    }

    @Test
    public void sample2() {
        Assertions.assertThat(new MinimizeTheDifferenceBetweenTargetAndChosenElements()
                .minimizeTheDifference(new int[][]{
                                {1},
                                {2},
                                {3}
                        },
                        100
                )).isEqualTo(94);
    }

    @Test
    public void sample3() {
        Assertions.assertThat(new MinimizeTheDifferenceBetweenTargetAndChosenElements()
                .minimizeTheDifference(new int[][]{
                                {1, 2, 9, 8, 7},
                        },
                        6
                )).isEqualTo(1);
    }

}