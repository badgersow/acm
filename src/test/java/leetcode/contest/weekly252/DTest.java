package leetcode.contest.weekly252;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DTest {

    @Test
    public void sample1() {
        Assertions.assertThat(
                new D().countSpecialSubsequences(
                        new int[]{0, 1, 2, 2}
                )).isEqualTo(3);
    }

    @Test
    public void sample2() {
        Assertions.assertThat(
                new D().countSpecialSubsequences(
                        new int[]{2, 2, 0, 0}
                )).isEqualTo(0);
    }

    @Test
    public void sample3() {
        Assertions.assertThat(
                new D().countSpecialSubsequences(
                        new int[]{0, 1, 2, 0, 1, 2}
                )).isEqualTo(7);
    }

}
