package io.github.dunwu.algorithm.dfs;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/beautiful-arrangement/">526. 优美的排列</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-12
 */
public class 优美的排列 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertEquals(1, s.countArrangement(1));
        Assertions.assertEquals(2, s.countArrangement(2));
    }

    static class Solution {

        // 记录所有的「优美排列」的个数
        private int res = 0;
        // track 中的元素会被标记为 true，避免重复选择
        private boolean[] visited;
        // 记录回溯算法的递归路径，即每个索引选择的元素
        private LinkedList<Integer> path;

        public int countArrangement(int n) {
            res = 0;
            visited = new boolean[n + 1];
            path = new LinkedList<>();
            dfs(n, 1);
            return res;
        }

        // 回溯算法标准框架，站在索引的视角选择元素
        void dfs(int n, int index) {
            // base case，到达叶子节点
            if (index > n) {
                // 找到一个结果
                res += 1;
                return;
            }

            // 索引 index 开始选择元素
            for (int val = 1; val <= n; val++) {
                // 已经被其他索引选过的元素，不能重复选择
                if (visited[val]) {
                    continue;
                }
                if (!(index % val == 0 || val % index == 0)) {
                    continue;
                }
                // 【选择】index 选择元素 elem
                visited[val] = true;
                path.addLast(val);
                // 【回溯】
                dfs(n, index + 1);
                // 【取消选择】
                path.removeLast();
                visited[val] = false;
            }
        }

    }

}
