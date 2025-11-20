package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/squares-of-a-sorted-array/">977. 有序数组的平方</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 有序数组的平方 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] input1 = { -4, -1, 0, 3, 10 };
        int[] expect1 = { 0, 1, 9, 16, 100 };
        int[] output1 = s.sortedSquares(input1);
        Assertions.assertArrayEquals(expect1, output1);

        int[] input2 = { -7, -3, 2, 3, 11 };
        int[] expect2 = { 4, 9, 9, 49, 121 };
        int[] output2 = s.sortedSquares(input2);
        Assertions.assertArrayEquals(expect2, output2);
    }

    public static class Solution {

        public int[] sortedSquares(int[] nums) {
            int p = nums.length - 1;
            int i = 0, j = nums.length - 1;
            int[] res = new int[nums.length];
            while (i <= j) {
                if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                    res[p] = nums[i] * nums[i];
                    i++;
                } else {
                    res[p] = nums[j] * nums[j];
                    j--;
                }
                p--;
            }
            return res;
        }

    }

}
