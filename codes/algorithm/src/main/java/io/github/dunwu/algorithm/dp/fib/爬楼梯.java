package io.github.dunwu.algorithm.dp.fib;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/">70. 爬楼梯</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-04
 */
public class 爬楼梯 {

    public static void main(String[] args) {

        Solution s = new Solution();
        Assertions.assertEquals(1, s.climbStairs(0));
        Assertions.assertEquals(1, s.climbStairs(1));
        Assertions.assertEquals(2, s.climbStairs(2));
        Assertions.assertEquals(3, s.climbStairs(3));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(1, s2.climbStairs(0));
        Assertions.assertEquals(1, s2.climbStairs(1));
        Assertions.assertEquals(2, s2.climbStairs(2));
        Assertions.assertEquals(3, s2.climbStairs(3));
    }

    static class Solution {

        int[] memo = null;

        public int climbStairs(int n) {
            memo = new int[n + 1];
            Arrays.fill(memo, -1);
            return dp(n);
        }

        // 爬第n阶楼梯的方法数量，等于 2 部分之和
        //
        // 爬上 n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
        // 爬上 n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
        public int dp(int n) {
            if (n == 0 || n == 1) return 1;
            if (memo[n] != -1) return memo[n];
            memo[n] = dp(n - 1) + dp(n - 2);
            return memo[n];
        }

    }

    // 空间复杂度 o(1)
    static class Solution2 {

        public int climbStairs(int n) {
            if (n == 0 || n == 1) return 1;
            int pre1 = 1, pre2 = 1;
            for (int i = 2; i <= n; i++) {
                int tmp = pre1 + pre2;
                pre2 = pre1;
                pre1 = tmp;
            }
            return pre1;
        }

    }

}
