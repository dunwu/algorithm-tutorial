package io.github.dunwu.algorithm.graph.dfs;

import cn.hutool.core.collection.CollectionUtil;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/all-paths-from-source-to-target/">797. 所有可能的路径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 所有可能的路径 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = new int[][] {
            { 1, 2 }, { 3 }, { 3 }, {}
        };
        List<List<Integer>> expect = new LinkedList<>();
        expect.add(Arrays.asList(0, 1, 3));
        expect.add(Arrays.asList(0, 2, 3));
        List<List<Integer>> output = s.allPathsSourceTarget(input);
        for (int i = 0; i < expect.size(); i++) {
            Assertions.assertArrayEquals(expect.get(i).toArray(), output.get(i).toArray());
        }
        // System.out.println("v = " + output);
    }

    static class Solution {
        // 记录所有路径
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            dfs(graph, 0);
            return res;
        }

        // 图的遍历框架
        void dfs(int[][] graph, int s) {

            // 添加节点 s 到路径
            path.addLast(s);

            int n = graph.length;
            if (s == n - 1) {
                // 到达终点
                System.out.println("find path: " + CollectionUtil.join(path, "->"));
                res.add(new LinkedList<>(path));
                path.removeLast();
                return;
            }

            // 递归每个相邻节点
            for (int v : graph[s]) {
                dfs(graph, v);
            }

            // 从路径移出节点 s
            path.removeLast();
        }

    }

}
