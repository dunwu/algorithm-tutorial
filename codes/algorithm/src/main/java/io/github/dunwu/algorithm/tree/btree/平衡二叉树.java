package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 平衡二叉树 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.asTree(3, 9, 20, null, null, 15, 7);
        TreeNode tree2 = TreeUtils.asTree(1, 2, 2, 3, 3, null, null, 4, 4);
        TreeNode tree3 = TreeUtils.asTree(null);
        平衡二叉树 demo = new 平衡二叉树();
        Assertions.assertTrue(demo.isBalanced(tree));
        Assertions.assertFalse(demo.isBalanced(tree2));
        Assertions.assertTrue(demo.isBalanced(tree3));
    }

    private boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        backtrack(root);
        return flag;
    }

    public int backtrack(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = backtrack(root.left);
        int right = backtrack(root.right);
        int temp = left - right;
        if (temp > 1 || temp < -1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }

}
