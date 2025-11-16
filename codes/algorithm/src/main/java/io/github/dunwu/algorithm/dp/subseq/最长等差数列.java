package io.github.dunwu.algorithm.dp.subseq;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/longest-arithmetic-subsequence/">1027. 最长等差数列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 最长等差数列 {

    public static void main(String[] args) {
        Solution s = new Solution();
        // Assertions.assertEquals(4, s.longestArithSeqLength(new int[] { 3, 6, 9, 12 }));
        // Assertions.assertEquals(3, s.longestArithSeqLength(new int[] { 9, 4, 7, 2, 10 }));
        Assertions.assertEquals(4, s.longestArithSeqLength(new int[] { 20, 1, 15, 3, 10, 5, 8 }));
    }

    static class Solution {

        public int longestArithSeqLength(int[] nums) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int num : nums) {
                min = Math.min(min, num);
                max = Math.max(max, num);
            }

            int res = 1;
            int maxDiff = max - min;
            for (int diff = -maxDiff; diff <= maxDiff; diff++) {
                res = Math.max(longestSubsequence(nums, diff), res);
            }
            return res;
        }

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
