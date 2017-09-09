package com.laining.alogrithms.graph;

public class Cycle {

    private boolean hasCycle;
    private boolean[] marked;

    public Cycle(Graph graph) {
        marked = new boolean[graph.v()];
        for (int i = 0; i < graph.v(); i++) {
            if (!marked[i])
                dfs(graph, i, i);
        }
    }

    private void dfs(Graph graph, int v, int u) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w, v);
            } else if (w != u)
                hasCycle = true;
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

}
