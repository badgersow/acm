package structures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrieTest {

    @Test
    public void testGetAllElements() {
        final Trie root = Trie.create(1, 2, 3, 4, 5);
        assertArrayIs(root, 1, 2, 3, 4, 5);
    }

    @Test
    public void testMergeTwoArrays() {
        final Trie root = Trie.merge(Trie.create(1, 2, 3, 4), Trie.create(5, 6));
        assertArrayIs(root, 1, 2, 3, 4, 5, 6);
    }

    @Test
    public void testPositionOf() {
        final Trie root = Trie.create(1, 2, 5, 3, 4);

        assertThat(Trie.positionOf(root, 1)).isEqualTo(0);
        assertThat(Trie.positionOf(root, 2)).isEqualTo(1);
        assertThat(Trie.positionOf(root, 3)).isEqualTo(3);
    }

    @Test
    public void testReversing() {
        final Trie root = Trie.create(1, 2, 3, 4,5);
        root.reverse();

        assertArrayIs(root, 5, 4, 3, 2, 1);
    }

    @Test
    public void testTrivialSplit() {
        final Trie root = Trie.create(1, 2, 3);
        final Trie.TriePair split = Trie.split(root, 1);
        assertArrayIs(split.left, 1);
        assertArrayIs(split.right, 2, 3);
    }

    @Test
    public void testSplit() {
        final Trie root = Trie.create(1, 2, 3, 4, 5);
        final Trie.TriePair split = Trie.split(root, 2);
        assertArrayIs(split.left, 1, 2);
        assertArrayIs(split.right, 3, 4, 5);
    }

    private void assertArrayIs(Trie root, Integer... expected) {
        for (int i = 0; i < expected.length; i++) {
            assertThat(root.get(i)).isEqualTo(expected[i]);
        }
    }

}