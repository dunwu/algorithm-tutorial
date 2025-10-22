package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/">701. 二叉搜索树中的插入操作</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉搜索树中的插入操作 {

    public static void main(String[] args) {
        TreeNode input1 = TreeNode.buildTree(4, 2, 7, 1, 3);
        TreeNode output1 = insertIntoBST(input1, 5);
        Assertions.assertArrayEquals(new Integer[] { 4, 2, 7, 1, 3, 5 }, TreeNode.toValueList(output1).toArray());

        TreeNode input2 = TreeNode.buildTree(40, 20, 60, 10, 30, 50, 70);
        TreeNode output2 = insertIntoBST(input2, 25);
        Assertions.assertArrayEquals(new Integer[] { 40, 20, 60, 10, 30, 50, 70, null, null, 25 },
            TreeNode.toValueList(output2).toArray());

        TreeNode input3 = TreeNode.buildTree(4, 2, 7, 1, 3, null, null, null, null, null, null);
        TreeNode output3 = insertIntoBST(input3, 5);
        Assertions.assertArrayEquals(new Integer[] { 4, 2, 7, 1, 3, 5 },
            TreeNode.toValueList(output3).toArray());
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) { return new TreeNode(val); }
        if (root.val < val) {
            root.right = (root.right == null) ? new TreeNode(val) : insertIntoBST(root.right, val);
        } else {
            root.left = (root.left == null) ? new TreeNode(val) : insertIntoBST(root.left, val);
        }
        return root;
    }

}
