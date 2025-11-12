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
        private final LinkedList<TreeNode> candidate;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.candidate = new LinkedList<>();

            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    if (node.left == null || node.right == null) {
                        candidate.offer(node);
                    }
                }
            }
        }

        public int insert(int val) {
            TreeNode child = new TreeNode(val);
            TreeNode node = candidate.peek();
            if (node.left == null) {
                node.left = child;
            } else {
                node.right = child;
                candidate.poll();
            }
            candidate.offer(child);
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }

    }

}
