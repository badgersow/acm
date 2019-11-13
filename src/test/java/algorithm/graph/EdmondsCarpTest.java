package algorithm.graph;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class EdmondsCarpTest {

    /**
     * s -----42----> t
     */
    @Test
    public void testTrivialGraph() {
        final FlowNetwork network = new FlowNetwork() {
            @Override
            public Set<Integer> vertices() {
                return ImmutableSet.of(1, 2);
            }

            @Override
            public Map<Integer, Map<Integer, Integer>> capacity() {
                return ImmutableMap.of(
                        1, ImmutableMap.of(2, 42)
                );
            }

            @Override
            public int s() {
                return 1;
            }

            @Override
            public int t() {
                return 2;
            }
        };

        final Flow flow = new EdmondsCarp().solve(network);

        assertThat(flow.value()).isEqualTo(42);
        assertThat(flow.flow().get(1).get(2)).isEqualTo(42);
        assertThat(flow.flow().get(2).get(1)).isEqualTo(0);
    }

}