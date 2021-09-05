package leetcode.contest.weekly257;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem5864Test {

    @Test
    void failingTest() {
        Assertions.assertThat(
                new Problem5864().numberOfWeakCharacters(new int[][]{
                        {7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}
                })).isEqualTo(
                2
        );
    }

    @Test
    void trivial1() {
        Assertions.assertThat(
                new Problem5864().numberOfWeakCharacters(new int[][]{
                        {1, 2}, {1, 1}
                })).isEqualTo(
                0
        );
    }

}