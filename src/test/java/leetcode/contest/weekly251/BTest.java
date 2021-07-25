package leetcode.contest.weekly251;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BTest {

    @Test
    public void testEmptyString() {
        assertThat(new B().maximumNumber("0", new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}))
                .isEqualTo("0");
    }

    @Test
    public void testLeadingZeros() {
        assertThat(new B().maximumNumber("0001", new int[]{0, 1, 0, 0, 0, 0, 0, 0, 0, 0}))
                .isEqualTo("1");
    }

    @Test
    public void test1() {
        assertThat(new B().maximumNumber("132", new int[]{9, 8, 5, 0, 3, 6, 4, 2, 6, 8}))
                .isEqualTo("832");
    }

    @Test
    public void test2() {
        assertThat(new B().maximumNumber("021", new int[]{9, 4, 3, 5, 7, 2, 1, 9, 0, 6}))
                .isEqualTo("934");
    }

    @Test
    public void test3() {
        assertThat(new B().maximumNumber("5", new int[]{1, 4, 7, 5, 3, 2, 5, 6, 9, 4}))
                .isEqualTo("5");
    }
}