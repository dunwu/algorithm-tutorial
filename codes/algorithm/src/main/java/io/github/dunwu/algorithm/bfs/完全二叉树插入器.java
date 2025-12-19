package io.github.dunwu.algorithm.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/complete-binary-tree-inserter/">919. 完全二叉树插入器</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-11-07
 */
public class 完全二叉树插入器 {

    public static void main(String[] args) {
        CBTInserter c = new CBTInserter(TreeNode.buildTree(1, 2));
        Assertions.assertEquals(1, c.insert(3));
        Assertions.assertEquals(2, c.insert(4));
        Assertions.assertEquals(TreeNode.buildTree(1, 2, 3, 4), c.get_root());
    }

    static class CBTInserter {

        private final TreeNode root;
        // 这个队列只记录完全二叉树底部可以进行插入的节点
        private final LinkedList<TreeNode> queue;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.queue = new LinkedList<>();
            LinkedList<TreeNode> tmp = new LinkedList<>();
            tmp.offer(root);
            while (!tmp.isEmpty()) {
                int size = tmp.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = tmp.poll();
                    if (node == null) { continue; }
                    if (node.left != null) { tmp.offer(node.left); }
                    if (node.right != null) { tmp.offer(node.right); }
                    if (node.left == null || node.right == null) {
                        // 找到完全二叉树底部可以进行插入的节点
                        queue.offer(node);
                    }
                }
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            TreeNode cur = queue.peek();
            queue.offer(node);
            if (cur.left == null) {
                cur.left = node;
            } else if (cur.right == null) {
                cur.right = node;
                queue.poll();
            }
            return cur.val;
        }

        public TreeNode get_root() {
            return this.root;
        }

    }

}
