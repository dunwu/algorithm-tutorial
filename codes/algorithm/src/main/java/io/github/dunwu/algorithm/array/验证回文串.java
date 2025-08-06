package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/valid-palindrome/">125. 验证回文串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 验证回文串 {

    public static void main(String[] args) {
        Assertions.assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
        Assertions.assertFalse(isPalindrome("race a car"));
        Assertions.assertTrue(isPalindrome(" "));
        Assertions.assertTrue(isPalindrome("ab_a"));
    }

    public static boolean isPalindrome(String s) {
        String format = s.toLowerCase();
        format = format.replaceAll("[^a-zA-Z0-9]", "");
        return doIsPalindrome(format);
    }

    public static boolean doIsPalindrome(String s) {
        if (s.length() == 0) { return true; }
        int left = 0, right = s.length() - 1;
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
