package leetcode.contest.weekly252;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CTest {
    @Test
    public void sample1() {
        Assertions.assertThat(new C().minimumPerimeter(1))
                .isEqualTo(8);
    }

    @Test
    public void sample2() {
        Assertions.assertThat(new C().minimumPerimeter(13))
                .isEqualTo(16);
    }

    @Test
    public void sample3() {
        Assertions.assertThat(new C().minimumPerimeter(1000000000))
                .isEqualTo(5040);
    }

    @Test
    public void large() {
        Assertions.assertThat(new C().minimumPerimeter(1_000_000_000_000_000L))
                .isEqualTo(503968L);
    }

}
