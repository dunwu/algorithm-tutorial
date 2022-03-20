// 35. 搜索插入位置
//
// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 请必须使用时间复杂度为 O(log n) 的算法。
//
//
//
// 示例 1:
//
// 输入: nums = [1,3,5,6], target = 5
// 输出: 2
// 示例 2:
//
// 输入: nums = [1,3,5,6], target = 2
// 输出: 1
// 示例 3:
//
// 输入: nums = [1,3,5,6], target = 7
// 输出: 4
// 示例 4:
//
// 输入: nums = [1,3,5,6], target = 0
// 输出: 0
// 示例 5:
//
// 输入: nums = [1], target = 0
// 输出: 0
//
//
// 提示:
//
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums 为无重复元素的升序排列数组
// -104 <= target <= 104
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/search-insert-position

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
