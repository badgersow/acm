package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayOfDoubledPairsTest {
    @Test
    public void failingTest() {
        Assertions.assertThat(
                new ArrayOfDoubledPairs()
                        .canReorderDoubled(new int[]{1, 2, 4, 4, 8, 16})
        ).isFalse();
    }
}