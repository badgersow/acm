package leetcode.contest.weekly253;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DTest {

    @Test
    public void trivial1() {
        Assertions.assertThat(
                new D().longestObstacleCourseAtEachPosition(
                        new int[]{1}
                )
        ).containsExactly(1);
    }

    @Test
    public void trivial2() {
        Assertions.assertThat(
                new D().longestObstacleCourseAtEachPosition(
                        new int[]{1, 2}
                )
        ).containsExactly(1, 2);
    }

    @Test
    public void trivial3() {
        Assertions.assertThat(
                new D().longestObstacleCourseAtEachPosition(
                        new int[]{1, 1}
                )
        ).containsExactly(1, 2);
    }

    @Test
    public void trivial4() {
        Assertions.assertThat(
                new D().longestObstacleCourseAtEachPosition(
                        new int[]{1, 1, 1}
                )
        ).containsExactly(1, 2, 3);
    }

    @Test
    public void trivial5() {
        Assertions.assertThat(
                new D().longestObstacleCourseAtEachPosition(
                        new int[]{3, 1, 2}
                )
        ).containsExactly(1, 1, 2);
    }


    @Test
    public void sample1() {
        Assertions.assertThat(
                new D().longestObstacleCourseAtEachPosition(
                        new int[]{1, 2, 3, 2}
                )
        ).containsExactly(1, 2, 3, 3);
    }

    @Test
    public void sample2() {
        Assertions.assertThat(
                new D().longestObstacleCourseAtEachPosition(
                        new int[]{2, 2, 1}
                )
        ).containsExactly(1, 2, 1);
    }

    @Test
    public void sample3() {
        Assertions.assertThat(
                new D().longestObstacleCourseAtEachPosition(
                        new int[]{3, 1, 5, 6, 4, 2}
                )
        ).containsExactly(1, 1, 2, 3, 2, 2);
    }
}
