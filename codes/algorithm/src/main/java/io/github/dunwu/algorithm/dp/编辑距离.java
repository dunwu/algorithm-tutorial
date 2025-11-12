package io.github.dunwu.algorithm.dp;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">72. 编辑距离</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 编辑距离 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.minDistance("horse", "ros"));
        Assertions.assertEquals(5, s.minDistance("intention", "execution"));
    }

    static class Solution {

        int[][] memo = null;

        public int minDistance(String word1, String word2) {
            memo = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i <= word1.length(); i++) {
                Arrays.fill(memo[i], -1);
            }
            return dp(word1, word1.length() - 1, word2, word2.length() - 1);
        }

        public int dp(String s1, int i, String s2, int j) {

            // base case
            if (i == -1) return j + 1;
            if (j == -1) return i + 1;

            if (memo[i][j] != -1) { return memo[i][j]; }

            // 字符相等，啥也不做
            if (s1.charAt(i) == s2.charAt(j)) {
                memo[i][j] = dp(s1, i - 1, s2, j - 1);
            } else {
                memo[i][j] = min(
                    // 插入
                    dp(s1, i, s2, j - 1) + 1,
                    // 删除
                    dp(s1, i - 1, s2, j) + 1,
                    // 替换
                    dp(s1, i - 1, s2, j - 1) + 1
                );
            }
            return memo[i][j];
        }

        public int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }

}
