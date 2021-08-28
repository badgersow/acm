package leetcode.contest.weekly255;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class FindArrayGivenSubsetSumsTest {

    @Test
    public void trivial1() {
        Assertions.assertThat(new FindArrayGivenSubsetSums()
                .recoverArray(
                        2,
                        new int[]{
                                0, 1, 2, 3
                        })).isEqualTo(
                new int[]{
                        1, 2
                }
        );
    }

    @Test
    public void trivial2() {
        Assertions.assertThat(new FindArrayGivenSubsetSums()
                .recoverArray(
                        1,
                        new int[]{
                                0,0
                        })).isEqualTo(
                new int[]{
                        0
                }
        );
    }


    @Test
    public void sample1() {
        Assertions.assertThat(new FindArrayGivenSubsetSums()
                .recoverArray(
                        3,
                        new int[]{
                                -3, -2, -1, 0, 0, 1, 2, 3
                        })).isEqualTo(
                new int[]{
                        -2, -1, 3
                }
        );
    }

    @Test
    public void sample2() {
        Assertions.assertThat(new FindArrayGivenSubsetSums()
                .recoverArray(
                        2,
                        new int[]{
                                0, 0, 0, 0
                        })).isEqualTo(
                new int[]{
                        0, 0
                }
        );
    }

    @Test
    public void sample3() {
        Assertions.assertThat(new FindArrayGivenSubsetSums()
                .recoverArray(
                        4,
                        new int[]{
                                0, 0, 5, 5, 4, -1, 4, 9, 9, -1, 4, 3, 4, 8, 3, 8
                        })).isEqualTo(
                new int[]{
                        -1, 0, 4, 5
                }
        );
    }
}