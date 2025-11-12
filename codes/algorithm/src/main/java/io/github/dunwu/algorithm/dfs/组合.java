package io.github.dunwu.algorithm.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/">77. 组合</a>
 * <p>
 * 元素不可重复，不可复选
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-04
 */
public class 组合 {

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> output = s.combine(4, 2);
        System.out.println("output = " + output);
        // Assertions.assertArrayEquals();
    }

    static class Solution {

        // 记录回溯算法的递归路径
        LinkedList<Integer> track = null;
        List<List<Integer>> res = null;

        public List<List<Integer>> combine(int n, int k) {
            track = new LinkedList<>();
            res = new LinkedList<>();
            backtrack(1, n, k);
            return res;
        }

        public void backtrack(int start, int n, int len) {

            // 前序位置，每个节点的值都是一个子集
            if (track.size() == len) {
                res.add(new LinkedList<>(track));
                // System.out.printf("\t=> %s\n", res);
                return;
            }

            // 回溯算法标准框架
            for (int i = start; i <= n; i++) {
                // 做选择
                track.addLast(i);
                // 通过 start 参数控制树枝的遍历，避免产生重复的子集
                backtrack(i + 1, n, len);
                // 撤销选择
                track.removeLast();
            }
        }

    }

}
