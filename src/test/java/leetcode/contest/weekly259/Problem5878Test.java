package leetcode.contest.weekly259;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem5878Test {

    @ParameterizedTest
    @CsvSource({
            "arzwpdlarzwpl,2,arzwpl",
            "baba,2,ba",
            "bb,2,b",
            "letsleetcode,2,let"
    })
    void test(String input, int k, String expected) {
        Assertions.assertThat(new Problem5878().longestSubsequenceRepeatedK(input, k))
                .isEqualTo(expected);
    }

}