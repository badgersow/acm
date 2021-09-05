package leetcode.contest.weekly257;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

class Problem5866Test {
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "7,21,3;true",
            "5,2,6,2;false",
            "10,5,9,3,15;true",
            "8,9,4,2,3;true"
    })
    void test(String nums, boolean result) {
        Assertions.assertThat(
                new Problem5866().gcdSort(
                        Stream.of(nums.split(",")).mapToInt(Integer::parseInt).toArray()
                )).isEqualTo(result);
    }
}