package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 删除排序数组中的重复项II {

    public static void main(String[] args) {
        int[] nums1 = { 1, 1, 1, 2, 2, 3 };
        Assertions.assertEquals(5, removeDuplicates(nums1));

        int[] nums2 = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        Assertions.assertEquals(7, removeDuplicates(nums2));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int slow = 0, fast = 1;
        int count = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
                count = 0;
            } else {
                if (count == 0) {
                    slow++;
                    nums[slow] = nums[fast];
                    count++;
                }
            }
            fast++;
        }
        return slow + 1;
    }

}
