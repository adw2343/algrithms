package com.laining.alogrithms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 有向图环检测
 * 
 * @author laining
 *
 */
public class DirectedCycle {

    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public DirectedCycle(DiGraph diGraph) {
        marked = new boolean[diGraph.v()];
        onStack = new boolean[diGraph.v()];
        edgeTo = new int[diGraph.v()];
        for (int i = 0; i < diGraph.v(); i++)
            if (!marked[i])
                dfs(i, diGraph);
    }

    private void dfs(int v, DiGraph diGraph) {
        onStack[v] = true;
        marked[v] = true;
        for (int w : diGraph.adj(v)) {
            if (this.hasCycle())
                return;
            else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w, diGraph);
            } else if (onStack[w]) {
                cycle = new Stack<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }

        }
        onStack[v] = false;
    }

    /**
     * 判断是否存在环
     * 
     * @return
     */
    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        if (!hasCycle())
            return null;
        List<Integer> cycleList = new ArrayList<>(this.cycle.size());
        while (!this.cycle.isEmpty()) {
            cycleList.add(cycle.pop());
        }
        return cycleList;
    }

}
