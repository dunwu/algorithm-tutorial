package io.github.dunwu.algorithm.dp.fib;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/delete-and-earn/">740. 删除并获得点数</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-10
 */
public class 删除并获得点数 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(6, s.deleteAndEarn(new int[] { 3, 4, 2 }));
        // 删除 4 获得 4 个点数，因此 3 也被删除。
        // 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
        Assertions.assertEquals(9, s.deleteAndEarn(new int[] { 2, 2, 3, 3, 3, 4 }));
        // 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
        // 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
        // 总共获得 9 个点数。
    }

    static class Solution {

        public int deleteAndEarn(int[] nums) {
            int max = 0;
            for (int val : nums) {
                max = Math.max(max, val);
            }
            int[] sums = new int[max + 1];
            for (int val : nums) {
                sums[val] += val;
            }
            return rob(sums);
        }

        public int rob(int[] sums) {
            int N = sums.length;
            int first = sums[0], second = Math.max(sums[0], sums[1]);
            for (int i = 2; i < N; i++) {
                int temp = second;
                second = Math.max(second, first + sums[i]);
                first = temp;
            }
            return second;
        }

    }

}
