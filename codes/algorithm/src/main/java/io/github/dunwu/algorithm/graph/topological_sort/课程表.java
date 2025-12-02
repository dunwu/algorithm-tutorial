package io.github.dunwu.algorithm.graph.topological_sort;

import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/course-schedule/">207. 课程表</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 课程表 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = new int[][] { { 1, 0 } };
        int[][] input2 = new int[][] { { 1, 0 }, { 0, 1 } };
        Assertions.assertTrue(s.canFinish(2, input));
        Assertions.assertFalse(s.canFinish(2, input2));
    }

    static class Solution {

        // 记录递归堆栈中的节点
        boolean[] onPath;
        // 记录节点是否被遍历过
        boolean[] visited;
        // 记录图中是否有环
        boolean hasCycle = false;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = buildGraph(numCourses, prerequisites);

            onPath = new boolean[numCourses];
            visited = new boolean[numCourses];

            for (int i = 0; i < numCourses; i++) {
                // 遍历图中的所有节点
                dfs(graph, i);
            }
            // 只要没有循环依赖可以完成所有课程
            return !hasCycle;
        }

        // 图遍历函数，遍历所有路径
        void dfs(List<Integer>[] graph, int s) {
            if (hasCycle) {
                // 如果已经找到了环，也不用再遍历了
                return;
            }

            if (onPath[s]) {
                // s 已经在递归路径上，说明成环了
                hasCycle = true;
                return;
            }

            if (visited[s]) {
                // 不用再重复遍历已遍历过的节点
                return;
            }

            // 前序代码位置
            visited[s] = true;
            onPath[s] = true;
            for (int t : graph[s]) {
                dfs(graph, t);
            }
            // 后序代码位置
            onPath[s] = false;
        }

        List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
            // 图中共有 numCourses 个节点
            List<Integer>[] graph = new LinkedList[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new LinkedList<>();
            }
            for (int[] edge : prerequisites) {
                int from = edge[1], to = edge[0];
                // 添加一条从 from 指向 to 的有向边
                // 边的方向是「被依赖」关系，即修完课程 from 才能修课程 to
                graph[from].add(to);
            }
            return graph;
        }

    }

}
