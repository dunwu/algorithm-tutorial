package io.github.dunwu.algorithm.array.two_pointer;

import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/">75. 颜色分类</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-06
 */
public class 颜色分类 {

    public static void main(String[] args) {

        Solution s = new Solution();

        int[] nums1 = { 2, 0, 2, 1, 1, 0 };
        s.sortColors(nums1);
        Assertions.assertArrayEquals(new int[] { 0, 0, 1, 1, 2, 2 }, nums1);

        int[] nums2 = { 2, 0, 1 };
        s.sortColors(nums2);
        Assertions.assertArrayEquals(new int[] { 0, 1, 2 }, nums2);
    }

    static class Solution {

        public void sortColors(int[] nums) {
            moveToTail(nums, 1);
            System.out.println("nums = " + JSONUtil.toJsonStr(nums));
            moveToTail(nums, 2);
            System.out.println("nums = " + JSONUtil.toJsonStr(nums));
        }

        public void moveToTail(int[] nums, int val) {
            if (nums == null || nums.length == 0) { return; }
            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            for (int i = slow; i < nums.length; i++) {
                nums[i] = val;
            }
        }

    }

}
