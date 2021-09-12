package leetcode.contest.weekly258;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static util.TestUtil.toArray;

class Problem2003Test {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "-1,0;1,2;3,1",
            "-1,0,0,2;1,2,3,4;5,1,1,1",
            "-1,0,1,0,3,3;5,4,6,2,1,3;7,1,1,4,2,1",
            "-1,2,3,0,2,4,1;2,3,4,5,6,7,8;1,1,1,1,1,1,1"
    })
    void test(String parents, String nums, String expected) {
        Assertions.assertThat(
                new Problem2003().smallestMissingValueSubtree(
                        toArray(parents), toArray(nums)
                )).isEqualTo(toArray(expected));
    }
}