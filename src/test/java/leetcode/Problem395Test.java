package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Problem395Test {

    @ParameterizedTest
    @CsvSource({
            "abacbb,2,2",
            "a,1,1",
            "aaabb,3,3",
            "ababbc,2,5"
    })
    public void test(String input, int k, int expectedResult) {
        Assertions.assertThat(new Problem395()
                .longestSubstring(input, k)).isEqualTo(
                expectedResult
        );
    }

}