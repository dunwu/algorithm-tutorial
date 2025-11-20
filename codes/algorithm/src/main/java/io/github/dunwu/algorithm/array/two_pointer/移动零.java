package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/">283. 移动零</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2018-11-05
 */
public class 移动零 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] arr1 = { 0, 1, 0, 3, 12 };
        s.moveZeroes(arr1);
        Assertions.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, arr1);

        int[] arr2 = { 0, 0, 1 };
        s.moveZeroes(arr2);
        Assertions.assertArrayEquals(new int[] { 1, 0, 0 }, arr2);

        int[] arr3 = { 0 };
        s.moveZeroes(arr3);
        Assertions.assertArrayEquals(new int[] { 0 }, arr3);
    }

    public static class Solution {

        public void moveZeroes(int[] nums) {
            // slow 指针维护所有不为 0 的元素
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            // 后续补零
            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

    }

}
