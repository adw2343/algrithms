package com.laining.algrithms.test;

import java.util.StringJoiner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.laining.alogrithms.graph.DepthFirstOrder;
import com.laining.alogrithms.graph.DiGraph;
import com.laining.alogrithms.graph.DirectedCycle;

public class DiGraphTest {

    private DiGraph diGraph;

    private DiGraph diGraph1;

    private static final String CYCLE_PATH = "3->5->4->3";
    private static final String PRE_OREDR = "0->5->4->1->6->9->11->12->10->2->3->7->8";
    private static final String POST_OREDR = "4->5->1->12->11->10->9->6->0->3->2->7->8";
    private static final String REVERSE_POST_ORDER = "8->7->2->3->0->6->9->10->11->12->1->5->4";

    @Before
    public void setUp() throws Exception {
        diGraph = new DiGraph(6);
        diGraph.addEdge(0, 5);
        diGraph.addEdge(3, 5);
        diGraph.addEdge(5, 4);
        diGraph.addEdge(4, 3);

        diGraph1 = new DiGraph(13);
        diGraph1.addEdge(0, 5);
        diGraph1.addEdge(0, 1);
        diGraph1.addEdge(0, 6);
        diGraph1.addEdge(2, 3);
        diGraph1.addEdge(2, 0);
        diGraph1.addEdge(3, 5);
        diGraph1.addEdge(5, 4);
        diGraph1.addEdge(6, 4);
        diGraph1.addEdge(6, 9);
        diGraph1.addEdge(7, 6);
        diGraph1.addEdge(8, 7);
        diGraph1.addEdge(9, 11);
        diGraph1.addEdge(9, 12);
        diGraph1.addEdge(9, 10);
        diGraph1.addEdge(11, 12);

    }

    @Test
    public void testDirectedCycle() {
        DirectedCycle directedCycle = new DirectedCycle(diGraph);
        Assert.assertTrue(directedCycle.hasCycle());
        StringJoiner stringJoiner = new StringJoiner("->");
        directedCycle.cycle().forEach(v -> {
            stringJoiner.add(String.valueOf(v));
        });
        Assert.assertEquals(CYCLE_PATH, stringJoiner.toString());
    }

    @Test
    public void testPreOrder() {
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(diGraph1);
        StringJoiner stringJoiner = new StringJoiner("->");
        depthFirstOrder.pre().forEach(v -> {
            stringJoiner.add(String.valueOf(v));
        });
        Assert.assertEquals(PRE_OREDR, stringJoiner.toString());
    }

    @Test
    public void testPostOrder() {
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(diGraph1);
        StringJoiner stringJoiner = new StringJoiner("->");
        depthFirstOrder.post().forEach(v -> {
            stringJoiner.add(String.valueOf(v));
        });
        Assert.assertEquals(POST_OREDR, stringJoiner.toString());
    }

    @Test
    public void testReversePostOrder() {
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(diGraph1);
        StringJoiner stringJoiner = new StringJoiner("->");
        depthFirstOrder.reversePost().forEach(v -> {
            stringJoiner.add(String.valueOf(v));
        });
        Assert.assertEquals(REVERSE_POST_ORDER, stringJoiner.toString());
    }

}
