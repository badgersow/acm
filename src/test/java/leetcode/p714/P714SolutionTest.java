package leetcode.p714;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class P714SolutionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1 3 2 8 4 9, 2, 8",
            "5 4 3 2 1, 10, 0",
            "0 10 0 11, 1, 19",
            "0, 0, 0"
    })
    public void checkSolution(String array, int fee, long expectedResult) {
        final int[] prices = Arrays.stream(array.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        assertThat(new Solution().maxProfit(prices, fee)).isEqualTo(expectedResult);
    }

}