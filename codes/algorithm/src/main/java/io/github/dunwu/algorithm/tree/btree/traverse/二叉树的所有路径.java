package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Collections;
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
        Assertions.assertArrayEquals(Arrays.asList("1->2->5", "1->3").toArray(),
            s.binaryTreePaths(TreeNode.buildTree(1, 2, 3, 5)).toArray());
        Assertions.assertArrayEquals(Collections.singletonList("1").toArray(),
            s.binaryTreePaths(TreeNode.buildTree(1)).toArray());
    }

    static class Solution {

        LinkedList<String> res = null;
        LinkedList<String> paths = null;

        public List<String> binaryTreePaths(TreeNode root) {
            res = new LinkedList<>();
            paths = new LinkedList<>();
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

            // 【前序】
            // System.out.format("root: %s -> root.left: %s\n", root.val, root.left.val);
            traverse(root.left);
            // 【中序】
            // System.out.format("root.left: %s -> root: %s\n", root.left.val, root.val);
            // System.out.format("root: %s -> root.right: %s\n", root.val, root.right.val);
            traverse(root.right);
            // 【后序】
            // System.out.format("root.right: %s -> root: %s\n", root.right.val, root.val);

            // 取消选择
            paths.removeLast();
        }

    }

}
