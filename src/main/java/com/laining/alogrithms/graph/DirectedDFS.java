package com.laining.alogrithms.graph;

public class DirectedDFS {

    private boolean[] marked;

    public DirectedDFS(DiGraph diGraph, int s) {
        marked = new boolean[diGraph.v()];
        dfs(diGraph, s);
    }

    private void dfs(DiGraph diGraph, int v) {
        marked[v] = true;
        for (int w : diGraph.adj(v)) {
            if (!marked[w])
                dfs(diGraph, w);
        }
    }

    /**
     * 是否存在从构造函数构造时指定的顶点{@code s}到顶点{@code v}的路径
     * 
     * @param v
     * @return
     */
    public boolean marked(int v) {
        return marked[v];
    }

}
