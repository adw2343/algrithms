package com.laining.alogrithms.graph;

public class Topological {

    private Iterable<Integer> order;

    public Topological(DiGraph diGraph) {
        DirectedCycle directedCycle = new DirectedCycle(diGraph);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(diGraph);
            order = depthFirstOrder.reversePost();
        }
    }

    public boolean isDAG() {
        return this.order != null;
    }

    public Iterable<Integer> getOrder() {
        return order;
    }

}
