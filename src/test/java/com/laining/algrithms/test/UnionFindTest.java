package com.laining.algrithms.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.laining.alogrithms.graph.WeightedQuickUnionFind;

public class UnionFindTest {

    private WeightedQuickUnionFind wquf;

    @Before
    public void Before() {
        wquf = new WeightedQuickUnionFind(6);
        wquf.union(0, 1);
        wquf.union(0, 5);
        wquf.union(0, 2);
        wquf.union(2, 3);
        wquf.union(3, 5);
        wquf.union(3, 4);
    }

    @Test
    public void test() {
        Assert.assertTrue(wquf.connected(0, 4));
        Assert.assertEquals(1, wquf.count());
    }

}
