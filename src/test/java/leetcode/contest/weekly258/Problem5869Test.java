package leetcode.contest.weekly258;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem5869Test {
    @ParameterizedTest
    @CsvSource({
            "leetcodecom,9",
            "bb,1",
            "accbcaxxcxx,25",
            "tmppdjtm,12",
            "1234567890ab,1"})
    void test(String input, int expected) {
        Assertions.assertThat(new Problem5869().maxProduct(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "a,1",
            "aa,2",
            "aaa,3",
            "aba,3",
            "leetcode,2",
            "aaabbbb,4"
    })
    void maxPalinLen(String input, int expected) {
        Assertions.assertThat(new Problem5869().maxPalindrom(input.toCharArray(), input.length()))
                .isEqualTo(expected);
    }
}