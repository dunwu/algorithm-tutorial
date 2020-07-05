package io.github.dunwu.algorithm.dynamic;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/submissions/">79. 单词搜索</a>
 * @since 2020-07-04
 */
public class 爬楼梯 {

    public static void main(String[] args) {
        Assertions.assertEquals(1, climbStairs(0));
        Assertions.assertEquals(1, climbStairs(1));
        Assertions.assertEquals(2, climbStairs(2));
        Assertions.assertEquals(3, climbStairs(3));

        Assertions.assertEquals(1, climbStairs2(0));
        Assertions.assertEquals(1, climbStairs2(1));
        Assertions.assertEquals(2, climbStairs2(2));
        Assertions.assertEquals(3, climbStairs2(3));

        Assertions.assertEquals(1, climbStairs3(0));
        Assertions.assertEquals(1, climbStairs3(1));
        Assertions.assertEquals(2, climbStairs3(2));
        Assertions.assertEquals(3, climbStairs3(3));
    }

    // 使用递归（回溯方式）
    // 时间复杂度：O(2^N)
    public static int climbStairs(int n) {
        return (n <= 1) ? 1 : climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 使用动态规划
    // 时间复杂度：O(N)
    // 空间复杂度：O(N)
    public static int climbStairs2(int n) {
        if (n <= 1) return 1;
        int[] mem = new int[n + 1];
        mem[0] = 1;
        mem[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            mem[i] = mem[i - 1] + mem[i - 2];
        }
        return mem[n];
    }
    // 优化 climbStairs2 动态规划方案
    // 时间复杂度：O(N)
    // 空间复杂度：O(3)
    public static int climbStairs3(int n) {
        if (n <= 1) return 1;
        int res = 0;
        int prevStep1 = 1;
        int prevStep2 = 1;
        for (int i = 2; i < n + 1; i++) {
            res = prevStep1 + prevStep2;
            prevStep2 = prevStep1;
            prevStep1 = res;
        }
        return res;
    }
}
