package io.github.dunwu.algorithm.graph.template;

import io.github.dunwu.algorithm.graph.Edge;
import io.github.dunwu.algorithm.graph.Graph;
import io.github.dunwu.algorithm.graph.Vertex;
import io.github.dunwu.algorithm.tree.Node;

/**
 * DFS遍历图的所有边
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-06
 */
public class DFS遍历图的所有边 {

    // 遍历多叉树的树枝
    void traverseBranch(Node root) {
        // base case
        if (root == null) { return; }
        for (Node child : root.children) {
            System.out.println("visit branch: " + root.val + " -> " + child.val);
            traverseBranch(child);
        }
    }

    // 遍历图的边
    // 需要一个二维 visited 数组记录被遍历过的边，visited[from][to] 表示边 from->to 已经被遍历过
    void traverseEdges(Vertex v, boolean[][] visited) {
        // base case
        if (v == null) { return; }
        for (Vertex neighbor : v.neighbors) {
            // 如果边已经被遍历过，则跳过
            if (visited[v.id][neighbor.id]) { continue; }
            // 标记并访问边
            visited[v.id][neighbor.id] = true;
            System.out.println("visit edge: " + v.id + " -> " + neighbor.id);
            traverseEdges(neighbor, visited);
        }
    }

    // 从起点 s 开始遍历图的所有边
    void traverseEdges(Graph graph, int s, boolean[][] visited) {
        // base case
        if (s < 0 || s >= graph.size()) { return; }
        for (Edge e : graph.neighbors(s)) {
            // 如果边已经被遍历过，则跳过
            if (visited[s][e.to]) { continue; }
            // 标记并访问边
            visited[s][e.to] = true;
            System.out.println("visit edge: " + s + " -> " + e.to);
            traverseEdges(graph, e.to, visited);
        }
    }

}
