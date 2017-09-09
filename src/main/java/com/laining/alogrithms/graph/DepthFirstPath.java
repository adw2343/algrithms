package com.laining.alogrithms.graph;

/**
 * 基于深度优先搜索的路径查找
 * 
 * @author laining
 *
 */
public class DepthFirstPath extends AbstractPath {

    public DepthFirstPath(int s, Graph graph) {
        super(s, graph);
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (Integer w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v; // 将路径的父节点指向上层节点
                dfs(graph, w);
            }
        }
    }

}
