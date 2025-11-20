package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/">80. 删除有序数组中的重复项 II</a>
 *
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class 删除排序数组中的重复项2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(5, s.removeDuplicates(new int[] { 1, 1, 1, 2, 2, 3 }));
        Assertions.assertEquals(7, s.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 1, 2, 3, 3 }));
    }

    static class Solution {

        public int removeDuplicates(int[] nums) {
            int slow = 0, fast = 1;
            int cnt = 1;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    cnt = 1;
                    slow++;
                    nums[slow] = nums[fast];
                } else {
                    if (cnt < 2) {
                        slow++;
                        nums[slow] = nums[fast];
                    }
                    cnt++;
                }
                fast++;
            }
            // System.out.printf("slow: %d, fast: %d, nums: %s\n", slow, fast,
            //     JSONUtil.toJsonStr(ArrayUtil.sub(nums, 0, slow + 1)));
            return slow + 1;
        }

    }

}
