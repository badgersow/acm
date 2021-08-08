package leetcode.contest.weekly253;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTest {

    @Test
    public void sample1() {
        Assertions.assertThat(
                new C().minSwaps("][][")
        ).isEqualTo(1);
    }

    @Test
    public void sample2() {
        Assertions.assertThat(
                new C().minSwaps("]]][[[")
        ).isEqualTo(2);
    }

    @Test
    public void sample3() {
        Assertions.assertThat(
                new C().minSwaps("[]")
        ).isEqualTo(0);
    }

}
