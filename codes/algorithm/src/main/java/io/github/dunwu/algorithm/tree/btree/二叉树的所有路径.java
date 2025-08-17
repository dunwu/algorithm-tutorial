package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-paths/">二叉树的所有路径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2025-08-15
 */
public class 二叉树的所有路径 {

    public static void main(String[] args) {

        Solution s = new Solution();
        TreeNode tree = TreeUtils.buildTree(1, 2, 3, 5);
        List<String> list = s.binaryTreePaths(tree);
        Assertions.assertArrayEquals(Arrays.asList("1->2->5", "1->3").toArray(),
            list.toArray(new String[0]));
    }

    static class Solution {

        LinkedList<String> nodes = new LinkedList<>();
        List<String> paths = new LinkedList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            traverse(root);
            return paths;
        }

        public void traverse(TreeNode root) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                nodes.addLast(String.valueOf(root.val));
                String path = String.join("->", nodes.toArray(new String[0]));
                paths.add(path);
                nodes.removeLast();
                return;
            }

            nodes.addLast(String.valueOf(root.val));
            traverse(root.left);
            traverse(root.right);
            nodes.removeLast();
        }

    }

}
