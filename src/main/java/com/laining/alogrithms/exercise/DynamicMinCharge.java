package com.laining.alogrithms.exercise;

/**
 * 问题:有最小面额为11 5 1的三种人民币，用最少的张数找钱
 * <ul>
 * <li>动态规划:设f[n]为要找开n元钱，需要的最少人民币张数,则有:f[n] = min{f[n-1] + 1,f[n-5] + 1,f[n-11] + 1}</li>
 * </ul>
 * 
 * @author laining
 *
 */
public class DynamicMinCharge {

    private final int ONE = 1;
    private final int FIVE = 5;
    private final int ELEVEN = 11;
    private int[] f;
    private int[][] numVal; // numVal[0][i]表示找i元钱,需要1元人民币的张数,numVal[1][i]表示5，numVal[2][i]表示11
    private int n;

    public DynamicMinCharge(int n) {
        this.n = n;
        f = new int[n + 1];
        numVal = new int[3][n + 1];
    }

    private int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }

    private int min(int a, int b) {
        return a < b ? a : b;
    }

    /**
     * 最小的张数
     * 
     * @param n
     * @return
     */
    public int chargeMoney() {
        f[0] = 0;
        for (int i = 1; i < FIVE; i++)
            f[i] = 1;
        for (int i = FIVE; i <= n; i++) {
            if (i >= ELEVEN) {
                f[i] = min(f[i - 1] + 1, f[i - 5] + 1, f[i - 11] + 1);
            } else {
                f[i] = min(f[i - 1] + 1, f[i - 5] + 1);
            }
        }
        return f[n];
    }

    public void bestChoice() {
        int i;
        for (i = 0; i < FIVE; i++) {
            numVal[0][i] = i;
            numVal[1][i] = 0;
            numVal[2][i] = 0;
        }
        for (i = FIVE; i <= n; i++) {
            if (i >= ELEVEN && (f[i] == f[i - 11] + 1)) {
                numVal[0][i] = numVal[0][i - ELEVEN];
                numVal[1][i] = numVal[1][i - ELEVEN];
                numVal[2][i] = numVal[2][i - ELEVEN] + 1;
            } else if (f[i] == f[i - FIVE] + 1) {
                numVal[0][i] = numVal[0][i - FIVE];
                numVal[1][i] = numVal[1][i - FIVE] + 1;
                numVal[2][i] = numVal[2][i - FIVE];
            } else if (f[i] == f[i - ONE] + 1) {
                numVal[0][i] = numVal[0][i - ONE] + 1;
                numVal[1][i] = numVal[1][i - ONE];
                numVal[2][i] = numVal[2][i - ONE];
            }
        }
        System.out.println("1元:" + numVal[0][n]);
        System.out.println("5元:" + numVal[1][n]);
        System.out.println("11元:" + numVal[2][n]);

    }

    public static void main(String[] args) {
        DynamicMinCharge dynamicMinCharge = new DynamicMinCharge(15);
        System.out.println(dynamicMinCharge.chargeMoney());
        dynamicMinCharge.bestChoice();
    }

}
