package leetcode.contest.weekly255;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FindUniqueBinaryStringTest {

    @Test
    public void sample1() {
        Assertions.assertThat(new FindUniqueBinaryString().findDifferentBinaryString(
                new String[]{"01", "10"}
        )).isEqualTo("00");
    }

    @Test
    public void sample2() {
        Assertions.assertThat(new FindUniqueBinaryString().findDifferentBinaryString(
                new String[]{"00", "11"}
        )).isEqualTo("01");
    }

    @Test
    public void sample3() {
        Assertions.assertThat(new FindUniqueBinaryString().findDifferentBinaryString(
                new String[]{"111", "011", "001"}
        )).isEqualTo("000");
    }

}