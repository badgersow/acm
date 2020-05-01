package itya;

import itya.NextNode.Node;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextNodeTest {


    /**
    *          1
    *       2     3
    *     4     6   7
    *   8             9
     */
    @Test
    public void sample() {
        final Node node8 = new Node();
        final Node node9 = new Node();

        final Node node4 = new Node(node8, null);
        final Node node6 = new Node();
        final Node node7 = new Node(null, node9);

        final Node node2 = new Node(node4, null);
        final Node node3 = new Node(node6, node7);

        final Node node1 = new Node(node2, node3);

        NextNode.connect(node1);

        assertThat(node1.next).isNull();
        assertThat(node2.next).isEqualTo(node3);
        assertThat(node3.next).isNull();
        assertThat(node4.next).isEqualTo(node6);
        assertThat(node6.next).isEqualTo(node7);
        assertThat(node7.next).isNull();
        assertThat(node8.next).isEqualTo(node9);
        assertThat(node9.next).isNull();

    }
}