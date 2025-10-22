package io.github.dunwu.algorithm.tree.btree.bfs;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/even-odd-tree/">1609. 奇偶树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2025-08-18
 */
public class 奇偶树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isEvenOddTree(TreeNode.buildTree(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2)));
        Assertions.assertFalse(s.isEvenOddTree(TreeNode.buildTree(5, 4, 2, 3, 3, 7)));
        Assertions.assertFalse(s.isEvenOddTree(TreeNode.buildTree(5, 9, 1, 3, 5, 7)));
        Assertions.assertTrue(s.isEvenOddTree(TreeNode.buildTree(1)));
        Assertions.assertTrue(
            s.isEvenOddTree(TreeNode.buildTree(11, 8, 6, 1, 3, 9, 11, 30, 20, 18, 16, 12, 10, 4, 2, 17)));
    }

    static class Solution {

        public boolean isEvenOddTree(TreeNode root) {
            if (root == null) return false;
            int level = 0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                boolean odd = level % 2 != 0;
                Integer lastVal = null;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (odd) {  // 奇数层
                        // 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
                        if (node.val % 2 != 0) { return false; }
                        if (lastVal != null && node.val >= lastVal) { return false; }
                    } else {    // 偶数层
                        // 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
                        if (node.val % 2 == 0) { return false; }
                        if (lastVal != null && node.val <= lastVal) { return false; }
                    }
                    lastVal = node.val;
                    if (node.left != null) { queue.offer(node.left); }
                    if (node.right != null) { queue.offer(node.right); }
                }
                level++;
            }
            return true;
        }

    }

}
