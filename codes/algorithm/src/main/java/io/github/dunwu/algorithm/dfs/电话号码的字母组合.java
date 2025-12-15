package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/">17. 电话号码的字母组合</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-05
 */
public class 电话号码的字母组合 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new String[] { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" },
            s.letterCombinations("23").toArray());
        Assertions.assertArrayEquals(new String[] { "a", "b", "c" }, s.letterCombinations("2").toArray());
        Assertions.assertArrayEquals(new String[] { "t", "u", "v" }, s.letterCombinations("8").toArray());
    }

    static class Solution {

        private StringBuilder sb;
        private LinkedList<String> res;
        private final String[] options = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        public List<String> letterCombinations(String digits) {
            if (digits.isEmpty()) { return new LinkedList<>(); }
            sb = new StringBuilder();
            res = new LinkedList<>();
            // 从 digits[0] 开始进行回溯
            dfs(digits, 0);
            return res;
        }

        // 回溯算法主函数
        public void dfs(String digits, int start) {
            // 到达回溯树底部
            if (sb.length() == digits.length()) {
                res.add(sb.toString());
                return;
            }

            // 回溯算法框架
            int digit = digits.charAt(start) - '0';
            for (char c : options[digit].toCharArray()) {
                sb.append(c);
                dfs(digits, start + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

}
