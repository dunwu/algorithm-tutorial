package io.github.dunwu.algorithm.dp.array;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/solving-questions-with-brainpower/">2140. 解决智力问题</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-17
 */
public class 解决智力问题 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(5, s.mostPoints(new int[][] { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } }));
        Assertions.assertEquals(7, s.mostPoints(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } }));
    }

    static class Solution {

        long[] memo;

        public long mostPoints(int[][] questions) {
            if (questions == null || questions.length == 0) { return 0; }
            memo = new long[questions.length + 1];
            Arrays.fill(memo, -1);
            return dp(questions, 0);
        }

        public long dp(int[][] questions, int i) {
            if (i < 0 || i >= questions.length) { return 0L; }
            if (memo[i] != -1) { return memo[i]; }
            int score = questions[i][0];
            int skip = questions[i][1];
            memo[i] = Math.max(
                dp(questions, i + 1),
                dp(questions, i + skip + 1) + score
            );
            return memo[i];
        }

    }

}
