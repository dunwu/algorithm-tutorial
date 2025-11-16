package io.github.dunwu.algorithm.dp.subseq;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-of-pair-chain/">646. 最长数对链</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-14
 */
public class 最长数对链 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input1 = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        Assertions.assertEquals(2, s.findLongestChain(input1));

        int[][] input2 = new int[][] { { 1, 2 }, { 7, 8 }, { 4, 5 } };
        Assertions.assertEquals(3, s.findLongestChain(input2));
    }

    static class Solution {

        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[0]));
            int n = pairs.length;
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (pairs[i][0] > pairs[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return dp[n - 1];
        }

    }

}
