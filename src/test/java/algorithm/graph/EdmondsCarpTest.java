package algorithm.graph;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EdmondsCarpTest {

    /**
     * s -----42----> t
     */
    @Test
    public void testTrivialGraph() {
        final FlowNetwork network = new FlowNetwork() {
            @Override
            public int s() {
                return 1;
            }

            @Override
            public int t() {
                return 2;
            }

            @Override
            public int capacity(int u, int v) {
                if (u == 1 && v == 2) {
                    return 42;
                }

                return 0;
            }
        };

        final Flow flow = new EdmondsCarp().solve(network);

        assertThat(flow.value()).isEqualTo(42);
        assertThat(flow.flow(1, 2)).isEqualTo(42);
        assertThat(flow.flow(2, 1)).isEqualTo(0);
    }

}