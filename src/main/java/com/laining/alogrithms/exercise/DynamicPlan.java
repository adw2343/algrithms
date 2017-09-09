package com.laining.alogrithms.exercise;

/**
 * 动态规划算法
 * 
 * @author laining
 *
 */
public class DynamicPlan {

    /**
     * 找零钱问题
     * <p>
     * 有数组penny,penny中所有的值都为正数且不重复。每个值代表一种面值的货币,每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法.
     * </p>
     * <p>
     * 解析:设f[n][m]为使用前n种货币找钱m的方法数，则有:
     * <ul>
     * <li>penny[n] > m 时，不会使用到第n种货币，故有:f[n][m]=f[n-1][m]</li>
     * <li>否则，会使用到第n种货币:f[n][m]=f[n-1]f[m] + f[n-1][m-penny[n]]</li>
     * </ul>
     * 注意，只有penny[0]为1时才可能必能找钱
     * </p>
     * 
     * @param penny
     * @param n
     * @param aim
     * @return
     */
    public int countWays(int[] penny, int n, int aim) {
        if (penny == null || n == 0 || aim < 0 || penny[0] > aim)
            return 0;
        int[][] f = new int[n][aim + 1];
        for (int i = 0; i < n; i++) {
            f[i][0] = 0;
        }
        for (int i = 1; penny[0] * i <= aim; i++) {
            f[0][penny[0] * i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= aim; j++) {
                if (penny[i] > j) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - penny[i]];
                }
            }
        }
        return f[n - 1][aim];
    }

    public static void main(String[] args) {
        DynamicPlan dynamicPlan = new DynamicPlan();
        int[] penny = { 1, 2, 4 };
        System.out.println(dynamicPlan.countWays(penny, 3, 8));
    }

}
