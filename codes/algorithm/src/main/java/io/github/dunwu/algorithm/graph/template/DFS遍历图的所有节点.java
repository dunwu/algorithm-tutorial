package io.github.dunwu.algorithm.graph.template;

import io.github.dunwu.algorithm.graph.Edge;
import io.github.dunwu.algorithm.graph.Graph;
import io.github.dunwu.algorithm.graph.Vertex;

/**
 * 图的遍历框架
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class DFS遍历图的所有节点 {

    // 遍历图的所有节点
    void traverse(Graph graph, int s, boolean[] visited) {
        // base case
        if (s < 0 || s >= graph.size()) {
            return;
        }
        if (visited[s]) {
            // 防止死循环
            return;
        }
        // 前序位置
        visited[s] = true;
        System.out.println("visit " + s);
        for (Edge e : graph.neighbors(s)) {
            traverse(graph, e.to, visited);
        }
        // 后序位置
    }

    // 图的遍历框架
    // 需要一个 visited 数组记录被遍历过的节点
    // 避免走回头路陷入死循环
    void traverse(Vertex s, boolean[] visited) {
        // base case
        if (s == null) {
            return;
        }
        if (visited[s.id]) {
            // 防止死循环
            return;
        }
        // 前序位置
        visited[s.id] = true;
        System.out.println("visit " + s.id);
        for (Vertex neighbor : s.neighbors) {
            traverse(neighbor, visited);
        }
        // 后序位置
    }

}
