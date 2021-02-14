package structures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static structures.Trie.reverse;

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
        final Trie root = Trie.create(1, 2, 3, 4, 5);
        reverse(root);

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

    @Test
    public void testCuttingAndReversing() {
        final Trie root = Trie.create(1, 2, 3, 4, 5);
        reverse(root);
        final Trie part321 = Trie.split(root, 2).right;
        final Trie part32 = Trie.split(part321, 2).left;
        reverse(part32);

        final Trie part32123 = Trie.merge(part321, part32);
        assertArrayIs(part32123, 3, 2, 1, 2, 3);
    }

    @Test
    public void testReversalsToSolveTheProblem() {
        final Trie root = Trie.create(4, 2, 1, 3);
        final int positionOf1 = Trie.positionOf(root, 1);
        assertThat(positionOf1).isEqualTo(2);

        final Trie.TriePair split1 = Trie.split(root, 3);
        reverse(split1.left);
        final Trie root1243 = Trie.merge(split1.left, split1.right);
        final int positionOf2 = Trie.positionOf(root1243, 2);
        assertThat(positionOf2).isEqualTo(1);
        // On it's place. Cool.

        final int positionOf3 = Trie.positionOf(root1243, 3);
        assertThat(positionOf3).isEqualTo(3);
        final Trie.TriePair split2 = Trie.split(root1243, 2);
        reverse(split2.right);

        final Trie sortedArray = Trie.merge(split2.left, split2.right);
        assertArrayIs(sortedArray, 1, 2, 3, 4);
    }

    private void assertArrayIs(Trie root, Integer... expected) {
        for (int i = 0; i < expected.length; i++) {
            assertThat(root.get(i)).isEqualTo(expected[i]);
        }
    }

}