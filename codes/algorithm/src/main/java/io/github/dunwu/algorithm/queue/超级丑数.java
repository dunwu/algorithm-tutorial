package io.github.dunwu.algorithm.queue;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/super-ugly-number/">313. 超级丑数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-24
 */
public class 超级丑数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(32, s.nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));
        Assertions.assertEquals(1, s.nthSuperUglyNumber(1, new int[] { 2, 3, 5 }));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(32, s2.nthSuperUglyNumber(12, new int[] { 2, 7, 13, 19 }));
        Assertions.assertEquals(1, s2.nthSuperUglyNumber(1, new int[] { 2, 3, 5 }));
    }

    // 优先队列（堆）方案
    static class Solution {

        public int nthSuperUglyNumber(int n, int[] primes) {
            Set<Long> set = new HashSet<>();
            PriorityQueue<Long> queue = new PriorityQueue<>();
            set.add(1L);
            queue.add(1L);
            for (int i = 1; i <= n; i++) {
                long curVal = queue.poll();
                if (i == n) { return (int) curVal; }
                for (int prime : primes) {
                    long nextVal = curVal * prime;
                    if (!set.contains(nextVal)) {
                        set.add(nextVal);
                        queue.add(nextVal);
                    }
                }
            }
            return -1;
        }

    }

    // 多路归并方案
    static class Solution2 {

        public int nthSuperUglyNumber(int n, int[] nums) {
            int m = nums.length;
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            for (int i = 0; i < m; i++) {
                q.add(new int[] { nums[i], i, 0 });
            }
            int[] dp = new int[n];
            dp[0] = 1;
            for (int j = 1; j < n; ) {
                int[] poll = q.poll();
                int num = poll[0], i = poll[1], idx = poll[2];
                if (num != dp[j - 1]) dp[j++] = num;
                q.add(new int[] { dp[idx + 1] * nums[i], i, idx + 1 });
            }
            return dp[n - 1];
        }

    }

}
