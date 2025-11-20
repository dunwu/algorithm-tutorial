package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/">125. 验证回文串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 验证回文串 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isPalindrome("A man, a plan, a canal: Panama"));
        Assertions.assertFalse(s.isPalindrome("race a car"));
        Assertions.assertTrue(s.isPalindrome(" "));
        Assertions.assertTrue(s.isPalindrome("ab_a"));

        Solution2 s2 = new Solution2();
        Assertions.assertTrue(s2.isPalindrome("A man, a plan, a canal: Panama"));
        Assertions.assertFalse(s2.isPalindrome("race a car"));
        Assertions.assertTrue(s2.isPalindrome(" "));
        Assertions.assertTrue(s2.isPalindrome("ab_a"));
    }

    static class Solution {

        public boolean isPalindrome(String s) {
            String format = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            return isPalindrome(format, 0, format.length() - 1);
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

        public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (!Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                    continue;
                }
                if (!Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                    continue;
                }

                char l = Character.toLowerCase(s.charAt(left));
                char r = Character.toLowerCase(s.charAt(right));
                if (l != r) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

    }

}
