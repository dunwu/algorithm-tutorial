package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/numbers-with-same-consecutive-differences/">967. 连续差相同的数字</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-05
 */
public class 连续差相同的数字 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 181, 292, 707, 818, 929 }, s.numsSameConsecDiff(3, 7));
        Assertions.assertArrayEquals(new int[] { 10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98 },
            s.numsSameConsecDiff(2, 1));
        Assertions.assertArrayEquals(new int[] { 11, 22, 33, 44, 55, 66, 77, 88, 99 }, s.numsSameConsecDiff(2, 0));
        Assertions.assertArrayEquals(new int[] { 13, 20, 24, 31, 35, 42, 46, 53, 57, 64, 68, 75, 79, 86, 97 },
            s.numsSameConsecDiff(2, 2));
    }

    static class Solution {

        // 记录当前路径组成的数字的值
        private int num = 0;
        // 记录当前数字的位数
        private int digit = 0;
        private List<Integer> res;

        public int[] numsSameConsecDiff(int n, int k) {

            num = 0;
            digit = 0;
            res = new LinkedList<>();

            dfs(n, k);

            int[] arr = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                arr[i] = res.get(i);
            }
            return arr;
        }

        // 回溯算法核心函数
        void dfs(int n, int k) {
            // base case，到达叶子节点
            if (digit == n) {
                // 找到一个合法的 n 位数
                res.add(num);
                return;
            }

            // 回溯算法标准框架
            for (int i = 0; i <= 9; i++) {
                // 本题的剪枝逻辑 1，第一个数字不能是 0
                if (digit == 0 && i == 0) continue;
                // 本题的剪枝逻辑 2，相邻两个数字的差的绝对值必须等于 k
                if (digit > 0 && Math.abs(i - num % 10) != k) continue;

                // 做选择，在 track 尾部追加数字 i
                digit++;
                num = 10 * num + i;
                // 进入下一层回溯树
                dfs(n, k);
                // 取消选择，删除 track 尾部数字
                num = num / 10;
                digit--;
            }
        }

    }

}
