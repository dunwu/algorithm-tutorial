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
        TreeNode input1 = TreeNode.buildTree(5, 3, 6, 2, 4, null, 7);
        TreeNode output1 = deleteNode(input1, 3);
        Assertions.assertArrayEquals(new Integer[] { 5, 4, 6, 2, null, null, 7 },
            TreeNode.toValueList(output1).toArray());

        TreeNode input2 = TreeNode.buildTree(5, 3, 6, 2, 4, null, 7);
        TreeNode output2 = deleteNode(input2, 0);
        Assertions.assertArrayEquals(new Integer[] { 5, 3, 6, 2, 4, null, 7 },
            TreeNode.toValueList(output2).toArray());

        TreeNode input3 = TreeNode.buildTree();
        TreeNode output3 = deleteNode(input3, 0);
        Assertions.assertNull(output3);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) { return null; }
        if (key == root.val) {
            // 找到 key，进行处理

            if (root.left == null && root.right == null) {
                // 情况一、无孩子节点：直接删除
                return null;
            } else if (root.left != null && root.right == null) {
                // 情况二、有一个孩子节点：用孩子节点替换
                root = root.left;
            } else if (root.left == null && root.right != null) {
                // 情况二、有一个孩子节点：用孩子节点替换
                root = root.right;
            } else if (root.left != null && root.right != null) {
                // 情况三、有两个孩子节点：
                // 从左子树中找最大的节点替换根节点
                // 或从右子树中找最小的节点替换根节点
                TreeNode minRight = getMin(root.right);
                minRight.right = deleteNode(root.right, minRight.val);
                minRight.left = root.left;
                root = minRight;
            }
        } else if (key < root.val) {
            // 在左子树查找、处理
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // 在右子树查找、处理
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    static TreeNode getMin(TreeNode root) {
        if (root == null) { return null; }
        if (root.left == null) { return root; }
        return getMin(root.left);
    }

}
