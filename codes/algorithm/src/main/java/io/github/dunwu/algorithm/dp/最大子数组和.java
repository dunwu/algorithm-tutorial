package io.github.dunwu.algorithm.dp;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/">53. 最大子数组和</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 最大子数组和 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(6, s.maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    static class Solution {

        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            int[] dp = new int[n];
            // base case
            // 第一个元素前面没有子数组
            dp[0] = nums[0];
            // 状态转移方程
            int res = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
                res = Math.max(res, dp[i]);
                System.out.printf("nums[%d] = %d, dp[%d] = %d\n", i, nums[i], i, dp[i]);
            }
            return res;
        }

    }

}
