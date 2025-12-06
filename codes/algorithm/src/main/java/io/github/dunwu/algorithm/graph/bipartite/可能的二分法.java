package io.github.dunwu.algorithm.graph.bipartite;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/possible-bipartition/">886. 可能的二分法</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 可能的二分法 {

    public static void main(String[] args) {

        int[][] input = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } };
        int[][] input2 = new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } };
        int[][] input3 = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } };

        Solution s = new Solution();
        Assertions.assertTrue(s.possibleBipartition(4, input));
        Assertions.assertFalse(s.possibleBipartition(3, input2));
        Assertions.assertFalse(s.possibleBipartition(5, input3));
    }

    static class Solution {

        private boolean ok = true;
        private boolean[] color;
        private boolean[] visited;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            // 图节点编号从 1 开始
            color = new boolean[n + 1];
            visited = new boolean[n + 1];

            // 转化成邻接表图结构
            List<Integer>[] graph = buildGraph(n, dislikes);

            for (int v = 1; v <= n; v++) {
                if (!visited[v]) {
                    dfs(graph, v);
                }
            }

            return ok;
        }

        public void dfs(List<Integer>[] graph, int v) {
            if (!ok) return;
            visited[v] = true;
            for (int w : graph[v]) {
                if (!visited[w]) {
                    color[w] = !color[v];
                    dfs(graph, w);
                } else {
                    if (color[w] == color[v]) {
                        ok = false;
                    }
                }
            }
        }

        public List<Integer>[] buildGraph(int n, int[][] data) {
            List<Integer>[] graph = new LinkedList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int[] edge : data) {
                int v = edge[1], w = edge[0];
                graph[v].add(w);
                graph[w].add(v);
            }
            return graph;
        }

    }

}
