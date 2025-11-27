package io.github.dunwu.algorithm.graph;

import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode.cn/problems/is-graph-bipartite/">785. 判断二分图</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 判断二分图 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = new int[][] {
            { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 }
        };
        Assertions.assertFalse(s.isBipartite(input));
    }

    static class Solution {

        // 记录图是否符合二分图性质
        private boolean ok = true;
        // 记录图中节点的颜色，false 和 true 代表两种不同颜色
        private boolean[] color;
        // 记录图中节点是否被访问过
        private boolean[] visited;

        // 主函数，输入邻接表，判断是否是二分图
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            color = new boolean[n];
            visited = new boolean[n];
            // 因为图不一定是联通的，可能存在多个子图
            // 所以要把每个节点都作为起点进行一次遍历
            // 如果发现任何一个子图不是二分图，整幅图都不算二分图
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    traverse(graph, v);
                }
            }
            return ok;
        }

        // DFS 遍历框架
        private void traverse(int[][] graph, int v) {
            // 如果已经确定不是二分图了，就不用浪费时间再递归遍历了
            if (!ok) return;

            visited[v] = true;
            for (int w : graph[v]) {
                if (!visited[w]) {
                    // 相邻节点 w 没有被访问过
                    // 那么应该给节点 w 涂上和节点 v 不同的颜色
                    color[w] = !color[v];
                    // 继续遍历 w
                    traverse(graph, w);
                } else {
                    // 相邻节点 w 已经被访问过
                    // 根据 v 和 w 的颜色判断是否是二分图
                    if (color[w] == color[v]) {
                        // 若相同，则此图不是二分图
                        ok = false;
                    }
                }
            }
        }

    }

}
