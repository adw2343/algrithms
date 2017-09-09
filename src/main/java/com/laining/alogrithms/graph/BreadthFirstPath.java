package com.laining.alogrithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstPath extends AbstractPath {

    public BreadthFirstPath(int s, Graph graph) {
        super(s, graph);
        bfs(graph, s);
    }

    private void bfs(Graph graph, int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        marked[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            Integer u = queue.remove();
            for (Integer w : graph.adj(u)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = u;
                    queue.add(w);
                }
            }
        }
    }

}
