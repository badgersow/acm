package leetcode.contest.weekly251;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CTest {

    @Test
    public void test1() {
        assertThat(new C().maxCompatibilitySum(
                new int[][]{
                        {1, 1, 0},
                        {1, 0, 1},
                        {0, 0, 1}
                },
                new int[][]{
                        {1, 0, 0},
                        {0, 0, 1},
                        {1, 1, 0}
                }
        )).isEqualTo(8);
    }

    @Test
    public void test2() {
        assertThat(new C().maxCompatibilitySum(
                new int[][]{
                        {0, 0},
                        {0, 0},
                        {0, 0}
                },
                new int[][]{
                        {1, 1},
                        {1, 1},
                        {1, 1}
                }
        )).isEqualTo(0);
    }

}
