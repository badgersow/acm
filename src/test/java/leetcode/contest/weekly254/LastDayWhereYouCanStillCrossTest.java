package leetcode.contest.weekly254;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class LastDayWhereYouCanStillCrossTest {
    @Test
    public void sample1() {
        Assertions.assertThat(new LastDayWhereYouCanStillCross()
                .latestDayToCross(
                        2,
                        2, new
                                int[][]{
                                {1, 1},
                                {2, 1},
                                {1, 2},
                                {2, 2}
                        })).isEqualTo(2);
    }

    @Test
    public void sample2() {
        Assertions.assertThat(new LastDayWhereYouCanStillCross()
                .latestDayToCross(
                        2,
                        2, new
                                int[][]{
                                {1, 1},
                                {1, 2},
                                {2, 1},
                                {2, 2}
                        })).isEqualTo(1);
    }

    @Test
    public void sample3() {
        Assertions.assertThat(new LastDayWhereYouCanStillCross()
                .latestDayToCross(
                        3,
                        3, new
                                int[][]{
                                {1, 2},
                                {2, 1},
                                {3, 3},
                                {2, 2},
                                {1, 1},
                                {1, 3},
                                {2, 3},
                                {3, 2},
                                {3, 1}
                        })).isEqualTo(3);
    }

}