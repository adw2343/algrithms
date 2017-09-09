package com.laining.alogrithms.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class AbstractPath implements Path {

    protected final int s;// 顶点
    protected boolean[] marked;
    protected Integer[] edgeTo; // 保存父节点的索引值

    public AbstractPath(int s, Graph graph) {
        this.s = s;
        marked = new boolean[graph.v()];
        edgeTo = new Integer[graph.v()];
    }

    public boolean hasPathTo(Integer v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(Integer v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> stack = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x])
            stack.push(x);
        stack.push(s);
        List<Integer> list = new ArrayList<Integer>();
        while (!stack.isEmpty())
            list.add(stack.pop());
        return list;
    }

}
