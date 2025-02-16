package io.github.dunwu.algorithm.array;

//    【移动零】

//
//    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//    示例:
//
//    输入: [0,1,0,3,12]
//    输出: [1,3,12,0,0]
//    说明:
//
//    必须在原数组上操作，不能拷贝额外的数组。
//    尽量减少操作次数。

import org.junit.jupiter.api.Assertions;

/**
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class 移动零 {

    public static void main(String[] args) {
        int[] nums1 = { 0, 1, 0, 3, 12 };
        moveZeroes2(nums1);
        Assertions.assertArrayEquals(new int[] { 1, 3, 12, 0, 0 }, nums1);

        int[] nums2 = { 0, 0, 1 };
        moveZeroes2(nums2);
        Assertions.assertArrayEquals(new int[] { 1, 0, 0 }, nums2);

        int[] nums3 = { 0 };
        moveZeroes2(nums3);
        Assertions.assertArrayEquals(new int[] { 0 }, nums3);
    }

    /**
     * 时间复杂度：O(N^2)
     */
    public static void moveZeroes(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] == 0) {
                move(nums, left);
                left = 0;
                right--;
            } else {
                left++;
            }
        }
    }

    private static void move(int[] nums, int pos) {
        for (int i = pos; i < nums.length - 1; i++) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
    }

    /**
     * 时间复杂度：O(N)
     */
    public static void moveZeroes2(int[] nums) {
        int count = removeElement(nums, 0);
        while (count < nums.length) {
            nums[count++] = 0;
        }
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
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
