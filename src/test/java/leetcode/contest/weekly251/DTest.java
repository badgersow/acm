package leetcode.contest.weekly251;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DTest {

    @Test
    public void test1() {
        assertThat(
                new D().deleteDuplicateFolder(
                        Arrays.asList(
                                Arrays.asList("a"),
                                Arrays.asList("c"),
                                Arrays.asList("d"),
                                Arrays.asList("a", "b"),
                                Arrays.asList("c", "b"),
                                Arrays.asList("d", "a")
                        )
                )
        ).containsExactlyInAnyOrder(
                Arrays.asList("d"),
                Arrays.asList("d", "a"));
    }

    @Test
    public void test2() {
        assertThat(
                new D().deleteDuplicateFolder(
                        Arrays.asList(
                                Arrays.asList("a"),
                                Arrays.asList("c"),
                                Arrays.asList("a", "b"),
                                Arrays.asList("c", "b"),
                                Arrays.asList("a", "b", "x"),
                                Arrays.asList("a", "b", "x", "y"),
                                Arrays.asList("w"),
                                Arrays.asList("w", "y"))))
                .containsExactlyInAnyOrder(
                        Arrays.asList("c"),
                        Arrays.asList("c", "b"),
                        Arrays.asList("a"),
                        Arrays.asList("a", "b"));
    }


}
