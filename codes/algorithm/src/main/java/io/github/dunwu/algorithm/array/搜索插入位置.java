package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/search-insert-position/">搜索插入位置</a>
 * @since 2020-07-29
 */
public class 搜索插入位置 {

    public static void main(String[] args) {
        Assertions.assertEquals(0, searchInsert(new int[] { 1 }, 1));
        Assertions.assertEquals(2, searchInsert(new int[] { 1, 3, 5, 6 }, 5));
        Assertions.assertEquals(1, searchInsert(new int[] { 1, 3, 5, 6 }, 2));
        Assertions.assertEquals(4, searchInsert(new int[] { 1, 3, 5, 6 }, 7));
        Assertions.assertEquals(0, searchInsert(new int[] { 1, 3, 5, 6 }, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (nums[0] >= target) return 0;
        if (nums[nums.length - 1] < target) return nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

}
