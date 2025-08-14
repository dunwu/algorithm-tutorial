package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/">144. 二叉树的前序遍历</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-11
 */
public class 二叉树的前序遍历 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(1, null, 2, 3);
        List<Integer> list = preorderTraversal(tree);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, list.toArray(new Integer[0]));
    }

    static List<Integer> res = new ArrayList<>();

    /**
     * 遍历思路的递归
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    public static void traverse(TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * 分解思路的递归
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraversal(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preorderTraversal(root.right));
        return res;
    }

}
