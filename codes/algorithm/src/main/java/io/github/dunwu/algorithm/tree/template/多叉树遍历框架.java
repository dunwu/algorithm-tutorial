package io.github.dunwu.algorithm.tree.template;

import io.github.dunwu.algorithm.tree.Node;
import io.github.dunwu.algorithm.tree.State;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 多叉树遍历框架
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-03
 */
public class 多叉树遍历框架 {

    // 多叉树的遍历框架
    void dfs(Node root) {
        // base case
        if (root == null) {
            return;
        }
        // 前序位置
        System.out.println("visit " + root.val);
        for (Node child : root.children) {
            dfs(child);
        }
        // 后序位置
    }

    void bfs(Node root) {
        // base case
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            // 访问 cur 节点
            System.out.println(node.val);

            // 把 cur 的所有子节点加入队列
            for (Node child : node.children) {
                q.offer(child);
            }
        }
    }

    // 记录遍历步数的写法
    void bfs2(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        // 记录当前遍历到的层数（根节点视为第 1 层）
        int depth = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                // 访问 cur 节点，同时知道它所在的层数
                System.out.println("depth = " + depth + ", val = " + node.val);

                for (Node child : node.children) {
                    q.offer(child);
                }
            }
            depth++;
        }
    }

    // 每个节点自行维护 State 类，记录深度等信息
    void bfs3(Node root) {
        if (root == null) {
            return;
        }
        Queue<State> q = new LinkedList<>();
        // 记录当前遍历到的层数（根节点视为第 1 层）
        q.offer(new State(root, 1));

        while (!q.isEmpty()) {
            State state = q.poll();
            Node node = state.node;
            int depth = state.depth;
            // 访问 cur 节点，同时知道它所在的层数
            System.out.println("depth = " + depth + ", val = " + node.val);

            for (Node child : node.children) {
                q.offer(new State(child, depth + 1));
            }
        }
    }

}
