package io.github.dunwu.algorithm.array.two_pointer;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 *
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(2, s.removeDuplicates(new int[] { 1, 1, 2 }));
        Assertions.assertEquals(5, s.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
        Assertions.assertEquals(2, s.removeDuplicates(new int[] { 1, 2 }));
        Assertions.assertEquals(1, s.removeDuplicates(new int[] { 2, 2 }));
    }

    static class Solution {

        public int removeDuplicates(int[] nums) {
            int slow = 0, fast = 1;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow + 1;
        }

    }

}
