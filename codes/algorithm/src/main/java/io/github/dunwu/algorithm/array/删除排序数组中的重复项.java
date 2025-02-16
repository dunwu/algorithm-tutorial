package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/">26. 删除有序数组中的重复项</a>
 *
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        int[] nums1 = { 1, 1, 2 };
        Assertions.assertEquals(2, removeDuplicates(nums1));

        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        Assertions.assertEquals(5, removeDuplicates(nums2));

        int[] nums3 = { 1, 2 };
        Assertions.assertEquals(2, removeDuplicates(nums3));

        int[] nums4 = { 2, 2 };
        Assertions.assertEquals(1, removeDuplicates(nums4));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

}
