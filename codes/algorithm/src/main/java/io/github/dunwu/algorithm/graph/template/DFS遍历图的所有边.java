package io.github.dunwu.algorithm.graph.template;

import io.github.dunwu.algorithm.tree.Node;
import io.github.dunwu.algorithm.graph.Vertex;

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
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            System.out.println("visit branch: " + root.val + " -> " + child.val);
            traverseBranch(child);
        }
    }

    // 遍历图的边
    // 需要一个二维 visited 数组记录被遍历过的边，visited[u][v] 表示边 u->v 已经被遍历过
    void traverseEdges(Vertex s, boolean[][] visited) {
        // base case
        if (s == null) {
            return;
        }
        for (Vertex neighbor : s.neighbors) {
            // 如果边已经被遍历过，则跳过
            if (visited[s.id][neighbor.id]) {
                continue;
            }
            // 标记并访问边
            visited[s.id][neighbor.id] = true;
            System.out.println("visit edge: " + s.id + " -> " + neighbor.id);
            traverseEdges(neighbor, visited);
        }
    }

}
