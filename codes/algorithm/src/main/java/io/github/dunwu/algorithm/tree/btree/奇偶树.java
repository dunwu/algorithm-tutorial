package io.github.dunwu.algorithm.tree.btree;

import io.github.dunwu.algorithm.tree.TreeNode;
import io.github.dunwu.algorithm.tree.TreeUtils;
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
        Assertions.assertTrue(s.isEvenOddTree(TreeUtils.buildTree(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2)));
        Assertions.assertFalse(s.isEvenOddTree(TreeUtils.buildTree(5, 4, 2, 3, 3, 7)));
    }

    static class Solution {

        public boolean isEvenOddTree(TreeNode root) {

            if (root == null) { return false; }

            LinkedList<TreeNode> q = new LinkedList<>();
            q.offer(root);

            int depth = 0;
            while (!q.isEmpty()) {
                Integer lastValue = null;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = q.poll();
                    if (!check(depth, node.val, lastValue)) {
                        return false;
                    }
                    if (node.left != null) { q.offer(node.left); }
                    if (node.right != null) { q.offer(node.right); }
                    lastValue = node.val;
                }
                depth++;
            }
            return true;
        }

        public boolean check(int depth, int val, Integer lastValue) {
            // 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
            // 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
            if (depth % 2 == 0) {
                if (val % 2 == 0) {
                    return false;
                }
                if (lastValue != null && val <= lastValue) {
                    return false;
                }
            } else {
                if (val % 2 != 0) {
                    return false;
                }
                if (lastValue != null && val >= lastValue) {
                    return false;
                }
            }
            return true;
        }

    }

}
