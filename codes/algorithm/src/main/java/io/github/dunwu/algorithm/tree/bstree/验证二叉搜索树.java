package io.github.dunwu.algorithm.tree.bstree;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <code>98. 验证二叉搜索树</code> 算法实现
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @see <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">98. 验证二叉搜索树</a>
 * @since 2020-07-02
 */
public class 验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(2, 1, 3);
        TreeNode root2 = TreeNode.buildTree(5, 1, 4, null, null, 3, 6);
        TreeNode root3 = TreeNode.buildTree(1, 1);

        Assertions.assertTrue(isValidBST(root));
        Assertions.assertFalse(isValidBST(root2));
        Assertions.assertFalse(isValidBST(root3));
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    static boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) { return true; }
        // BST 树中，任意节点的值应该大于所有左子树节点，小于所有右子树节点
        if (min != null && root.val <= min) { return false; }
        if (max != null && root.val >= max) { return false; }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }

}
