// 724. 寻找数组的中心下标
//
// 给你一个整数数组nums ，请计算数组的 中心下标 。
//
// 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
//
// 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
//
// 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
//
//
//
// 示例 1：
//
// 输入：nums = [1, 7, 3, 6, 5, 6]
// 输出：3
// 解释：
// 中心下标是 3 。
// 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
// 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
// 示例 2：
//
// 输入：nums = [1, 2, 3]
// 输出：-1
// 解释：
// 数组中不存在满足此条件的中心下标。
// 示例 3：
//
// 输入：nums = [2, 1, -1]
// 输出：0
// 解释：
// 中心下标是 0 。
// 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
// 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
//
// 提示：
//
// 1 <= nums.length <= 104
// -1000 <= nums[i] <= 1000
//
// 链接：https://leetcode-cn.com/problems/find-pivot-index

package io.github.dunwu.algorithm.array;

import org.junit.jupiter.api.Assertions;

/**
 * 724. 寻找数组的中心索引
 *
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 寻找数组的中心索引 {

    public static void main(String[] args) {
        Assertions.assertEquals(3, pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        Assertions.assertEquals(-1, pivotIndex(new int[] { 1, 2, 3 }));
        Assertions.assertEquals(0, pivotIndex(new int[] { 2, 1, -1 }));
    }

    public static int pivotIndex(int[] nums) {
        for (int pos = 0; pos < nums.length; pos++) {

            // pos 左侧所有元素累加
            int leftSum = 0;
            for (int left = 0; left < pos; left++) {
                leftSum += nums[left];
            }

            // pos 右侧所有元素累加
            int rightSum = 0;
            for (int right = nums.length - 1; right > pos; right--) {
                rightSum += nums[right];
            }

            if (leftSum == rightSum) {
                return pos;
            }
        }
        return -1;
    }

}
