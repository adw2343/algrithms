package com.laining.alogrithms.graph;

public class WeightedQuickUnionFind {

    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionFind(int count) {
        this.count = count;
        this.id = new int[count];
        this.sz = new int[count];
        for (int i = 0; i < count; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;
        if (sz[i] > sz[j]) {
            id[j] = id[i];
            sz[i] += sz[j];
        } else {
            id[i] = id[j];
            sz[j] += sz[i];
        }
        count--;
    }

    public int count() {
        return count;
    }

}
