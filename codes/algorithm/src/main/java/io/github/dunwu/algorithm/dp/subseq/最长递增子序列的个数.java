package io.github.dunwu.algorithm.dp.subseq;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 最长递增子序列的个数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 }));
        Assertions.assertEquals(5, s.findNumberOfLIS(new int[] { 2, 2, 2, 2, 2 }));
        Assertions.assertEquals(3, s.findNumberOfLIS(new int[] { 1, 2, 4, 3, 5, 4, 7, 2 }));
    }

    static class Solution {

        public int findNumberOfLIS(int[] nums) {

            int n = nums.length;
            int[] dp = new int[n];
            int[] cnt = new int[n];
            int max = 1;
            for (int i = 0; i < n; i++) {
                dp[i] = cnt[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            cnt[i] = cnt[j];
                        } else if (dp[i] == dp[j] + 1) {
                            cnt[i] += cnt[j];
                        }
                    }
                }
                max = Math.max(max, dp[i]);
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (dp[i] == max) res += cnt[i];
            }
            return res;
        }

    }

}
