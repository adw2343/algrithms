package com.laining.alogrithms.graph;

public class TwoColor {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColor = true;

    public TwoColor(Graph graph) {
        marked = new boolean[graph.v()];
        color = new boolean[graph.v()];
        for (int s = 0; s < graph.v(); s++) {
            if (!marked[s]) {
                dfs(graph, s);
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(graph, w);
            } else if (color[w] == color[v])
                isTwoColor = false;
        }
    }

    public boolean isTwoColor() {
        return isTwoColor;
    }

}
