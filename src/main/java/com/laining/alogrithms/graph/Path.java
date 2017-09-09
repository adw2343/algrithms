package com.laining.alogrithms.graph;

/**
 * 图的查找接口，实现应该提供一个顶点和图来进行初始化
 * 
 * @author laining
 *
 */
public interface Path {

    /**
     * 判断构造时提供的顶点和顶点{@code v}是否是连通的
     * 
     * @param v
     * @return
     */
    boolean hasPathTo(Integer v);

    /**
     * 获取构造时提供的顶点到顶点{@code v}的路径
     * 
     * @param v
     * @return
     */
    Iterable<Integer> pathTo(Integer v);

}
