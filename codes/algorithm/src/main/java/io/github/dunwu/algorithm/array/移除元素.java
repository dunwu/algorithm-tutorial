package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/remove-element/">27. 移除元素</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2018-11-05
 */
public class 移除元素 {

    public static void main(String[] args) {
        int[] nums1 = { 3, 2, 2, 3 };
        Assertions.assertEquals(2, removeElement(nums1, 3));

        int[] nums2 = { 0, 1, 2, 2, 3, 0, 4, 2 };
        Assertions.assertEquals(5, removeElement(nums2, 2));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
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
