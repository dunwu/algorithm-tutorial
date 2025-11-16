package io.github.dunwu.algorithm.dp.fib;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

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
            int[] sums = new int[10001];
            for (int num : nums) {
                sums[num] += num;
            }
            return rob(sums);
        }

        public int rob(int[] sums) {
            if (sums == null || sums.length == 0) { return 0; }
            if (sums.length == 1) { return sums[0]; }
            int pre1 = Math.max(sums[0], sums[1]), pre2 = sums[0];
            int max = 0;
            for (int i = 2; i < sums.length; i++) {
                int tmp = Math.max(pre1, pre2 + sums[i]);
                max = Math.max(max, tmp);
                pre2 = pre1;
                pre1 = tmp;
            }
            return max;
        }

    }

}
