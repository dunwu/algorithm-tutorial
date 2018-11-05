package io.github.dunwu.ds.array;

//    【长度最小的子数组】
//
//    给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
//
//    示例:
//
//    输入: s = 7, nums = [2,3,1,2,4,3]
//    输出: 2
//    解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
//    进阶:
//
//    如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。


/**
 * @author Zhang Peng
 * @date 2018-11-05
 */
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int j = 0, i = 0, sum = 0, min = Integer.MAX_VALUE;

        while (i < nums.length) {
            sum += nums[i++];

            while (sum >= s) {
                min = Math.min(min, i - j);
                sum -= nums[j++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
