package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/complete-binary-tree-inserter/">919. 完全二叉树插入器</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 完全二叉树插入器 {

    public static void main(String[] args) {
        CBTInserter c = new CBTInserter(TreeNode.buildTree(1, 2));
        Assertions.assertEquals(1, c.insert(3));
        Assertions.assertEquals(2, c.insert(4));
        Assertions.assertEquals(TreeNode.buildTree(1, 2, 3, 4), c.get_root());
    }

    static class CBTInserter {

        private TreeNode root;
        private final LinkedList<TreeNode> unfull;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.unfull = new LinkedList<>();

            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(this.root);
            while (!q.isEmpty()) {
                for (int i = 0; i < q.size(); i++) {
                    TreeNode node = q.poll();
                    if (node.left != null) {
                        q.offer(node.left);
                    }
                    if (node.right != null) {
                        q.offer(node.right);
                    }
                    if (node.left == null || node.right == null) {
                        unfull.offer(node);
                    }
                }
            }
        }

        public int insert(int val) {
            if (root == null) {
                root = new TreeNode(val);
                return 0;
            }

            TreeNode parent = unfull.peek();
            TreeNode node = new TreeNode(val);
            if (parent.left == null) {
                parent.left = node;
            } else if (parent.right == null) {
                parent.right = node;
                unfull.poll();
            }
            unfull.offer(node);
            return parent.val;
        }

        public TreeNode get_root() {
            return this.root;
        }

    }

}
