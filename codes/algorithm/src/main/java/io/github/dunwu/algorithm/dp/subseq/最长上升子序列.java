package io.github.dunwu.algorithm.dp.subseq;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">300. 最长上升子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 最长上升子序列 {

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        Assertions.assertEquals(4, lengthOfLIS(nums));
        Assertions.assertEquals(1, lengthOfLIS(new int[] { 0 }));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        final int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) dp[i] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
