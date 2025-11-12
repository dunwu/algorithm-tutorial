package io.github.dunwu.algorithm.dp.subseq;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 最长递增子序列 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
    }

    /**
     * 使用备忘录优化动态规划问题
     */
    static class Solution {

        public int lengthOfLIS(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            int res = 0;
            for (int num : dp) {
                res = Math.max(res, num);
            }
            return res;
        }

    }

}
