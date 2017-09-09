package com.laining.alogrithms.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 使用邻接表实现的无向图
 * 
 * <em>
 * <ul>
 * <li>该实现不是线程安全的</li>
 * <li>每条边在邻接表中都会被记录两次</li>
 * </ul>
 * </em>
 * 
 * @author laining
 *
 */
public class Graph {
    Queue<Integer> queue = new LinkedList<Integer>();
    private int v; // 定点数目
    private int e; // 边数目
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.v = v;
        this.e = 0;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public int v() {
        return v;
    }

    public int e() {
        return e;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        e++;
    }

    public Iterable<Integer> adj(int v) {
        assert v < this.v;
        return adj[v];
    }

}
