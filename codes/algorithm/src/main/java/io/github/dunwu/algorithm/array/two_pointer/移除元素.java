package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/remove-element/">27. 移除元素</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2018-11-05
 */
public class 移除元素 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] arr1 = { 3, 2, 2, 3 };
        Assertions.assertEquals(2, s.removeElement(arr1, 3));

        int[] arr2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
        Assertions.assertEquals(5, s.removeElement(arr2, 2));

        int[] arr3 = { 1 };
        Assertions.assertEquals(0, s.removeElement(arr3, 1));
    }

    static class Solution {

        public int removeElement(int[] nums, int val) {
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }

    }

}
