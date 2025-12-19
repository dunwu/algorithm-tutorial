package io.github.dunwu.algorithm.bfs.template;

import io.github.dunwu.algorithm.graph.Edge;
import io.github.dunwu.algorithm.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS 算法模板
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-12-15
 */
public class BFS算法模板 {

    private Graph graph;

    // 从 s 开始 BFS 遍历图的所有节点，且记录遍历的步数
    // 当走到目标节点 target 时，返回步数
    int bfs(int s, int target) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;
        // 记录从 s 开始走到当前节点的步数
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                System.out.println("visit " + cur + " at step " + step);
                // 判断是否到达终点
                if (cur == target) {
                    return step;
                }
                // 将邻居节点加入队列，向四周扩散搜索
                for (Edge e : graph.neighbors(cur)) {
                    if (!visited[e.to]) {
                        q.offer(e.to);
                        visited[e.to] = true;
                    }
                }
            }
            step++;
        }
        // 如果走到这里，说明在图中没有找到目标节点
        return -1;
    }

}
