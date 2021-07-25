package leetcode.contest.weekly251;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ATest {

    @Test
    public void test0() {
        assertThat(new A().getLucky("a", 0)).isEqualTo(1);
    }

    @Test
    public void test1() {
        assertThat(new A().getLucky("iiii", 1)).isEqualTo(36);
    }

    @Test
    public void test2() {
        assertThat(new A().getLucky("leetcode", 2)).isEqualTo(6);
    }

    @Test
    public void test3() {
        assertThat(new A().getLucky("zbax", 2)).isEqualTo(8);
    }
}