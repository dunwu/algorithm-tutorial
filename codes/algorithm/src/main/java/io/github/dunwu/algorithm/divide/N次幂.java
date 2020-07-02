package io.github.dunwu.algorithm.divide;

import org.junit.jupiter.api.Assertions;

/**
 * 50. Pow(x, n) 求 N次幂
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/powx-n/">50. Pow(x, n)</a>
 * @since 2020-07-02
 */
public class N次幂 {

    public static void main(String[] args) {
        Assertions.assertEquals(1024.00000, myPow(2.00000, 10));
        Assertions.assertEquals(9.261000000000001, myPow(2.10000, 3));
        Assertions.assertEquals(0.25000, myPow(2.00000, -2));

        Assertions.assertEquals(1024.00000, myPow2(2.00000, 10));
        Assertions.assertEquals(9.261000000000001, myPow2(2.10000, 3));
        Assertions.assertEquals(0.25000, myPow2(2.00000, -2));
    }

    /**
     * 分治算法
     * <p>
     * x^n 可以视为 y^2(n为偶数) 或 x*y^2(n为奇数)
     * <p>
     * 时间复杂度：O(log N)
     */
    public static double myPow(double x, int n) {
        if (n > 0) return helper(x, n);
        return 1.00000 / helper(x, -n);
    }

    public static double helper(double x, int n) {
        if (n == 0) {
            return 1.00000;
        }

        double y = helper(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return x * y * y;
        }
    }

    /**
     * 暴力破解法
     * <p>
     * 时间复杂度：O(N)
     */
    public static double myPow2(double x, int n) {
        double result = 1.00000;

        if (n == 0) {
            return 1.00000;
        }

        int cnt = n > 0 ? n : -n;
        for (int i = 0; i < cnt; i++) {
            result *= x;
        }

        if (n < 0) result = 1.00000 / result;
        return result;
    }

    // 库函数
    public static double myPow3(double x, int n) {
        return Math.pow(x, n);
    }

}
