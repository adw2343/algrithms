package com.laining.algrithms.test;

import java.util.StringJoiner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.laining.alogrithms.graph.BreadthFirstPath;
import com.laining.alogrithms.graph.CC;
import com.laining.alogrithms.graph.DepthFirstPath;
import com.laining.alogrithms.graph.Graph;
import com.laining.alogrithms.graph.Path;
import com.laining.alogrithms.graph.TwoColor;

public class GraphTest {

    private Graph graph;

    private Graph graph1;

    private static final String DEPTH_2_5_PATH = "0->2->3->5";
    private static final String BREDTH_2_5_PATH = "0->5";

    @Before
    public void Before() {
        graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(1, 2);
        graph.addEdge(0, 1);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(0, 5);

        graph1 = new Graph(13);
        graph1.addEdge(0, 5);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(0, 6);
        graph1.addEdge(1, 3);
        graph1.addEdge(3, 5);
        graph1.addEdge(5, 4);
        graph1.addEdge(6, 4);
        graph1.addEdge(6, 7);
        graph1.addEdge(7, 8);
        graph1.addEdge(8, 10);
        graph1.addEdge(10, 9);
        graph1.addEdge(10, 12);
        graph1.addEdge(9, 11);
        graph1.addEdge(12, 11);

    }

    @Test
    public void testDepthPath() {
        Path depthPath = new DepthFirstPath(0, graph);
        Iterable<Integer> paths = depthPath.pathTo(5);
        final StringJoiner stringJoiner = new StringJoiner("->");
        paths.forEach(i -> {
            stringJoiner.add(String.valueOf(i));
        });
        Assert.assertEquals(DEPTH_2_5_PATH, stringJoiner.toString());
    }

    @Test
    public void testBredthPath() {
        Path depthPath = new BreadthFirstPath(0, graph);
        Iterable<Integer> paths = depthPath.pathTo(5);
        final StringJoiner stringJoiner = new StringJoiner("->");
        paths.forEach(i -> {
            stringJoiner.add(String.valueOf(i));
        });
        Assert.assertEquals(BREDTH_2_5_PATH, stringJoiner.toString());
    }

    @Test
    public void testConnected() {
        CC cc = new CC(graph);
        Assert.assertEquals(1, cc.count());
        Assert.assertTrue(cc.connected(0, 4));
    }

    @Test
    public void testTwoColor() {
        TwoColor twoColor = new TwoColor(graph1);
        Assert.assertTrue(twoColor.isTwoColor());

        TwoColor twoColor1 = new TwoColor(graph);
        Assert.assertTrue(!twoColor1.isTwoColor());

    }

}
