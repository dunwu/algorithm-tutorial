package io.github.dunwu.algorithm.graph.topological_sort;

import org.junit.jupiter.api.Assertions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/course-schedule-ii/">210. 课程表 II</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 课程表2 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertArrayEquals(new int[] { 0, 1 }, s.findOrder(2, new int[][] { { 1, 0 } }));
        Assertions.assertArrayEquals(new int[] { 0, 2, 1, 3 },
            s.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }));

        Solution2 s2 = new Solution2();
        Assertions.assertArrayEquals(new int[] { 0, 1 }, s2.findOrder(2, new int[][] { { 1, 0 } }));
        Assertions.assertArrayEquals(new int[] { 0, 1, 2, 3 },
            s2.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } }));
    }

    // 拓扑排序算法（DFS 版本）
    static class Solution {

        // 记录后序遍历结果
        private List<Integer> preorder;
        // 记录一次递归堆栈中的节点
        boolean[] onPath;
        // 记录节点是否被遍历过
        boolean[] visited;
        // 记录图中是否有环
        boolean hasCycle = false;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            preorder = new LinkedList<>();
            visited = new boolean[numCourses];
            onPath = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                dfs(graph, i);
            }

            // 有环图无法进行拓扑排序
            if (hasCycle) { return new int[0]; }

            // 逆后序遍历结果即为拓扑排序结果
            Collections.reverse(preorder);
            int[] order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = preorder.get(i);
            }
            return order;
        }

        public void dfs(List<Integer>[] graph, int s) {
            // 找到环，或已访问，则无需再遍历
            if (onPath[s]) { hasCycle = true; }
            if (hasCycle || visited[s]) { return; }

            // 【前序】
            visited[s] = true;
            onPath[s] = true;
            for (int t : graph[s]) {
                dfs(graph, t);
            }
            // 【后序】
            preorder.add(s);
            onPath[s] = false;
        }

        public List<Integer>[] buildGraph(int n, int[][] data) {
            List<Integer>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int[] edge : data) {
                int from = edge[1], to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }

    }

    // 拓扑排序算法（BFS 版本）
    static class Solution2 {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // 建图，和环检测算法相同
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);
            // 计算入度，和环检测算法相同
            int[] indegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                indegree[to]++;
            }

            // 根据入度初始化队列中的节点，和环检测算法相同
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            // 记录拓扑排序结果
            int[] res = new int[numCourses];
            // 记录遍历节点的顺序（索引）
            int count = 0;
            // 开始执行 BFS 算法
            while (!q.isEmpty()) {
                int cur = q.poll();
                // 弹出节点的顺序即为拓扑排序结果
                res[count] = cur;
                count++;
                for (int next : graph[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            // 存在环，拓扑排序不存在
            if (count != numCourses) {
                return new int[0];
            }
            return res;
        }

        public List<Integer>[] buildGraph(int n, int[][] data) {
            List<Integer>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int[] edge : data) {
                int from = edge[1], to = edge[0];
                graph[from].add(to);
            }
            return graph;
        }

    }

}
