package com.laining.alogrithms.exercise;

/**
 * 楼梯有s阶台阶，上楼时可以走1阶也可以走2阶，计算当台阶数为n时共有多少种走法
 * 
 * @author laining
 *
 */
public class Steps {

    /**
     * 假如当前在第n阶台阶上，我们上一个位置只能在第n-1或者n-2上。所以有：
     * 
     * F(n) = F(n-1) + F(n-2) 注意当n <= 2时需要特殊处理
     * 
     * @param n
     * @return
     */
    public int step(int n) {
        if (n <= 0)
            return 0;
        if (n <= 2)
            return n;
        return step(n - 1) + step(n - 2);
    }

}
