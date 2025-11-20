package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/">14. 最长公共前缀</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 最长公共前缀 {

    public static void main(String[] args) {

        Solution s = new Solution();
        String[] input1 = { "flower", "flow", "flight" };
        String expect1 = "fl";
        String output1 = s.longestCommonPrefix(input1);
        Assertions.assertEquals(expect1, output1);

        String[] input2 = { "dog", "racecar", "car" };
        String expect2 = "";
        String output2 = s.longestCommonPrefix(input2);
        Assertions.assertEquals(expect2, output2);
    }

    static class Solution {

        public String longestCommonPrefix(String[] strs) {
            int m = strs.length;
            // 以第一行的列数为基准
            int n = strs[0].length();
            for (int col = 0; col < n; col++) {
                for (int row = 1; row < m; row++) {
                    String cur = strs[row], prev = strs[row - 1];
                    // 判断每个字符串的 col 索引是否都相同
                    if (col >= cur.length() || col >= prev.length() ||
                        cur.charAt(col) != prev.charAt(col)) {
                        // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                        return strs[row].substring(0, col);
                    }
                }
            }
            return strs[0];
        }

    }

}
