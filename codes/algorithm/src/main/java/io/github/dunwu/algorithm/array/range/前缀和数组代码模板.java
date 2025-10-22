package io.github.dunwu.algorithm.array.range;

/**
 * 前缀和数组代码模板
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-20
 */
public class 前缀和数组代码模板 {

    /**
     * 一维前缀和
     */
    static class NumArray {

        // 前缀和数组
        private int[] preSum;

        // 输入一个数组，构造前缀和
        public NumArray(int[] nums) {
            // preSum[0] = 0，便于计算累加和
            preSum = new int[nums.length + 1];
            // 计算 nums 的累加和
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        // 查询闭区间 [left, right] 的累加和
        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }

    }

    /**
     * 二维前缀和
     */
    static class NumMatrix {

        // preSum[i][j] 记录矩阵 [0, 0, i-1, j-1] 的元素和
        private int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            if (m == 0 || n == 0) return;
            // 构造前缀和矩阵
            preSum = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    // 计算每个矩阵 [0, 0, i, j] 的元素和
                    preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + matrix[i - 1][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        // 计算子矩阵 [x1, y1, x2, y2] 的元素和
        public int sumRegion(int x1, int y1, int x2, int y2) {
            // 目标矩阵之和由四个相邻矩阵运算获得
            return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
        }

    }

}
