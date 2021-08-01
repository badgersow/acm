package leetcode.contest.weekly252;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BTest {

    @Test
    public void trivial() {
        Assertions.assertThat(new B().numberOfWeeks(
                new int[]{10}
        )).isEqualTo(1);
    }

    @Test
    public void sample1() {
        Assertions.assertThat(new B().numberOfWeeks(
                new int[]{1, 2, 3}
        )).isEqualTo(6);
    }

    @Test
    public void sample2() {
        Assertions.assertThat(new B().numberOfWeeks(
                new int[]{5, 2, 1}
        )).isEqualTo(7);
    }

    @Test
    public void largeNumber() {
        Assertions.assertThat(new B().numberOfWeeks(
                new int[]{10, 1}
        )).isEqualTo(3);
    }
}
