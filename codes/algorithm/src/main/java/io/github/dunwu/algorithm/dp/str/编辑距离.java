package io.github.dunwu.algorithm.dp.str;

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

        int[][] memo;

        public int minDistance(String word1, String word2) {
            memo = new int[word1.length()][word2.length()];
            for (int i = 0; i < word1.length(); i++) {
                Arrays.fill(memo[i], Integer.MAX_VALUE);
            }
            return dp(word1, 0, word2, 0);
        }

        public int dp(String word1, int i, String word2, int j) {
            if (i >= word1.length()) { return word2.length() - j; }
            if (j >= word2.length()) { return word1.length() - i; }
            if (memo[i][j] != Integer.MAX_VALUE) {
                return memo[i][j];
            }
            if (word1.charAt(i) == word2.charAt(j)) {
                memo[i][j] = dp(word1, i + 1, word2, j + 1);
            } else {
                memo[i][j] = min(
                    dp(word1, i + 1, word2, j),
                    dp(word1, i, word2, j + 1),
                    dp(word1, i + 1, word2, j + 1)
                ) + 1;
            }
            return memo[i][j];
        }

        public int min(int a, int b, int c) {
            return Math.min(a, Math.min(b, c));
        }

    }

}
