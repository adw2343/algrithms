package com.laining.alogrithms.graph;

/**
 * 计算图中的连通分量
 * 
 * @author laining
 *
 */
public class CC {

    private boolean[] marked;
    private int count; // 连通分量数目
    private int[] id; // 每个顶点的连通分量id

    public CC(Graph graph) {
        marked = new boolean[graph.v()];
        id = new int[graph.v()];
        for (int i = 0; i < graph.v(); i++) {
            if (!marked[i]) {
                dfs(graph, i);
                count++;
            }
        }
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;
        id[v] = count;
        for (Integer w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
    }

    /**
     * 判断两个顶点{@code v}和{@code w}是否相连
     * 
     * @param v
     * @param w
     * @return
     */
    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    /**
     * 连通分量数目
     * 
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 返回顶点{@code v}所在的连通分量id
     * 
     * @param v
     * @return
     */
    public int id(int v) {
        return id[v];
    }

}
