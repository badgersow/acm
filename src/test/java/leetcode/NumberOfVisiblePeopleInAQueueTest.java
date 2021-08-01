package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberOfVisiblePeopleInAQueueTest {

    @Test
    public void test1() {
        assertThat(new NumberOfVisiblePeopleInAQueue().canSeePersonsCount(
                new int[]{10, 6, 8, 5, 11, 9}
        )).isEqualTo(
                new int[]{3, 1, 2, 1, 1, 0}
        );
    }

    @Test
    public void test2() {
        assertThat(new NumberOfVisiblePeopleInAQueue().canSeePersonsCount(
                new int[]{5, 1, 2, 3, 10}
        )).isEqualTo(
                new int[]{4, 1, 1, 1, 0}
        );
    }

}