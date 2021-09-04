package interview.google;

import com.google.common.collect.ImmutableSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class LongestSubsequenceFinderTest {

    @Test
    void sample1() {
        Assertions.assertThat(new LongestSubsequenceFinder().findLongestSubseq(
                "abc",
                ImmutableSet.of(
                        "a",
                        "bc",
                        "dddd"
                )
        )).isEqualTo(Optional.of("bc"));
    }

    @Test
    void sample2() {
        Assertions.assertThat(new LongestSubsequenceFinder().findLongestSubseq(
                "abppplee",
                ImmutableSet.of(
                        "able",
                        "ale",
                        "apple",
                        "bale",
                        "kangaroo"
                )
        )).isEqualTo(Optional.of("apple"));
    }

    @Test
    void notFound() {
        Assertions.assertThat(new LongestSubsequenceFinder().findLongestSubseq(
                "blahblah",
                ImmutableSet.of(
                        "able",
                        "ale",
                        "apple",
                        "bale",
                        "kangaroo"
                )
        )).isEqualTo(Optional.empty());
    }

}