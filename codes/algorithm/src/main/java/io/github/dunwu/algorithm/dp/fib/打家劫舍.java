package io.github.dunwu.algorithm.dp.fib;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/house-robber/">198. 打家劫舍</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 打家劫舍 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.rob(new int[] { 1, 2, 3, 1 }));
        Assertions.assertEquals(12, s.rob(new int[] { 2, 7, 9, 3, 1 }));
        Assertions.assertEquals(1, s.rob(new int[] { 1, 1 }));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(4, s2.rob(new int[] { 1, 2, 3, 1 }));
        Assertions.assertEquals(12, s2.rob(new int[] { 2, 7, 9, 3, 1 }));
        Assertions.assertEquals(1, s2.rob(new int[] { 1, 1 }));
    }

    static class Solution {

        public int rob(int[] nums) {

            int N = nums.length;
            if (N <= 1) { return nums[0]; }

            int[] dp = new int[N + 1];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < N; i++) {
                dp[i] = Math.max(
                    dp[i - 1],
                    dp[i - 2] + nums[i]
                );
            }

            return dp[N - 1];
        }

    }

    /**
     * 优化空间复杂度
     */
    static class Solution2 {

        public int rob(int[] nums) {
            int N = nums.length;
            if (N <= 1) { return nums[0]; }

            int cur = Math.max(nums[0], nums[1]), pre = nums[0];
            for (int i = 2; i < N; i++) {
                int tmp = Math.max(cur, pre + nums[i]);
                pre = cur;
                cur = tmp;
            }
            return cur;
        }

    }

}
