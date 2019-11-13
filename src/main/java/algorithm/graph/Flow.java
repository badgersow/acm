package algorithm.graph;

import java.util.Map;

public interface Flow {

    int value();

    Map<Integer, Map<Integer, Integer>> flow();

}
