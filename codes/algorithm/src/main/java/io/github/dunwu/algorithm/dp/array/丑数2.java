package io.github.dunwu.algorithm.dp.array;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-ii/">264. 丑数II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-24
 */
public class 丑数2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(12, s.nthUglyNumber(10));
        Assertions.assertEquals(1, s.nthUglyNumber(1));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(12, s2.nthUglyNumber(10));
        Assertions.assertEquals(1, s2.nthUglyNumber(1));
    }

    // 动态规划方案
    static class Solution {

        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            int p2 = 1, p3 = 1, p5 = 1;
            for (int i = 2; i <= n; i++) {
                int num2 = dp[p2] * 2;
                int num3 = dp[p3] * 3;
                int num5 = dp[p5] * 5;
                dp[i] = min(num2, num3, num5);
                if (dp[i] == num2) { p2++; }
                if (dp[i] == num3) { p3++; }
                if (dp[i] == num5) { p5++; }
            }
            return dp[n];
        }

        int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }

    // 优先队列（堆）方案
    static class Solution2 {

        int[] nums = new int[] { 2, 3, 5 };

        public int nthUglyNumber(int n) {
            Set<Long> set = new HashSet<>();
            PriorityQueue<Long> q = new PriorityQueue<>();
            set.add(1L);
            q.add(1L);
            for (int i = 1; i <= n; i++) {
                long x = q.poll();
                if (i == n) return (int) x;
                for (int num : nums) {
                    long t = num * x;
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(t);
                    }
                }
            }
            return -1;
        }

    }

}
