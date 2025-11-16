package io.github.dunwu.algorithm.dp.subseq;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-arithmetic-subsequence-of-given-difference/">1218. 最长定差子序列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-14
 */
public class 最长定差子序列 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.longestSubsequence(new int[] { 1, 2, 3, 4 }, 1));
        Assertions.assertEquals(1, s.longestSubsequence(new int[] { 1, 3, 5, 7 }, 1));
        Assertions.assertEquals(4, s.longestSubsequence(new int[] { 1, 5, 7, 8, 5, 3, 4, 2, 1 }, -2));
        Assertions.assertEquals(2, s.longestSubsequence(new int[] { 3, 4, -3, -2, -4 }, -5));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(4, s2.longestSubsequence(new int[] { 1, 2, 3, 4 }, 1));
        Assertions.assertEquals(1, s2.longestSubsequence(new int[] { 1, 3, 5, 7 }, 1));
        Assertions.assertEquals(4, s2.longestSubsequence(new int[] { 1, 5, 7, 8, 5, 3, 4, 2, 1 }, -2));
        Assertions.assertEquals(2, s2.longestSubsequence(new int[] { 3, 4, -3, -2, -4 }, -5));
    }

    static class Solution {

        public int longestSubsequence(int[] arr, int diff) {
            int n = arr.length;
            Map<Integer, Integer> map = new HashMap<>();
            int[][] dp = new int[n][2];
            dp[0][1] = 1;
            map.put(arr[0], 0);
            for (int i = 1; i < n; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
                dp[i][1] = 1;
                int prev = arr[i] - diff;
                if (map.containsKey(prev)) dp[i][1] = Math.max(dp[i][1], dp[map.get(prev)][1] + 1);
                map.put(arr[i], i);
            }
            return Math.max(dp[n - 1][0], dp[n - 1][1]);
        }

    }

    static class Solution2 {

        public int longestSubsequence(int[] arr, int diff) {
            int res = 1;
            Map<Integer, Integer> map = new HashMap<>();
            for (int val : arr) {
                map.put(val, map.getOrDefault(val - diff, 0) + 1);
                res = Math.max(res, map.get(val));
            }
            return res;
        }

    }

}
