package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-07-06
 */
public class 二叉树的前序遍历 {

    public static void main(String[] args) {
        TreeNode tree = TreeUtils.buildTree(new Integer[] { 1, null, 2, 3 });
        List<Integer> list = preorderTraversal(tree);
        Assertions.assertArrayEquals(new Integer[] { 1, 2, 3 }, list.toArray(new Integer[0]));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        backtrack(root, list);
        return list;
    }

    public static void backtrack(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        if (root.left != null) backtrack(root.left, list);
        if (root.right != null) backtrack(root.right, list);
    }

}
