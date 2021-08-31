package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MaximumProductOfTheLengthOfTwoPalindromicSubstringsTest {

    @ParameterizedTest
    @CsvSource({
            "aa,1",
            "ababbb,9",
            "zaaaxbbby,9"
    })
    void test(String input, int result) {
        Assertions.assertThat(new MaximumProductOfTheLengthOfTwoPalindromicSubstrings()
                .maxProduct(input)).isEqualTo(result);
    }


}