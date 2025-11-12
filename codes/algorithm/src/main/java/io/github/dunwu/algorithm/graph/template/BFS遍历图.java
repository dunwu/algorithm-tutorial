package io.github.dunwu.algorithm.graph.template;

import io.github.dunwu.algorithm.graph.Edge;
import io.github.dunwu.algorithm.graph.Graph;
import io.github.dunwu.algorithm.graph.State;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的遍历框架
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class BFS遍历图 {

    // 图结构的 BFS 遍历，从节点 s 开始进行 BFS
    void bfs(Graph graph, int s) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            System.out.println("visit " + cur);
            for (Edge e : graph.neighbors(cur)) {
                if (visited[e.to]) {
                    continue;
                }
                q.offer(e.to);
                visited[e.to] = true;
            }
        }
    }

    // 从 s 开始 BFS 遍历图的所有节点，且记录遍历的步数
    void bfs2(Graph graph, int s) {
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
                for (Edge e : graph.neighbors(cur)) {
                    if (visited[e.to]) {
                        continue;
                    }
                    q.offer(e.to);
                    visited[e.to] = true;
                }
            }
            step++;
        }
    }

    // 图结构的 BFS 遍历，从节点 s 开始进行 BFS，且记录遍历步数（从起点 s 到当前节点的边的条数）
    // 每个节点自行维护 State 类，记录从 s 走来的遍历步数
    void bfs3(Graph graph, int s) {
        boolean[] visited = new boolean[graph.size()];
        Queue<State> q = new LinkedList<>();

        q.offer(new State(s, 0));
        visited[s] = true;

        while (!q.isEmpty()) {
            State state = q.poll();
            int node = state.node;
            int step = state.step;
            System.out.println("visit " + node + " with step " + step);
            for (Edge e : graph.neighbors(node)) {
                if (visited[e.to]) {
                    continue;
                }
                q.offer(new State(e.to, step + 1));
                visited[e.to] = true;
            }
        }
    }

}
