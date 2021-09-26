package leetcode.contest.weekly260;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem5883Test {

    @Test
    void sample1() {
        Assertions.assertThat(new Problem5883().placeWordInCrossword(
                new char[][]{
                        {'#', ' ', '#'},
                        {' ', ' ', '#'},
                        {'#', 'c', ' '}
                },
                "abc"
        )).isTrue();
    }

    @Test
    void sample2() {
        Assertions.assertThat(new Problem5883().placeWordInCrossword(
                new char[][]{
                        {' ', '#', 'a'},
                        {' ', '#', 'c'},
                        {' ', '#', 'a'}
                },
                "ac"
        )).isFalse();
    }

    @Test
    void sample3() {
        Assertions.assertThat(new Problem5883().placeWordInCrossword(
                new char[][]{
                        {'#', ' ', '#'},
                        {' ', ' ', '#'},
                        {'#', ' ', 'c'}
                },
                "ca"
        )).isTrue();
    }

    @Test
    void sample4() {
        Assertions.assertThat(new Problem5883().placeWordInCrossword(
                new char[][]{
                        {'#', ' ', '#'},
                        {'#', ' ', '#'},
                        {'#', ' ', 'c'}
                },
                "ca"
        )).isTrue();
    }



}