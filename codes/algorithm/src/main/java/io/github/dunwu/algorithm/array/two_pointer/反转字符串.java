package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/reverse-string/">344. 反转字符串</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 反转字符串 {

    public static void main(String[] args) {
        Solution s = new Solution();
        char[] arr1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
        s.reverseString(arr1);
        Assertions.assertArrayEquals(new char[] { 'o', 'l', 'l', 'e', 'h' }, arr1);

        char[] arr2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
        s.reverseString(arr2);
        Assertions.assertArrayEquals(new char[] { 'h', 'a', 'n', 'n', 'a', 'H' }, arr2);
    }

    static class Solution {

        public void reverseString(char[] s) {
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

}
