package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/">344. 反转字符串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 反转字符串 {

    public static void main(String[] args) {
        char[] s1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
        reverseString(s1);
        Assertions.assertArrayEquals(new char[] { 'o', 'l', 'l', 'e', 'h' }, s1);

        char[] s2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
        reverseString(s2);
        Assertions.assertArrayEquals(new char[] { 'h', 'a', 'n', 'n', 'a', 'H' }, s2);
    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
