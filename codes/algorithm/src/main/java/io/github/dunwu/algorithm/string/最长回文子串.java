package io.github.dunwu.algorithm.string;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-01-10
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        Assertions.assertEquals("bab", longestPalindrome("babad"));
        Assertions.assertEquals("bb", longestPalindrome("cbbd"));
        Assertions.assertEquals("aca", longestPalindrome("aacabdkacaa"));
    }

    public static String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        String max = s.substring(0, 1);
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length - 1; j > i; j--) {
                if (check(chars, i, j)) {
                    String temp = s.substring(i, j + 1);
                    if (temp.length() > max.length()) {
                        max = temp;
                    }
                }
            }
        }
        return max;
    }

    public static boolean check(char[] chars, int begin, int end) {
        int left = begin, right = end;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
