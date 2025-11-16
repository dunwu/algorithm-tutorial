package io.github.dunwu.algorithm.dp.subseq;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/">300. 最长递增子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 不相交的线 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.maxUncrossedLines(new int[] { 1, 4, 2 }, new int[] { 1, 2, 4 }));
    }

    static class Solution {

        int[][] memo;

        public int maxUncrossedLines(int[] nums1, int[] nums2) {
            memo = new int[nums1.length + 1][nums2.length + 1];
            for (int i = 0; i <= nums1.length; i++) {
                Arrays.fill(memo[i], -1);
            }
            return dp(nums1, 0, nums2, 0);
        }

        public int dp(int[] nums1, int i, int[] nums2, int j) {
            if (i < 0 || i >= nums1.length || j < 0 || j >= nums2.length) { return 0; }
            if (memo[i][j] != -1) { return memo[i][j]; }
            if (nums1[i] == nums2[j]) {
                memo[i][j] = dp(nums1, i + 1, nums2, j + 1) + 1;
            } else {
                memo[i][j] = max(
                    dp(nums1, i, nums2, j + 1),
                    dp(nums1, i + 1, nums2, j),
                    dp(nums1, i + 1, nums2, j + 1)
                );
            }
            return memo[i][j];
        }

        public int max(int a, int b, int c) {
            return Math.max(a, Math.max(b, c));
        }

    }

}
