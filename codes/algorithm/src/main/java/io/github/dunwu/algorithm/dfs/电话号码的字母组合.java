package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-05
 */
public class 电话号码的字母组合 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new String[] { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" },
            s.letterCombinations("23").toArray());
        Assertions.assertArrayEquals(new String[] { "a","b","c" }, s.letterCombinations("2").toArray());
        Assertions.assertArrayEquals(new String[] { "t","u","v" }, s.letterCombinations("8").toArray());
    }

    static class Solution {

        List<String> res;
        StringBuilder sb;
        final String[] table = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

        public List<String> letterCombinations(String digits) {
            sb = new StringBuilder();
            res = new LinkedList<>();
            backtrack(digits.toCharArray(), 0);
            return res;
        }

        public void backtrack(char[] nums, int index) {
            if (sb.length() == nums.length) {
                res.add(sb.toString());
                return;
            }
            int num = nums[index] - '0';
            for (int i = 0; i < table[num].length(); i++) {
                sb.append(table[num].charAt(i));
                backtrack(nums, index + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }

}
