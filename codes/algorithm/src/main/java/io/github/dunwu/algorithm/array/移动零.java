package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/">283. 移动零</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2018-11-05
 */
public class 移动零 {

    public static void main(String[] args) {
        int[] nums1 = { 0, 1, 0, 3, 12 };
        moveZeroes(nums1);
        Assertions.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, nums1);

        int[] nums2 = { 0, 0, 1 };
        moveZeroes(nums2);
        Assertions.assertArrayEquals(new int[] { 1, 0, 0 }, nums2);

        int[] nums3 = { 0 };
        moveZeroes(nums3);
        Assertions.assertArrayEquals(new int[] { 0 }, nums3);
    }

    public static void moveZeroes(int[] nums) {
        int pos = 移除元素.removeElement(nums, 0);
        while (pos < nums.length) {
            nums[pos] = 0;
            pos++;
        }
    }

    /**
     * 时间复杂度：O(N^2)
     */
    public static void moveZeroes2(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int slow = 0;
        while (slow < nums.length) {
            if (nums[slow] == 0) {
                int fast = slow + 1;
                while (fast < nums.length && nums[fast] == 0) {
                    fast++;
                }
                if (fast >= nums.length) {
                    break;
                }
                replacePos(nums, slow, fast);
            }
            slow++;
        }
    }

    private static void replacePos(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
