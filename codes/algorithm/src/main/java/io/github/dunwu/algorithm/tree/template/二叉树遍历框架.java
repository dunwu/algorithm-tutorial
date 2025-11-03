package io.github.dunwu.algorithm.tree.template;

import io.github.dunwu.algorithm.tree.TreeNode;

/**
 * 二叉树递归遍历框架
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-10-23
 */
public class 二叉树遍历框架 {

    /**
     * 二叉树的遍历框架
     */
    public void traverse(TreeNode root) {
        // 【校验】
        if (root == null) { return; }
        // 【前序】
        System.out.printf("[node -> left]从节点 %s 进入节点 %s\n", root, root.left);
        traverse(root.left);
        // 【中序】
        System.out.printf("\t[left -> node]从节点 %s 回到节点 %s\n", root.left, root);
        System.out.printf("\t[node -> right]从节点 %s 进入节点 %s\n", root, root.right);
        traverse(root.right);
        // 【后序】
        System.out.printf("\t[right -> node]从节点 %s 回到节点 %s\n", root.right, root);
    }

}
