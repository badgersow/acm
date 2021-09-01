package interview.google;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

class WaterCalculatorTest {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "3,2,8,5;1",
            "1,3,2,4,1,3,1,4,5,2,2,1,4,2,2;15",
            ";0",
            "1;0"
    })
    void test(String input, int expectedResult) {
        Assertions.assertThat(new WaterCalculator().waterVolume(
                (input != null ? Stream.of(input.split(",")).mapToInt(Integer::valueOf).toArray() : new int[]{})
        )).isEqualTo(expectedResult);
    }

}