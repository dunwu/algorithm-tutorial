package io.github.dunwu.algorithm.dp.str;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">5. 最长回文子串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals("bab", s.longestPalindrome("babad"));
        Assertions.assertEquals("bb", s.longestPalindrome("cbbd"));
        Assertions.assertEquals("a", s.longestPalindrome("a"));
    }

    static class Solution {

        public String longestPalindrome(String s) {
            String max = "";
            for (int i = 0; i < s.length(); i++) {
                for (int j = i; j < s.length(); j++) {
                    if (isPalindrome(s, i, j)) {
                        // System.out.println("s = " + s.substring(i, j + 1));
                        if (max.length() < (j - i + 1)) {
                            max = s.substring(i, j + 1);
                        }
                    }
                }
            }
            return max;
        }

        public boolean isPalindrome(String s, int left, int right) {
            if (s == null || s.length() == 0) { return false; }
            if (left == right) { return true; }
            if (left > right) { return false; }
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    }

}
