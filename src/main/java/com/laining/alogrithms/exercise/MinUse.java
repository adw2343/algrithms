package com.laining.alogrithms.exercise;

import java.util.Stack;
import java.util.StringJoiner;

/**
 * nikola现在已经成为一个游戏里的重要人物。这个游戏有一行N个方格，N个方格用数字1..N表示。nikola开始是站在1号位置，然后能够跳到其他位置，但第一跳必须跳到2号位置。随后的每一跳必须满足以下两个条件：
 * 
 * （1）如果是向前跳，必须比前面一跳远一个方格。
 * 
 * （2）如果是向后跳，必须和前面一跳一样远。
 * 
 * 比如，在第一跳之后（在2号位置），nikola能够跳回1号位置，或者向前跳到4号位置。
 * 
 * 每次他跳入一个位置，nikola必须付费。nikola的目标是从一号位置尽可能便宜地跳到N号位置。
 * 
 * 请告诉nikola，跳到N号位置时的最小花费。
 * 
 * <p>
 * 题解：f(i,j)表示最后一次跳了j步到达i的花费,则有:
 * <ul>
 * <li>当i + j <= N 时，最后一次可能是后退j步到达i,也可能是前进j步到达i,故有:f(i,j) = min{f(i+j,j) + cost(i),f(i-j,j-1) + cost(i)}</li>
 * <li>当i + j > N 时,最后一次只可能时前进j步到达i,故有:f(i,j) = f(i-j,j-1) + cost(i)</li>
 * </ul>
 * </p>
 * 
 * @author laining
 *
 */
public class MinUse {
    private int MAX = 100000;

    public int minPlan(int[] perCost, int n) {
        assert perCost != null && perCost.length == n;
        int min = MAX;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            stack.push(n);
            int cost = min(perCost, n, i, stack);
            stack.push(1);
            if (cost > 0 && cost < min) {
                min = cost;
                System.out.println("f(" + n + "," + i + ") = " + cost);
                StringJoiner stringJoiner = new StringJoiner("->");
                while (!stack.isEmpty()) {
                    stringJoiner.add(String.valueOf(stack.pop()));
                }
                System.out.println(stringJoiner.toString());
            }
            stack.clear();
        }
        return min;
    }

    private int min(int[] perCost, int i, int j, Stack<Integer> stack) {
        if (i < 1 || j < 1) {
            stack.push(i);
            return MAX;
        }
        if (i == 1 && j == 1) {
            stack.push(2);
            return 3;
        }
        if (i == 2 && j == 1) {
            stack.push(i);
            return perCost[1];
        }
        if (i + j <= perCost.length) {
            int size = stack.size();
            int a = min(perCost, i + j, j, stack) + perCost[i - 1];
            int aPushed = stack.size() - size;
            int b = min(perCost, i - j, j - 1, stack) + perCost[i - 1];
            int bPushed = stack.size() - size - aPushed;
            Stack<Integer> tmp = new Stack<>();
            if (a < b) {
                while (bPushed > 0) {
                    stack.pop();
                    bPushed--;
                }
                while (aPushed > 0) {
                    tmp.push(stack.pop());
                    aPushed--;
                }
                stack.push(i + j);
                while (!tmp.isEmpty()) {
                    stack.push(tmp.pop());
                }
                return a;
            } else {
                while (bPushed > 0) {
                    tmp.push(stack.pop());
                    bPushed--;
                }
                while (aPushed > 0) {
                    stack.pop();
                    aPushed--;
                }
                stack.push(i - j);
                while (!tmp.isEmpty()) {
                    stack.push(tmp.pop());
                }
                return b;
            }
        } else {
            stack.push(i - j);
            return min(perCost, i - j, j - 1, stack) + perCost[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] perCost1 = { 1, 2, 3, 4, 5, 6 };
        int[] perCost2 = { 2, 3, 4, 3, 1, 6, 1, 4 };
        MinUse minUse = new MinUse();
        System.out.println(minUse.minPlan(perCost2, 8));
    }

}
