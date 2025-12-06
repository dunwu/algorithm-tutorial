package io.github.dunwu.algorithm.array.range;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum/">1013.将数组分成和相等的三个部分</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-06-05
 */
public class 将数组分成和相等的三个部分 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1 }));
        Assertions.assertTrue(s.canThreePartsEqualSum(new int[] { 3, 3, 6, 5, -2, 2, 5, 1, -9, 4 }));
        Assertions.assertFalse(s.canThreePartsEqualSum(new int[] { 0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1 }));
    }

    static class Solution {

        public boolean canThreePartsEqualSum(int[] arr) {
            int n = arr.length;
            NumArray preSum = new NumArray(arr);
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int leftSum = preSum.sumRange(0, i - 1);
                    int midSum = preSum.sumRange(i, j - 1);
                    int rightSum = preSum.sumRange(j, n - 1);
                    if (leftSum == midSum && midSum == rightSum) {
                        return true;
                    }
                }
            }
            return false;
        }

        static class NumArray {

            private final int[] preSum;

            public NumArray(int[] arr) {
                preSum = new int[arr.length + 1];
                preSum[0] = 0;
                for (int i = 1; i <= arr.length; i++) {
                    preSum[i] = preSum[i - 1] + arr[i - 1];
                }
            }

            public int sumRange(int left, int right) {
                return preSum[right + 1] - preSum[left];
            }

        }

    }

}
