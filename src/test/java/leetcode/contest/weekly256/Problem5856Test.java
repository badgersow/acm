package leetcode.contest.weekly256;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

class Problem5856Test {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3;3;2",
            "3,1,3,1,1;8;2",
            "1,2,3,4,5;15;1"
    })
    void test(String input, int sessions, int result) {
        int[] durations = Stream.of(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        Assertions.assertThat(new Problem5856().minSessions(
                durations,
                sessions
        )).isEqualTo(result);
    }


}