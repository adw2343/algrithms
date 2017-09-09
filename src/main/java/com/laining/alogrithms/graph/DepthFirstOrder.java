package com.laining.alogrithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {

    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;
    private boolean[] marked;

    public DepthFirstOrder(DiGraph g) {
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[g.v()];
        for (int i = 0; i < g.v(); i++) {
            if (!marked[i])
                dfs(g, i);
        }
    }

    private void dfs(DiGraph diGraph, int v) {
        pre.add(v);
        marked[v] = true;
        for (int w : diGraph.adj(v)) {
            if (!marked[w]) {
                dfs(diGraph, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return Collections.unmodifiableCollection(pre);
    }

    public Iterable<Integer> post() {
        return Collections.unmodifiableCollection(post);
    }

    public Iterable<Integer> reversePost() {
        if (reversePost == null)
            return null;
        List<Integer> list = new ArrayList<>(reversePost.size());
        while (!reversePost.isEmpty()) {
            list.add(reversePost.pop());
        }
        return list;
    }

}
