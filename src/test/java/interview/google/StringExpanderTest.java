package interview.google;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringExpanderTest {
    @ParameterizedTest
    @CsvSource({
            "a,a",
            "abc,abc",
            "2[a],aa",
            "a2[b1[c]0[d]],abcbc",
            "a1[1[1[1[1[1[a]]]]]],aa"
    })
    public void emptyString(String input, String output) {
        // AssertJ
        Assertions.assertThat(new StringExpander().expandString(
                input
        )).isEqualTo(
                output
        );
    }

}