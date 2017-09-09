package com.laining.alogrithms.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 有向图
 * 
 * <em>
 * <ul>
 * <li>该实现不是线程安全的</li>
 * </ul>
 * </em>
 * 
 * @author laining
 *
 */
public class DiGraph {

    private int v; // 顶点数目
    private int e;// 边数目
    private List<Integer>[] adj;

    @SuppressWarnings("unchecked")
    public DiGraph(int v) {
        assert v > 0;
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

    }

    /**
     * 获取图的顶点数
     * 
     * @return
     */
    public int v() {
        return v;
    }

    /**
     * 获取图的边数目
     * 
     * @return
     */
    public int e() {
        return e;
    }

    /**
     * 增加一条从顶点{@code v}指向顶点{@code u}的有向边
     * 
     * @param v
     * @param u
     */
    public void addEdge(int v, int u) {
        adj[v].add(u);
        e++;
    }

    /**
     * 获取从顶点{@code v}指向的顶点
     * 
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        assert v < this.v;
        return Collections.unmodifiableCollection(adj[v]);
    }

    /**
     * 获取反向图
     * 
     * @return
     */
    public DiGraph reverse() {
        DiGraph diGraph = new DiGraph(this.v);
        for (int i = 0; i < this.v; i++) {
            for (int w : adj[i]) {
                diGraph.addEdge(w, i);
            }
        }
        return diGraph;
    }

}
