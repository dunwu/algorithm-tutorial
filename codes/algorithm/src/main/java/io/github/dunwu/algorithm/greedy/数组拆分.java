package io.github.dunwu.algorithm.greedy;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/array-partition/">561. 数组拆分</a>
 *
 * @author Zhang Peng
 * @since 2018-11-05
 */
public class 数组拆分 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(4, s.arrayPairSum(new int[] { 1, 4, 3, 2 }));
        Assertions.assertEquals(9, s.arrayPairSum(new int[] { 6, 2, 6, 5, 1, 2 }));
    }

    static class Solution {


        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i+=2) {
                sum += nums[i];
            }
            return sum;
        }

    }

}
