package io.github.dunwu.algorithm.array.two_pointer;

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
        Assertions.assertEquals("bb", s.longestPalindrome("bb"));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals("aba", s2.longestPalindrome("babad"));
        Assertions.assertEquals("bb", s2.longestPalindrome("cbbd"));
        Assertions.assertEquals("a", s2.longestPalindrome("a"));
        Assertions.assertEquals("bb", s2.longestPalindrome("bb"));
    }

    /**
     * 双指针判断回文串 + 暴力解决，时间复杂度 o(n^2)
     */
    static class Solution {

        public String longestPalindrome(String s) {
            String res = s.substring(0, 1);
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (isPalindrome(s, i, j)) {
                        int len = j - i + 1;
                        if (len > res.length()) {
                            res = s.substring(i, j + 1);
                        }
                    }
                }
            }
            return res;
        }

        public boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    }

    static class Solution2 {

        public String longestPalindrome(String s) {
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String s1 = palindrome(s, i, i);
                String s2 = palindrome(s, i, i + 1);
                res = res.length() > s1.length() ? res : s1;
                res = res.length() > s2.length() ? res : s2;
            }
            return res;
        }

        public String palindrome(String s, int l, int r) {
            while (l >= 0 && r < s.length()
                && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }

    }

}
