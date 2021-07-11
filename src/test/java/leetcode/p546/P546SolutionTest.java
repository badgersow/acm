package leetcode.p546;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class P546SolutionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1, 1",
            "1 1 1, 9",
            "1 2 1, 5",
            "1 3 2 2 2 3 4 3 1, 23",
            "8 1 2 10 8 5 1 10 8 4, 16",
            "1 2 2 2 1 2 2 2 1, 41",
            "1 2 2 1 1 1 2 1 1 2 1 2 1 1 2 2 1 1 2 2 1 1 1 2 2 2 2 1 2 1 1 2 2 1 2 1 2 2 2 2 2 1 2 1 2 2 1 1 1 2 2 1 2 1 2 2 1 2 1 1 1 2 2 2 2 2 1 2 2 2 2 2 1 1 1 1 1 2 2 2 2 2 1 1 1 1 2 2 1 1 1 1 1 1 1 2 1 2 2 1, 2758"
    })
    public void checkSolution(String array, long expectedResult) {
        final int[] boxes = Arrays.stream(array.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        assertThat(new Solution().removeBoxes(boxes)).isEqualTo(expectedResult);
    }

}