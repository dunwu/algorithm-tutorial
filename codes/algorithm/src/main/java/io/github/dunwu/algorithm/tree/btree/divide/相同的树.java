package io.github.dunwu.algorithm.tree.btree.divide;

import io.github.dunwu.algorithm.tree.TreeNode;
import org.junit.jupiter.api.Assertions;

/**
 * <a href="https://leetcode-cn.com/problems/same-tree/">100. 相同的树</a>
 *
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @date 2020-01-28
 */
public class 相同的树 {

    public static void main(String[] args) {
        Solution s = new Solution();
        Assertions.assertTrue(s.isSameTree(TreeNode.buildTree(1, 2, 3), TreeNode.buildTree(1, 2, 3)));
        Assertions.assertFalse(s.isSameTree(TreeNode.buildTree(1, 2), TreeNode.buildTree(1, 2, 3)));
        Assertions.assertFalse(s.isSameTree(TreeNode.buildTree(1, 2, 1), TreeNode.buildTree(1, 1, 2)));
    }

    static class Solution {

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) { return true; }
            if (p == null || q == null) { return false; }
            if (p.val != q.val) { return false; }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }

    }

}
