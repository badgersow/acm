package interview.google;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class WordSquaresTest {
    @Test
    void sample() {
        Assertions.assertThat(
                new WordSquares().allWordSquares(
                        Arrays.asList("AREA", "BALL", "DEAR", "LADY", "LEAD", "YARD")
                )
        ).containsExactlyInAnyOrder(
                Arrays.asList("BALL", "AREA", "LEAD", "LADY"),
                Arrays.asList("LADY", "AREA", "DEAR", "YARD")
        );
    }

    @Test
    void wordFitsTestPositive1() {
        Assertions.assertThat(
                new WordSquares().wordFits(
                        Arrays.asList("BALL", "AREA", "LEAD", "LADY"),
                        Arrays.asList(0, 1, 2),
                        3)
        ).isTrue();
    }

    @Test
    void wordFitsTestPositive2() {
        Assertions.assertThat(
                new WordSquares().wordFits(
                        Arrays.asList("BALL", "AREA", "LEAD", "LADY"),
                        Arrays.asList(0, 1),
                        2)
        ).isTrue();
    }

}