package io.github.dunwu.algorithm.array;

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
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length()
            && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 此时 [l+1, r-1] 就是最长回文串
        return s.substring(l + 1, r);
    }

}
