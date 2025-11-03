package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/">701. 二叉搜索树中的插入操作</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 删除二叉搜索树中的节点 {

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode output1 = s.deleteNode(TreeNode.buildTree(5, 3, 6, 2, 4, null, 7), 3);
        Assertions.assertEquals(TreeNode.buildTree(5, 4, 6, 2, null, null, 7), output1);

        TreeNode output2 = s.deleteNode(TreeNode.buildTree(5, 3, 6, 2, 4, null, 7), 0);
        Assertions.assertEquals(TreeNode.buildTree(5, 3, 6, 2, 4, null, 7), output2);

        Assertions.assertNull(s.deleteNode(TreeNode.buildTree(), 0));
    }

    static class Solution {

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) { return null; }

            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else {
                if (root.left == null) { return root.right; }
                if (root.right == null) { return root.left; }
                TreeNode minRightNode = getMin(root.right);
                root.right = deleteNode(root.right, minRightNode.val);
                minRightNode.left = root.left;
                minRightNode.right = root.right;
                root = minRightNode;
            }
            return root;
        }

        public TreeNode getMin(TreeNode root) {
            if (root == null) { return null; }
            if (root.left == null) {
                return root;
            }
            return getMin(root.left);
        }

    }

}
