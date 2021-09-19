package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ExpressionAddOperatorsTest {
    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {
            "123;6;1*2*3,1+2+3",
            "232;8;2*3+2,2+3*2",
            "105;5;1*0+5,10-5",
            "00;0;0*0,0+0,0-0",
            "3456237490;9191;"
    })
    void test(String num, int target, String expected) {
        Assertions.assertThat(
                new ExpressionAddOperators()
                        .addOperators(num, target)
        ).containsExactlyInAnyOrder(expected == null ? new String[0] : expected.split(","));
    }

}