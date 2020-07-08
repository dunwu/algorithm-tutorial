package io.github.dunwu.algorithm.recursive;

import org.junit.jupiter.api.Assertions;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-08
 */
public class 反转字符串 {

    public static void main(String[] args) {
        char[] str = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(str);
        Assertions.assertArrayEquals(new char[] { 'o', 'l', 'l', 'e', 'h' }, str);

        char[] str2 = { 'H', 'a', 'n', 'n', 'a', 'h' };
        reverseString(str2);
        Assertions.assertArrayEquals(new char[] { 'h', 'a', 'n', 'n', 'a', 'H' }, str2);
    }

    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int l = 0, r = s.length - 1;
        recursive(s, l, r);
    }

    private static void recursive(char[] s, int l, int r) {
        if (l >= r) return;
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
        recursive(s, l + 1, r - 1);
    }

}
