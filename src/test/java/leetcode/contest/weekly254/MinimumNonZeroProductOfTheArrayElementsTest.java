package leetcode.contest.weekly254;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumNonZeroProductOfTheArrayElementsTest {

    @Test
    public void test1() {
        Assertions.assertThat(new MinimumNonZeroProductOfTheArrayElements()
                        .minNonZeroProduct(1))
                .isEqualTo(1);
    }

    @Test
    public void test2() {
        Assertions.assertThat(new MinimumNonZeroProductOfTheArrayElements()
                        .minNonZeroProduct(2))
                .isEqualTo(6);
    }

    @Test
    public void test3() {
        Assertions.assertThat(new MinimumNonZeroProductOfTheArrayElements()
                        .minNonZeroProduct(3))
                .isEqualTo(1512);
    }

}