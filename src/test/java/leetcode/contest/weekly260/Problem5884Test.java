package leetcode.contest.weekly260;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem5884Test {
    @Test
    void sample1() {
        Assertions.assertThat(new Problem5884().scoreOfStudents(
                "7+3*1*2", new int[]{20, 13, 42}
        )).isEqualTo(7);
    }

    @Test
    void sample2() {
        Assertions.assertThat(new Problem5884().scoreOfStudents(
                "3+5*2", new int[]{13,0,10,13,13,16,16}
        )).isEqualTo(19);
    }

    @Test
    void sample3() {
        Assertions.assertThat(new Problem5884().scoreOfStudents(
                "6+0*1", new int[]{12,9,6,4,8,6}
        )).isEqualTo(10);
    }
}