package structures;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CombinatoricsTest {

    @ParameterizedTest
    @CsvSource(delimiter = ' ', value = {
            "1,2 1,2;2,1",
            "1,2,3 1,2,3;1,3,2;2,1,3;2,3,1;3,1,2;3,2,1",
    })
    public void permutationsTest(String inputString, String expectedString) {
        List<Integer> input = Stream.of(inputString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<List<Integer>> expected = Arrays.stream(expectedString.split(";"))
                .map(s ->
                        Stream.of(s.split(","))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()))
                .collect(Collectors.toList());

        Assertions.assertThat(Combinatorics.permutations(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ' ', value = {
            "1,2 1 1;2",
            "1,2,3 2 1,2;1,3;2,3",
            "1,2,3 3 1,2,3"
    })
    public void combinationsTest(String inputString, int k, String expectedString) {
        List<Integer> input = Stream.of(inputString.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<List<Integer>> expected = Arrays.stream(expectedString.split(";"))
                .map(s ->
                        Stream.of(s.split(","))
                                .map(Integer::parseInt)
                                .collect(Collectors.toList()))
                .collect(Collectors.toList());

        Assertions.assertThat(Combinatorics.combinations(input, k)).isEqualTo(expected);
    }

}