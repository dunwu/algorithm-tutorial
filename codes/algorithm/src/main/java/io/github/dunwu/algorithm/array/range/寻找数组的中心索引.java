package io.github.dunwu.algorithm.array.range;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/find-pivot-index">724. 寻找数组的中心索引</a>
 *
 * @author Zhang Peng
 * @since 2018-11-04
 */
public class 寻找数组的中心索引 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(3, s.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        Assertions.assertEquals(-1, s.pivotIndex(new int[] { 1, 2, 3 }));
        Assertions.assertEquals(0, s.pivotIndex(new int[] { 2, 1, -1 }));

        Solution2 s2 = new Solution2();
        Assertions.assertEquals(3, s2.pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));
        Assertions.assertEquals(-1, s2.pivotIndex(new int[] { 1, 2, 3 }));
        Assertions.assertEquals(0, s2.pivotIndex(new int[] { 2, 1, -1 }));
    }

    static class Solution {

        public int pivotIndex(int[] nums) {
            for (int mid = 0; mid < nums.length; mid++) {
                int leftSum = 0, rightSum = 0;
                for (int i = 0; i < mid; i++) {
                    leftSum += nums[i];
                }
                for (int i = mid + 1; i < nums.length; i++) {
                    rightSum += nums[i];
                }
                if (leftSum == rightSum) {
                    return mid;
                }
            }
            return -1;
        }

    }

    static class Solution2 {

        public int pivotIndex(int[] nums) {
            int total = 0;
            for (int num : nums) {
                total += num;
            }

            int leftSum = 0;
            for (int i = 0; i < nums.length; i++) {
                int rightSum = total - leftSum - nums[i];
                if (leftSum == rightSum) {
                    return i;
                }
                leftSum += nums[i];
            }
            return -1;
        }

    }

}
