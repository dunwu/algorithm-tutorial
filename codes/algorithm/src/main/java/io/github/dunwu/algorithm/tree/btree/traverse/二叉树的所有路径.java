package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-paths/">二叉树的所有路径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-15
 */
public class 二叉树的所有路径 {

    public static void main(String[] args) {

        Solution s = new Solution();
        TreeNode tree = TreeNode.buildTree(1, 2, 3, 5);
        List<String> list = s.binaryTreePaths(tree);
        Assertions.assertArrayEquals(Arrays.asList("1->2->5", "1->3").toArray(),
            list.toArray(new String[0]));
    }

    static class Solution {

        LinkedList<String> res = new LinkedList<>();
        LinkedList<String> paths = new LinkedList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            traverse(root);
            return res;
        }

        public void traverse(TreeNode root) {
            if (root == null) { return; }

            // 选择
            paths.addLast(String.valueOf(root.val));
            if (root.left == null && root.right == null) {
                res.addLast(String.join("->", paths));
                // System.out.printf("res: %s\n", JSONUtil.toJsonStr(res));
            }

            // 遍历左子树
            if (root.left != null) {
                // System.out.format("root: %s -> root.left: %s\n", root.val, root.left.val);
                traverse(root.left);
                // System.out.format("root.left: %s -> root: %s\n", root.left.val, root.val);
            }

            // 遍历右子树
            if (root.right != null) {
                // System.out.format("root: %s -> root.right: %s\n", root.val, root.right.val);
                traverse(root.right);
                // System.out.format("root.right: %s -> root: %s\n", root.right.val, root.val);
            }

            // 取消选择
            paths.removeLast();
        }

    }

}
