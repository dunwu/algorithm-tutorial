package io.github.dunwu.algorithm.array.window;

import org.junit.jupiter.api.Assertions;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-iii/">220. 存在重复元素 III</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-15
 */
public class 存在重复元素III {

    public static void main(String[] args) {
        Assertions.assertTrue(containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));
        Assertions.assertFalse(containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));
        Assertions.assertTrue(containsNearbyAlmostDuplicate(new int[] { 1, 2, 2, 3, 4, 5 }, 3, 0));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> window = new TreeSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {

            // 窗口大小小于等于 indexDiff，且窗口中存在两个不同元素之差小于 valueDiff

            // 为了防止 i == j，所以在扩大窗口之前先判断是否有符合题意的索引对 (i, j)
            // 查找略大于 nums[right] 的那个元素
            Integer ceiling = window.ceiling(nums[right]);
            if (ceiling != null && Math.abs(ceiling - nums[right]) <= valueDiff) {
                return true;
            }
            // 查找略小于 nums[right] 的那个元素
            Integer floor = window.floor(nums[right]);
            if (floor != null && Math.abs(floor - nums[right]) <= valueDiff) {
                return true;
            }

            // 当窗口大小小于等于 indexDiff 时，扩大窗口
            window.add(nums[right++]);

            // 当窗口大小大于 indexDiff 时，缩小窗口
            while (right - left > indexDiff) {
                // 缩小窗口
                window.remove(nums[left++]);
            }
        }
        return false;
    }

}
