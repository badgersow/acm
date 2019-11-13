package algorithm.graph;

import java.util.Map;
import java.util.Set;

public interface FlowNetwork {

    Set<Integer> vertices();

    Map<Integer, Map<Integer, Integer>> capacity();

    int s();

    int t();

}
