package leetcode.contest.weekly253;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BTest {
    @Test
    public void sample1() {
        Assertions.assertThat(new B().minStoneSum(
                new int[]{5, 4, 9}, 2
        )).isEqualTo(12);
    }

    @Test
    public void sample2() {
        Assertions.assertThat(new B().minStoneSum(
                new int[]{4, 3, 6, 7}, 3
        )).isEqualTo(12);
    }
}
