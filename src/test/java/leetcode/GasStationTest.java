package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static util.TestUtil.toArray;

class GasStationTest {

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "1,2,3,4,5;3,4,5,1,2;3",
            "2,3,4;3,4,3;-1"
    })
    void test(String gas, String cost, int expected) {
        Assertions.assertThat(new GasStation()
                        .canCompleteCircuit(toArray(gas), toArray(cost)))
                .isEqualTo(expected);
    }

}