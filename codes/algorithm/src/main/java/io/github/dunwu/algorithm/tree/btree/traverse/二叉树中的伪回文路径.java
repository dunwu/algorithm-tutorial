package io.github.dunwu.algorithm.tree.btree.traverse;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/">1457. 二叉树中的伪回文路径</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-15
 */
public class 二叉树中的伪回文路径 {

    public static void main(String[] args) {
        Assertions.assertEquals(2,
            new Solution().pseudoPalindromicPaths(TreeNode.buildTree(2, 3, 1, 3, 1, null, 1)));
        Assertions.assertEquals(1,
            new Solution().pseudoPalindromicPaths(TreeNode.buildTree(2, 1, 1, 1, 3, null, null, null, null, null, 1)));
    }

    static class Solution {

        int num = 0;
        LinkedList<Integer> paths = new LinkedList<>();

        public int pseudoPalindromicPaths(TreeNode root) {
            traverse(root);
            return num;
        }

        public void traverse(TreeNode root) {
            if (root == null) { return; }

            paths.addLast(root.val);
            if (root.left == null && root.right == null) {
                // System.out.println("paths: " + paths);
                if (isPalindromic(paths)) {
                    num++;
                }
            } else {
                traverse(root.left);
                traverse(root.right);
            }
            paths.removeLast();
        }

        public boolean isPalindromic(LinkedList<Integer> paths) {
            if (paths.isEmpty()) { return false; }
            if (paths.size() == 1) { return true; }
            Map<Integer, Integer> counter = new HashMap<>(paths.size());
            for (Integer path : paths) {
                counter.compute(path, (k, v) -> v == null ? 1 : v + 1);
            }
            int oddNum = 0;
            for (Integer v : counter.values()) {
                if (v % 2 != 0) {
                    oddNum++;
                }
            }
            return oddNum < 2;
        }

    }

}
