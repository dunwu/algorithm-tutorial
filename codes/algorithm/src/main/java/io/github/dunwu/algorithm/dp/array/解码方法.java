package io.github.dunwu.algorithm.dp.array;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/decode-ways/">91. 解码方法</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-11-17
 */
public class 解码方法 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.numDecodings("12"));
        Assertions.assertEquals(3, s.numDecodings("226"));
        Assertions.assertEquals(0, s.numDecodings("06"));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(2, s2.numDecodings("12"));
        Assertions.assertEquals(3, s2.numDecodings("226"));
        Assertions.assertEquals(0, s2.numDecodings("06"));
    }

    // 回溯解法
    static class Solution {

        private StringBuilder sb;
        private LinkedList<String> res;

        public int numDecodings(String s) {
            sb = new StringBuilder();
            res = new LinkedList<>();
            backtrack(s, 0);
            return res.size();
        }

        public void backtrack(String s, int start) {

            // base case，走到叶子节点
            // 即整个 s 被成功分割为合法的四部分，记下答案
            if (start == s.length()) {
                res.add(sb.toString());
                return;
            }

            for (int i = start; i < s.length(); i++) {

                // s[start..i] 不是合法的 ip 数字，不能分割
                char letter = getLetter(s, start, i);
                if (letter == '#') { continue; }

                // 【选择】
                // s[start..i] 是一个合法的 ip 数字，可以进行分割
                // 做选择，把 s[start..i] 放入路径列表中
                sb.append(letter);

                // 【回溯】
                backtrack(s, i + 1);

                // 【取消选择】
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        public char getLetter(String s, int begin, int end) {
            int len = end - begin + 1;
            if (len <= 0 || len > 2) { return '#'; }
            String numStr = s.substring(begin, begin + len);
            if (numStr.startsWith("0")) { return '#'; }
            int num = Integer.parseInt(numStr);
            if (num < 1 || num > 26) { return '#'; }
            return (char) ('A' + (num - 1));
        }

    }

    // 动态规划
    static class Solution2 {

        public int numDecodings(String s) {
            int n = s.length();
            s = " " + s;
            char[] ch = s.toCharArray();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                // a : 代表「当前位置」单独形成 item
                // b : 代表「当前位置」与「前一位置」共同形成 item
                int a = ch[i] - '0', b = (ch[i - 1] - '0') * 10 + (ch[i] - '0');
                // 如果 a 属于有效值，那么 dp[i] 可以由 dp[i - 1] 转移过来
                if (1 <= a && a <= 9) dp[i] = dp[i - 1];
                // 如果 b 属于有效值，那么 dp[i] 可以由 dp[i - 2] 或者 dp[i - 1] & dp[i - 2] 转移过来
                if (10 <= b && b <= 26) dp[i] += dp[i - 2];
            }
            return dp[n];
        }

    }

}
