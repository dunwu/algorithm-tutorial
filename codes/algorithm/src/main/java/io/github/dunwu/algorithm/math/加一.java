package io.github.dunwu.algorithm.math;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/plus-one/">66. 加一</a>
 *
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 加一 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 1, 2, 4 }, s.plusOne(new int[] { 1, 2, 3 }));
        Assertions.assertArrayEquals(new int[] { 4, 3, 2, 2 }, s.plusOne(new int[] { 4, 3, 2, 1 }));
        Assertions.assertArrayEquals(new int[] { 1, 0, 0, 0, 0 }, s.plusOne(new int[] { 9, 9, 9, 9 }));
    }

    static class Solution {

        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            }
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }

    }

}
