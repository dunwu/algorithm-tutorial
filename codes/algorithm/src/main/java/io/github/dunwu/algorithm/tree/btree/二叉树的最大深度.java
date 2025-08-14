package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.deserialize("[3,9,20,null,null,15,7]");
        Assertions.assertEquals(3, maxDepth(tree));
        Assertions.assertEquals(3, maxDepth2(tree));
    }

    // 分解递归
    public static int maxDepth(TreeNode root) {
        if (root == null) { return 0; }

        // 利用定义，计算左右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 根据左右子树的最大深度推出原二叉树的最大深度
        // 整棵树的最大深度等于左右子树的最大深度取最大值，
        // 然后再加上根节点自己
        return 1 + Math.max(leftMax, rightMax);
    }

    // 遍历递归

    public static int depth = 0;
    public static int max = 0;

    public static int maxDepth2(TreeNode root) {
        traverse(root);
        return max;
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;

        // 前序遍历位置（进入节点）增加深度
        depth++;
        // 遍历到叶子节点时记录最大深度
        if (root.left == null && root.right == null) {
            System.out.println("root = " + root.val + ", depth = " + depth);
            max = Math.max(max, depth);
        }
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置（离开节点）减少深度
        depth--;
    }

}
